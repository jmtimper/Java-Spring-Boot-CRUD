package com.crud.app.repository;

import com.crud.app.model.Card;
import com.crud.app.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {

    Card findById(long id);
}