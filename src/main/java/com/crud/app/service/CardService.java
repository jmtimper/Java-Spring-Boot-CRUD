package com.crud.app.service;

import com.crud.app.model.Card;
import com.crud.app.model.Customer;
import com.crud.app.repository.CardRepository;
import com.crud.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public Card findCardById(Long id) {
        Optional<Card> cus = repository.findById(id);
         if (cus.isPresent()) {
             return cus.get();
         } else {
             throw new Error(String.format("Card to get not found for id: %s", id));
         }
    }

    public Long deleteCardById(Long id) {
        Optional<Card> cus = repository.findById(id);
        if (cus.isPresent()) {
            repository.delete(cus.get());
            return cus.get().getId();
        } else {
            throw new Error(String.format("Card to delete not found for id: %s", id));
        }
    }

    public Card insertNewCard(Card newCard) {
        if (newCard.getId() == null) {
            return repository.save(newCard);
        } else {
            throw new Error("Cannot insert Card with id");
        }
    }

    public Card putCard(Card newCard) {
        if (newCard.getId() != null) {
            return repository.save(newCard);
        } else {
            throw new Error("Cannot update Card with null id");
        }
    }
}
