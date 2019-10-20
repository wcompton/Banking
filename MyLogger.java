package edu.gcu.bootcamp.cst135.milestone.FullStackBanking;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.ConsoleHandler;

public class MyLogger {
	static private FileHandler fileTxt;
	static private SimpleFormatter formatterTxt;

	static private FileHandler fileHTML;
	static private Formatter formatterHTML;
	//logger method
	static public void setup() throws IOException {

		// get the global logger to configure it
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		// suppress the logging output to the console
		// Logger rootLogger = Logger.getLogger("");
		// Handler[] handlers = rootLogger.getHandlers();
		// if (handlers[0] instanceof ConsoleHandler) {
		// rootLogger.removeHandler(handlers[0]);
		// }

		// this code sets the level to which the logger will
		// log an exception
		logger.setLevel(Level.INFO);
		// This creates a new file handler to be saved as Logging in a txt file
		fileTxt = new FileHandler("Logging.txt");
		// This creates a new file handler to be saved as Logging in an HTML file
		fileHTML = new FileHandler("Logging.html");

		// create a TXT formatter (new object)
		formatterTxt = new SimpleFormatter();
		// filetext is the variable assigned to the txt Filehandler
		// this sets the Formatter(formatterTxt) to a default print statement into the
		// file
		fileTxt.setFormatter(formatterTxt);
		// this code takes the logger info, and adds it to the filehandler
		logger.addHandler(fileTxt);

		// create an HTML formatter
		formatterHTML = new MyHTMLFormatter();
		// fileHTML is the variable assigned to the HTML Filehandler
		// this sets the Formatter(formatterHTML) to the default print
		// statement into the file
		fileHTML.setFormatter(formatterHTML);
		// this code takes the logger info, and adds it to the filehandler
		logger.addHandler(fileHTML);
	}
}