package com.crud.app.controller;

import com.crud.app.model.Card;
import com.crud.app.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        Card card = cardService.findCardById((long) id);
        return ResponseEntity.status(HttpStatus.OK).body(card);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteCardById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.deleteCardById((long) id));
    }

    @PostMapping("/post")
    @ResponseBody
    public Card postCard(@RequestBody Card card) {
        return cardService.insertNewCard(card);
    }

    @PutMapping("/put")
    @ResponseBody
    public Card putCard(@RequestBody Card card) {
        return cardService.putCard(card);
    }
}