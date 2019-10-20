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
	//a new date object is created with every transaction object created. updated balance was
	public Transaction(String accountNumber, double amount, String type, double updatedBalance) {
		// TODO Auto-generated constructor stub
		this.transactionDate = new Date();
		this.accountName = accountNumber;
		this.amount = amount;
		this.type = type;
		this.updatedBalance = updatedBalance;
	}
	// getter for transaction date
	public Date getTransactionDate() {
		return transactionDate;
	}
	// setter for transaction date
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	// getter for account number
	public String getAccountName() {
		return accountName;
	}
	// setter for account number
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	// getter for transaction amount
	public double getAmount() {
		return amount;
	}
	// setter for transaction amount
	public void setAmount(double amount) {
		this.amount = amount;
	}
	// getter for account type
	public String getType() {
		return type;
	}
	// setter for account type
	public void setType(String type) {
		this.type = type;
	}
	// getter for updated balance
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	// setter for updated balance
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	//to string for transaction
	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", accountName=" + accountName + ", amount=" + amount
				+ ", type=" + type + ", updatedBalance=" + updatedBalance + "]";
	}

}
