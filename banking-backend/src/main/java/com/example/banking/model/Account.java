package com.example.banking.model;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private String accountNumber;
    private String customerName;
    private BigDecimal balance;

    public Account(Long id, String accountNumber,
                   String customerName, BigDecimal balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}