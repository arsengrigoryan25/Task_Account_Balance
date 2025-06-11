package com.example.DTO;

import com.example.enums.BalanceType;
import com.example.enums.Currency;

import java.util.Date;
import java.util.UUID;

public class Transactions {
    private final UUID id = UUID.randomUUID();;
    private String name;
    private double amount;
    private BalanceType balanceType;
    private Currency currency;
    private String timestamp;

    public Transactions() {}
    public Transactions(String name, double amount, BalanceType balanceType, Currency currency) {
        this.name = name;
        this.amount = amount;
        this.balanceType = balanceType;
        this.currency = currency;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BalanceType getBalanceType() {
        return balanceType;
    }
    public void setBalanceType(BalanceType balanceType) {
        this.balanceType = balanceType;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
