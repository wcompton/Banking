package edu.gcu.bootcamp.cst135.milestone.FullStackBanking;

import java.io.IOException;
import java.util.logging.Logger;
import java.io.StringWriter;
import java.io.PrintWriter;
import edu.gcu.bootcamp.cst135.milestone.controller.Bank;

public class FullStackBanking {

	public static void main(String[] args) {
		// factory method is used to prevent creating a new object everytime you call
		// instead you use the same object. Therefore, there will not be a new log
		// everytime there is an exception.
		final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		try {
			try {
				// invokes the setup method in mylogger class
				MyLogger.setup();
			} catch (IOException ex) {
				// prints the stack trace for any errors while invoking the setup method in
				// mylogger class
				ex.printStackTrace();
			}
			// initiates a new bank object
			Bank bank = new Bank();
			// invokes the login screen method in the bank class
			bank.loginScreen();

		} catch (Exception ex) {
			// creates a new string writer to buffer strings
			StringWriter sw = new StringWriter();
			// creates a new print writer to write to files passing the string
			// writer argument in order to format to a string
			PrintWriter pw = new PrintWriter(sw);
			// prints the stack trace for the exception to the print writer
			ex.printStackTrace(pw);
			// sets the level of exceptions at this level to severe, and
			// uses the string writer toString to print severe to the
			// file
			LOGGER.severe(sw.toString());
		}

		// catch(Exception e) {
		// e.printStackTrace();
		// System.out.println("We're sorry an error occured. Our engineers are working
		// on the problem.");
	}
	// try {
	// MyLogger.setup();
	// } catch (IOException e) {
	// e.printStackTrace();
	// throw new RuntimeException("Problems with creating the log files");
	// }
	// tester.doSomeThingAndLog();
	// }}
	// }
}