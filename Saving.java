package edu.gcu.bootcamp.cst135.milestone.model;

public class Saving extends Account {

	private double minBalance = 200.00;
	private double interest = .06;
	private double serviceFee = 25.00;

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest / 12;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Saving(String accountNum, double balance) {
		super(accountNum, balance);
	}
}