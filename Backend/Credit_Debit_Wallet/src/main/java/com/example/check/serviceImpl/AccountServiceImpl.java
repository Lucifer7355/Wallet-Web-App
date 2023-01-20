package com.example.check.serviceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.check.model.*;
import com.example.check.repository.AccountRepository;
import com.example.check.repository.TransactionRepository;
import com.example.check.request_pojo.AccountStatement;
import com.example.check.request_pojo.CreditRequest;
import com.example.check.request_pojo.DebitRequest;
import com.example.check.request_pojo.TransferBalanceRequest;
import com.example.check.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Account save(Account account){
    	Account gg = accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    	if(gg==null) {
    		accountRepository.save(account);
    	}
        return accountRepository.findByAccountNumberEquals(account.getAccountNumber());
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber){
        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
        return account;
    }


    @Override
    @Transactional
    public Transaction sendMoney(TransferBalanceRequest x) {
    	System.out.println(x);
        String fromAccountNumber = x.getFromAccountNumber();
        String toAccountNumber = x.getToAccountNumber();
        BigDecimal amount = x.getAmount();
        Account fromAccount = accountRepository.findByAccountNumberEquals(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumberEquals(toAccountNumber);
        System.out.println(fromAccount);
        System.out.println(toAccount);
        
        if(fromAccount.getCurrentBalance().compareTo(BigDecimal.ONE) == 1 && fromAccount.getCurrentBalance().compareTo(amount) == 1){
            fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
            accountRepository.save(fromAccount);
            toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
            accountRepository.save(toAccount);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String details = "transfering money to "+toAccount.getAccountNumber();
            Transaction transaction = transactionRepository.save(new Transaction(0L,fromAccountNumber,amount,timestamp,details));
            return transaction;
        }
        return null;
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        Account account = accountRepository.findByAccountNumberEquals(accountNumber);
        return new AccountStatement(account.getCurrentBalance(),transactionRepository.findByAccountNumberEquals(accountNumber));
    }

	@Override
	public Account adding(CreditRequest account) {
		// TODO Auto-generated method stub
		Account gg = accountRepository.findByAccountNumberEquals(account.getAccountNumber());
        BigDecimal dd1 = gg.getCurrentBalance();
        BigDecimal dd2 = account.getCurrentBalance();
        BigDecimal sum = dd1.add(dd2);
        gg.setCurrentBalance(sum);
        accountRepository.save(gg);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction transaction = transactionRepository.save(new Transaction(0L,account.getAccountNumber(),account.getCurrentBalance(),timestamp,"credited"));
		return gg;
	}

	@Override
	public Account minus(DebitRequest account) {
		Account gg = accountRepository.findByAccountNumberEquals(account.getAccountNumber());
        BigDecimal dd1 = gg.getCurrentBalance();
        BigDecimal dd2 = account.getCurrentBalance();
        BigDecimal sum = dd1.subtract(dd2);
        gg.setCurrentBalance(sum);
        accountRepository.save(gg);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Transaction transaction = transactionRepository.save(new Transaction(0L,account.getAccountNumber(),account.getCurrentBalance(),timestamp,"debited"));
		return gg;
	}

	@Override
	public List<Account> saveAll(List<Account> account) {
		accountRepository.saveAll(account);
		return account;
	}

	@Override
	public String findBalance(String accountNumber) {
		Account gg = accountRepository.findByAccountNumberEquals(accountNumber);
		return gg.getCurrentBalance().toString();
	}
}
