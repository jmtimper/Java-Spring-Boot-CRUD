package com.crud.app.controller;

import com.crud.app.model.Account;
import com.crud.app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        Account acc = accountService.findAccountById((long) id);
        return ResponseEntity.status(HttpStatus.OK).body(acc);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteAccountById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.deleteAccountById((long) id));
    }

    @PostMapping("/post")
    @ResponseBody
    public Account postAccount(@RequestBody Account account) {
        return accountService.insertNewAccount(account);
    }

    @PutMapping("/put")
    @ResponseBody
    public Account putAccount(@RequestBody Account account) {
        return accountService.putAccount(account);
    }
}