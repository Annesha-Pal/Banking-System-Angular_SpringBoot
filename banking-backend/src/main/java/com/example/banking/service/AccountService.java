package com.example.banking.service;

import com.example.banking.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final Account account = new Account(
            1L,
            "1001",
            "Rahul Sharma",
            new BigDecimal("25000.00")
    );

    public Account getAccount() {
        return account;
    }

    public Account deposit(BigDecimal amount) {

        validateAmount(amount);

        account.setBalance(
                account.getBalance().add(amount)
        );

        return account;
    }

    public Account withdraw(BigDecimal amount) {

        validateAmount(amount);

        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException(
                    "Insufficient balance."
            );
        }

        account.setBalance(
                account.getBalance().subtract(amount)
        );

        return account;
    }

    private void validateAmount(BigDecimal amount) {

        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Amount must be greater than zero."
            );
        }
    }
}