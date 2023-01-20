package com.example.check.request_pojo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
import com.example.check.model.Transaction;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement {
    BigDecimal currentBalance;
    List<Transaction> transactionHistory;
	public AccountStatement(BigDecimal currentBalance, List<Transaction> transactionHistory) {
		super();
		this.currentBalance = currentBalance;
		this.transactionHistory = transactionHistory;
	}
	public AccountStatement() {
		super();
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	public List<Transaction> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Transaction> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	@Override
	public String toString() {
		return "AccountStatement [currentBalance=" + currentBalance + ", transactionHistory=" + transactionHistory
				+ ", getCurrentBalance()=" + getCurrentBalance() + ", getTransactionHistory()="
				+ getTransactionHistory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
}