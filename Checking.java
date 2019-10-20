package edu.gcu.bootcamp.cst135.milestone.model;

public class Checking extends Account {
	private double overdraft = 25.00;

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public Checking(String accountNumber, double accountBalance) {
		super(accountNumber, accountBalance);
			}
}