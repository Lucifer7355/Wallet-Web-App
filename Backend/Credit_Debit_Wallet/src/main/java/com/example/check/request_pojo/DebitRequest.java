package com.example.check.request_pojo;

import java.math.BigDecimal;

public class DebitRequest {
	String accountNumber;
	BigDecimal currentBalance;
	public DebitRequest(String accountNumber, BigDecimal currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
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
	public DebitRequest() {
		super();
	}
	@Override
	public String toString() {
		return "DebitRequest [accountNumber=" + accountNumber + ", currentBalance=" + currentBalance
				+ ", getAccountNumber()=" + getAccountNumber() + ", getCurrentBalance()=" + getCurrentBalance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
