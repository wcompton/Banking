package edu.gcu.bootcamp.cst135.milestone.model;

import java.util.Date;

public class Customer {
	String firstName;
	String lastName;
	String username;
	String password;
	Date dateopened;
	//creates the objects of saving, checking, and loan creating composition allowing daisy chain of calling to invoke methods 
	//within the bank class by generating getters and setters for the objects created
	private Saving saving = new Saving(randomNumberGenerator(), 500);
	private Checking checking = new Checking(randomNumberGenerator(), 2500);
	private Loan loan = new Loan(randomNumberGenerator(), -5000);

	public Customer(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.dateopened = new Date();
	}
	//random account number generator
	public String randomNumberGenerator() {
		String random = "" + (int) ((Math.random() * 90000000) + 1000000);
		return random;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateopened() {
		return dateopened;
	}

	public void setDateopened(Date dateopened) {
		this.dateopened = dateopened;
	}

	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public Checking getChecking() {
		return checking;
	}

	public void setChecking(Checking checking) {
		this.checking = checking;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", dateopened=" + dateopened + "]";
	}
}