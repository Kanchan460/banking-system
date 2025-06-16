package com.bank.service;

import com.bank.model.*;
import com.bank.repository.*;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;

@Service
public class BankingService {
    private final UserRepository userRepo;
    private final AccountRepo accountRepo;
    private final TransactionRepo txnRepo;

    public BankingService(UserRepository userRepo, AccountRepo accountRepo, TransactionRepo txnRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
        this.txnRepo = txnRepo;
    }

    public User register(User user) {
        return userRepo.save(user);
    }

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }

    public List<Transaction> transfer(String fromAcc, String toAcc, double amount) {
        Account from = accountRepo.findByAccountNumber(fromAcc);
        Account to = accountRepo.findByAccountNumber(toAcc);

        if (from.getBalance() >= amount) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            accountRepo.save(from);
            accountRepo.save(to);

            Transaction txn = new Transaction();
            txn.setFromAccount(fromAcc);
            txn.setToAccount(toAcc);
            txn.setAmount(amount);
            txn.setDate(LocalDateTime.now());
            txnRepo.save(txn);

            return List.of(txn);
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }

    public List<Transaction> getAllTransactions() {
        return txnRepo.findAll();
    }

    public double getBalance(String accNo) {
        return accountRepo.findByAccountNumber(accNo).getBalance();
    }
}
