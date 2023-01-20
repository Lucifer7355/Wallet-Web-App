package com.example.check.service;

import java.util.List;

import com.example.check.model.Account;
import com.example.check.model.Transaction;
import com.example.check.request_pojo.AccountStatement;
import com.example.check.request_pojo.CreditRequest;
import com.example.check.request_pojo.DebitRequest;
import com.example.check.request_pojo.TransferBalanceRequest;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    List<Account> saveAll(List<Account> account);
    Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);
    AccountStatement getStatement(String accountNumber);
    Account adding(CreditRequest account);
    Account minus(DebitRequest account);
    String findBalance(String accountNumber);
}