package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.AccountService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Account getAccount() {
        return accountService.getAccount();
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestBody TransactionRequest request) {

        try {
            return accountService.deposit(request.amount());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody TransactionRequest request) {

        try {
            return accountService.withdraw(request.amount());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    public record TransactionRequest(BigDecimal amount) {
    }
}