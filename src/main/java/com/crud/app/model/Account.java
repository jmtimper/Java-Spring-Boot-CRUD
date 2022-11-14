package com.crud.app.model;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    public enum AccountType {Checking, Savings, Loan, Other};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;

    protected Account() {
    }

    public Account(String number, AccountType type, Long customerId) {
        this.number = number;
        this.type = type;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Account id=" + this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}