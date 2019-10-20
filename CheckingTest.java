package edu.gcu.bootcamp.cst135.milestone.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckingTest {
	Checking checking = new Checking("Test", 50.40);
	@Test
	public void testGetOverdraft() {
		final double overDraft = 25.00;
		assertEquals("Overdraft test fails", checking.getOverdraft(), overDraft, 0.001); 
	}

	@Test
	public void testSetOverdraft() {
		final double overDraft = 25.00;
		assertEquals("Overdraft test fails", checking.getOverdraft(), overDraft, 0.001); 
	}

	@Test
	public void testChecking() {
		final double accountBalance = 50.40;
		final String accountNumber = "Test";
		assertEquals("Checking test fails", checking.getAccountBalance(), accountBalance, 0.001);
		assertEquals("Checking test fails", checking.getAccountNumber(), accountNumber);
	}

	@Test
	public void testGetAccountNumber() {
		final String accountNumber = "Test";
		assertEquals("Checking test fails", checking.getAccountNumber(), accountNumber);
	}

	@Test
	public void testSetAccountNumber() {
		final String accountNumber = "Test";
		assertEquals("Checking test fails", checking.getAccountNumber(), accountNumber);
	}

	@Test
	public void testGetAccountBalance() {
		final double accountBalance = 50.40;
		assertEquals("Checking test fails", checking.getAccountBalance(), accountBalance, 0.001);
	}

	@Test
	public void testSetAccountBalance() {
		final double accountBalance = 50.40;
		assertEquals("Checking test fails", checking.getAccountBalance(), accountBalance, 0.001);
	}

}
