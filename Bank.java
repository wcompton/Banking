package edu.gcu.bootcamp.cst135.milestone.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import edu.gcu.bootcamp.cst135.milestone.model.Customer;
import edu.gcu.bootcamp.cst135.milestone.model.Transaction;

public class Bank {
	// private means the variable is limited to this class
	// static means it is used in every object
	// final means the value is constant, it will not change based on an instance of
	// the object
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	// this code initiates an arraylist called translist
	private ArrayList<Transaction> translist = new ArrayList<Transaction>();
	Scanner scanner = new Scanner(System.in);
	Customer blank = new Customer("Mike", "Ditka", "mditka", "mditka85Bears!");
	
	//login method presents options to user
	public void loginScreen() {
		System.out.println("=======================");
		System.out.println("Main Menu");
		System.out.println("=======================");
		System.out.println("7: Login");
		System.out.println("8: Exit Bank");
		int option = getUserMenuChoice();
		processCustomerLogin(option);
	}
	//method pulls user entry from console to process in switch statement
	private int getUserMenuChoice() {
		int y = 1;
		// x sets the condition to cycle the menu for improper user input
		int x = 0;
		while (x == 0) {
			String z = scanner.nextLine();

			try {
				y = Integer.parseInt(z);
				x = 1;
			} catch (Exception e) {
				System.out.println("Expecting a numeric menu choice. Please try again.");
				x = 0;
			}
		}
		return y;
	}
	//switch statement indicates which method to invoke based on user choice
	private void processCustomerLogin(int option) {
		switch (option) {
		case 7:
			LOGGER.info("User is selecting user");
			viewCustomerLoginMenu();
			break;
		case 8:
			LOGGER.info("User exited");
			// method display transactions will display all transactions that occurred
			// during this session before exiting the system
			viewExitScreen();
			break;
		default:
			LOGGER.info("User is dumb");
			loginScreen();
			break;
		}
	}
	//menu requests user to enter username and password
	private void viewCustomerLoginMenu() {
		System.out.println("=======================");
		System.out.println("Main Menu - Customers");
		System.out.println("=======================");
		System.out.println("Enter Username:");
		System.out.println("Enter Password:");
		processUsernmeAndPassword();
	}
	//method requests two entries (username & password) from user, and verifies they match the 
	//username and password for login if sucessful customer menu will be displayedF
	private void processUsernmeAndPassword() {

		String entry = scanner.nextLine();
		String entry2 = scanner.nextLine();
		if (entry.equals(blank.getUsername()) && entry2.equals(blank.getPassword())) {
			viewCustomerMenu();
		} else {
			System.out.println("Username and Password do not match. Please try again");
			loginScreen();
		}
	}

	public void viewCustomerMenu() {
		// try {
		int option;
		do {
			System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("                MAIN MENU");
			System.out.println("                GCU BANK");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Pick an option: ");
			System.out.println("-----------------------");
			System.out.println(" 1: Deposit to Checking");
			System.out.println(" 2: Deposit to Savings");
			System.out.println(" 3: Withdraw from Checking");
			System.out.println(" 4: Withdraw from Savings");
			System.out.println(" 5: Get balance");
			System.out.println(" 6: Get monthly statement");
			System.out.println("------------------------");
			System.out.println(" 9: : Logout");
			// most likely to throw an exception along with the parse
			// that was moved to the getUserMenuChoice method
			option = getUserMenuChoice();
			processCustomerMenu(option);
		} while (option != 9);
	}

	private void processCustomerMenu(int parseInt) {

		switch (parseInt) {
		case 1:
			LOGGER.info("User deposited check");
			viewDepositChecking();
			viewBalances();
			break;
		case 2:
			LOGGER.info("User deposited into Savings");
			viewDepositSavings();
			viewBalances();
			break;
		case 3:
			LOGGER.info("User withdrew from Checking");
			viewWithdrawalChecking();
			viewBalances();
			break;
		case 4:
			LOGGER.info("User withdrew from Savings");
			viewWithdrawalSavings();
			viewBalances();
			break;
		case 5:
			LOGGER.info("User viewed balance");
			viewBalances();
			break;
		case 6:
			// int j = 0;
			// commented out division will show a / by 0 error in the log
			// j = j / j;
			LOGGER.info("User conducted end of month");
			viewEndOfMonth();
			viewBalances();
			break;
		case 9:
			LOGGER.info("User exited");
			// method display transactions will display all transactions that occurred
			// during this session before exiting the system
			displayTransactions();
			break;
		default:
			LOGGER.info("User is dumb");
			viewCustomerMenu();
		}
	}

	// this method adds each transaction object created to arraylist translist
	private void addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		translist.add(t);
	}

	// this method prints each object individually from the arraylist. It is invoked
	// in the switch statement when the user logs out of the system
	private void displayTransactions() {
		// TODO Auto-generated method stub
		for (int i = 0; i < translist.size(); i++) {
			System.out.println(translist.get(i));
		}
	}

	private double getUserAmount() {
		double y = 1.0;
		int x = 0;
		while (x == 0) {
			String z = scanner.nextLine();
			x++;
			try {
				y = Double.parseDouble(z);
			} catch (Exception e) {
				System.out.println("Expecting a cash value. Please try again.");
				x = 0;
			}
		}
		return y;
	}

	private void viewEndOfMonth() {
		System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("               END OF MONTH");
		System.out.println("                 GCU BANK");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

		if (blank.getSaving().getAccountBalance() < blank.getSaving().getMinBalance()) {
			System.out.printf("A $%.2f service fee is being assessed for below minimum balance in savings",
					blank.getSaving().getServiceFee());
			blank.getSaving()
					.setAccountBalance(blank.getSaving().getAccountBalance() - blank.getSaving().getServiceFee());
			addTransaction(new Transaction(blank.getSaving().getAccountNumber(), blank.getSaving().getServiceFee(),
					"Service Fee", blank.getSaving().getAccountBalance()));
		}
		// addTransaction will add the new transaction to the araylist translist, an
		// arraylist of transction obejcts

		if (blank.getChecking().getAccountBalance() > 0) {
			double interestAmount = ((blank.getSaving().getInterest() / 12) * blank.getSaving().getAccountBalance());
			blank.getSaving().setAccountBalance(blank.getSaving().getAccountBalance() + interestAmount);
			System.out.printf("%nYou accrued $" + interestAmount + " for this period. Your updated balance is $"
					+ blank.getChecking().getAccountBalance());
			// addTransaction will add the new transaction to the araylist translist, an
			// arraylist of transction obejcts
			addTransaction(new Transaction(blank.getSaving().getAccountNumber(), interestAmount, "Accrued Interest",
					blank.getSaving().getAccountBalance()));
		}
	}

	private void viewWithdrawalChecking() {

		System.out.println("How much would you like to withdraw: ");
		double input = getUserAmount();
		processWithdrawalChecking(input);
	}

	private void processWithdrawalChecking(double input) {

		if (blank.getChecking().getAccountBalance() < input) {
			System.out.println("A $" + blank.getChecking().getOverdraft()
					+ " overdraft fee will be assessed if you continue. Continue Y or N?");
			if (scanner.nextLine().toLowerCase().equals("y")) {
				blank.getChecking().setAccountBalance(
						blank.getChecking().getAccountBalance() - input - blank.getChecking().getOverdraft());
				// addTransaction will add the new transaction to the araylist translist, an
				// arraylist of transction obejcts
				addTransaction(new Transaction(blank.getChecking().getAccountNumber(), input, "Checking Withdraw",
						blank.getChecking().getAccountBalance()));
			} else {
				viewWithdrawalChecking();
			}
		} else {
			blank.getChecking().setAccountBalance(blank.getChecking().getAccountBalance() - input);
			// addTransaction will add the new transaction to the araylist translist, an
			// arraylist of transction obejcts
			addTransaction(new Transaction(blank.getChecking().getAccountNumber(), input, "Checking Withdraw",
					blank.getChecking().getAccountBalance()));
		}
	}

	private void viewDepositSavings() {

		System.out.println("How much would you like to deposit: ");
		double input = getUserAmount();
		processDepositSavings(input);

	}

	private void processDepositSavings(double input) {

		blank.getSaving().setAccountBalance(blank.getSaving().getAccountBalance() + input);
		// addTransaction will add the new transaction to the araylist translist, an
		// arraylist of transction obejcts
		addTransaction(new Transaction(blank.getSaving().getAccountNumber(), input, "Savings Deposit",
				blank.getSaving().getAccountBalance()));
	}

	private void viewDepositChecking() {

		System.out.println("How much would you like to deposit: ");
		double input = getUserAmount();
		processDepositChecking(input);

	}

	private void processDepositChecking(double input) {

		blank.getChecking().setAccountBalance(blank.getChecking().getAccountBalance() + input);
		// addTransaction will add the new transaction to the araylist translist, an
		// arraylist of transction obejcts
		addTransaction(new Transaction(blank.getChecking().getAccountNumber(), input, "Checking Deposit",
				blank.getChecking().getAccountBalance()));
	}

	private void viewWithdrawalSavings() {

		System.out.println("How much would you like to withdraw: ");
		double input = getUserAmount();
		processWithdrawalSavings(input);
	}

	private void processWithdrawalSavings(double input) {

		blank.getSaving().setAccountBalance(blank.getSaving().getAccountBalance() - input);
		// addTransaction will add the new transaction to the araylist translist, an
		// arraylist of transction obejcts
		addTransaction(new Transaction(blank.getSaving().getAccountNumber(), input, "Savings Withdraw",
				blank.getSaving().getAccountBalance()));
	}

	private void viewBalances() {

		System.out.println("\n------------------------");
		System.out.println(blank.getSaving().toString());
		System.out.println(blank.getChecking().toString());
		System.out.println(blank.getLoan().toString());
		System.out.println("------------------------");
	}

	private void viewExitScreen() {
		System.out.println("Goodbye, Have a good day!");
	}
}