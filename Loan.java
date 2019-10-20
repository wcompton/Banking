package edu.gcu.bootcamp.cst135.milestone.model;

public class Loan extends Account {

	public Loan(String accountNumber, double accountBalance) {
		super(accountNumber, accountBalance);
			// TODO Auto-generated constructor stub
	}

	private double interestRate;
	private double lateFee;

	public void doEndOfMonthInterest() {
	}

	public void checkLateFee() {

	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

}
