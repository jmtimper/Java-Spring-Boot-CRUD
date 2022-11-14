package com.crud.app.service;

import com.crud.app.model.Account;
import com.crud.app.model.Customer;
import com.crud.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer findCustomerById(Long id) {
        Optional<Customer> cus = repository.findById(id);
         if (cus.isPresent()) {
             return cus.get();
         } else {
             throw new Error(String.format("Customer to get not found for id: %s", id));
         }
    }

    public Long deleteCustomerById(Long id) {
        Optional<Customer> cus = repository.findById(id);
        if (cus.isPresent()) {
            repository.delete(cus.get());
            return cus.get().getId();
        } else {
            throw new Error(String.format("Customer to delete not found for id: %s", id));
        }
    }

    public Customer insertNewCustomer(Customer customer) {
        if (customer.getId() == null) {
            return repository.save(customer);
        } else {
            throw new Error("Cannot insert Customer with id");
        }
    }

    public Customer putCustomer(Customer cus) {
        if (cus.getId() != null) {
            return repository.save(cus);
        } else {
            throw new Error("Cannot update Customer with null id");
        }
    }}
