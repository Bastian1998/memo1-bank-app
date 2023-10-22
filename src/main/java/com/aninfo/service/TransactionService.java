package com.aninfo.service;

import com.aninfo.enums.TransactionType;
import com.aninfo.model.Account;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    public Transaction createTransaction(Double amount, Account account, TransactionType type) {
        Transaction newTransaction = new Transaction(amount, account, type);
        return transactionRepository.save(newTransaction);
    }

    public Transaction findById(Long cbu) {
        return transactionRepository.findById(cbu).orElse(null);
    }

    public List<Transaction> findTransactionsByAccount(Long cbu) {
        Account account = accountService.findById(cbu).orElse(null);
        return transactionRepository.findTransactionsByAccount(account);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}