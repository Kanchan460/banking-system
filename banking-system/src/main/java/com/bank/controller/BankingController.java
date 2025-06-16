package com.bank.controller;

import com.bank.model.*;
import com.bank.service.BankingService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class BankingController {
    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return bankingService.register(user);
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return bankingService.createAccount(account);
    }

    @PostMapping("/transfer")
    public List<Transaction> transfer(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        return bankingService.transfer(from, to, amount);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return bankingService.getAllTransactions();
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam String accountNumber) {
        return bankingService.getBalance(accountNumber);
    }
}
