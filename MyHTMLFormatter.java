package edu.gcu.bootcamp.cst135.milestone.FullStackBanking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

// this custom formatter formats parts of a log record to a single line
class MyHTMLFormatter extends Formatter {
	// this method is called for every log records
	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		buf.append("<tr>\n");

		// colorize any levels >= WARNING in red and bold
		// takes logrecord rec and if the int value of the level is greater
		// than or equal to the int value of warning the table is bold and red
		if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
			buf.append("\t<td id = \"table1\">");
			buf.append(rec.getLevel());
		} else {
			buf.append("\t<td>");
			buf.append(rec.getLevel());
		}

		buf.append("</td>\n");
		buf.append("\t<td>");
		// inserts the date and time between the table tabs
		buf.append(calcDate(rec.getMillis()));
		buf.append("</td>\n");
		buf.append("\t<td>");
		buf.append(formatMessage(rec));
		buf.append("</td>\n");
		buf.append("</tr>\n");

		return buf.toString();
	}

	// this method creates the date and time based on the milliseconds being
	// passed into the method.
	private String calcDate(long millisecs) {
		// Create a new date object and structure output in military date and time.
		// AM/PM and regular format would be dd/MM/yyyy hh:mm:ss aa
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date resultdate = new Date(millisecs);
		return date_format.format(resultdate);
	}

	// this method is called just after the handler using this
	// formatter is created
	public String getHead(Handler h) {
		return "<!DOCTYPE html>\n<head>\n" + "<link rel = \"stylesheet\" type = \"text/css\" href = \"C:\\Users\\katie\\OneDrive\\Desktop\\Bill Compton\\HTML\\chinese.css\">\n"
				+ "</head>\n" + "<body>\n" + "<h1>" + (new Date()) + "</h1>\n"
				+ "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n" + "<tr align=\"left\">\n"
				+ "\t<th style=\"width:10%\">Loglevel</th>\n" + "\t<th style=\"width:15%\">Time</th>\n"
				+ "\t<th style=\"width:75%\">Log Message</th>\n" + "</tr>\n";
	}

	// this method is called just after the handler using this
	// formatter is closed
	public String getTail(Handler h) {
		return "</table>\n</body>\n</html>";
	}
}