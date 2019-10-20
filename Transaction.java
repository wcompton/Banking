package edu.gcu.bootcamp.cst135.milestone.model;

import java.util.Date;

public class Transaction {
	private Date transactionDate;
	private String accountName;
	private double amount;
	private String type;
	//added so I can print an updated balance with each transaction
	private double updatedBalance;
	
	//constructor for Transaction transctionDate does not need to be passed as a parameter because
	//a new date object is created with every transaction object created
	public Transaction(String accountNumber, double amount, String type, double updatedBalance) {
		// TODO Auto-generated constructor stub
		this.transactionDate = new Date();
		this.accountName = accountNumber;
		this.amount = amount;
		this.type = type;
		this.updatedBalance = updatedBalance;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}

	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", accountName=" + accountName + ", amount=" + amount
				+ ", type=" + type + ", updatedBalance=" + updatedBalance + "]";
	}

}
