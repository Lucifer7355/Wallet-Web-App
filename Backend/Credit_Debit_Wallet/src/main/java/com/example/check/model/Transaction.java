package com.example.check.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;

    private String accountNumber;

    private BigDecimal transactionAmount;

    private Timestamp transactionDateTime;
    
    private String transactiontype;
    
    
	public Transaction(Long transactionId, String accountNumber, BigDecimal transactionAmount,
			Timestamp transactionDateTime, String transactiontype) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
		this.transactiontype = transactiontype;
	}

	public Transaction(String accountNumber, BigDecimal transactionAmount, Timestamp transactionDateTime,
			String transactiontype) {
		super();
		this.accountNumber = accountNumber;
		this.transactionAmount = transactionAmount;
		this.transactionDateTime = transactionDateTime;
		this.transactiontype = transactiontype;
	}

	public Transaction() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Timestamp transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionAmount=" + transactionAmount + ", transactionDateTime=" + transactionDateTime
				+ ", transactiontype=" + transactiontype + ", getTransactionId()=" + getTransactionId()
				+ ", getAccountNumber()=" + getAccountNumber() + ", getTransactionAmount()=" + getTransactionAmount()
				+ ", getTransactionDateTime()=" + getTransactionDateTime() + ", getTransactiontype()="
				+ getTransactiontype() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
	
    
}