package com.example.check.controller;

import java.util.List;

import com.example.check.response_pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.check.model.Account;
import com.example.check.request_pojo.AccountStatementRequest;
import com.example.check.request_pojo.CreditRequest;
import com.example.check.request_pojo.DebitRequest;
import com.example.check.request_pojo.TransferBalanceRequest;
import com.example.check.service.AccountService;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired private AccountService accountService;
	private AccountStatementRequest accountStatementRequest;
    @RequestMapping("/create")
    public String create(@RequestBody Account account) {
        accountService.save(account);
        return "account created";
    }
    @RequestMapping("/createAll")
    public List<Account> createAll(@RequestBody List<Account> account) {
        accountService.saveAll(account);
        return accountService.findAll();
    }
    @RequestMapping("/addmoney")
    public Account credit(@RequestBody CreditRequest request) {
        return accountService.adding(request);
    }
    @RequestMapping("/withdrawmoney")
    public Account debit(@RequestBody DebitRequest account) {
        return accountService.minus(account);
    }
    @RequestMapping("/all")
    public List<Account> all() {
        return accountService.findAll();
    }
    @RequestMapping("/getbalance/{a}")
    public String balance(@PathVariable("a") String aNumber) {
        return accountService.findBalance(aNumber);
    }
    @RequestMapping("/sendmoney")
    public Response sendMoney(@RequestBody TransferBalanceRequest x) {

        return Response.ok().setPayload(accountService.sendMoney(x));
    }
    @RequestMapping("/statement")
    public Response getStatement(@RequestBody AccountStatementRequest x){
       
		return Response.ok().setPayload(accountService.getStatement(x.getAccountNumber()));

    }

}