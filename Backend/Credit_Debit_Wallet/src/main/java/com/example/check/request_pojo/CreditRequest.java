package com.example.check.request_pojo;

import java.math.BigDecimal;

public class CreditRequest {
	String accountNumber;
	BigDecimal currentBalance;
	public CreditRequest(String accountNumber, BigDecimal currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
	}
	public CreditRequest() {
		super();
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	@Override
	public String toString() {
		return "CreditRequest [accountNumber=" + accountNumber + ", currentBalance=" + currentBalance
				+ ", getAccountNumber()=" + getAccountNumber() + ", getCurrentBalance()=" + getCurrentBalance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
