package com.crud.app.service;

import com.crud.app.model.Account;
import com.crud.app.model.Card;
import com.crud.app.model.Customer;
import com.crud.app.repository.AccountRepository;
import com.crud.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account findAccountById(Long id) {
        Optional<Account> acc = repository.findById(id);
         if (acc.isPresent()) {
             return acc.get();
         } else {
             throw new Error(String.format("Account to get not found for id: %s", id));
         }
    }

    public Long deleteAccountById(Long id) {
        Optional<Account> acc = repository.findById(id);
        if (acc.isPresent()) {
            repository.delete(acc.get());
            return acc.get().getId();
        } else {
            throw new Error(String.format("Account to delete not found for id: %s", id));
        }
    }

    public Account insertNewAccount(Account newAccount) {
        if (newAccount.getId() == null) {
            return repository.save(newAccount);
        } else {
            throw new Error("Cannot insert Account with id");
        }
    }

    public Account putAccount(Account acc) {
        if (acc.getId() != null) {
            return repository.save(acc);
        } else {
            throw new Error("Cannot update Account with null id");
        }
    }
}
