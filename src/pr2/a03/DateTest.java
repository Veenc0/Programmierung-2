package pr2.a03;

import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DateTest {

	private static final Logger logger = Logger.getLogger("Date");

	static {
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		logger.addHandler(consoleHandler);
	}

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		int[][] testdata = { { 1, 5, 2013 }, { 42, 38, 2013 }, { 15, 6, 2017 }, { 30, 2, 2018 }, { 5, 15, 2019 },
				{ 3, 12, 2020 }, { 30, 11, 3150 }, { 59, 5, 2022 }, { 15, 12, 3010 }, };

		for (int i = 0; i < testdata.length; i++) {
			Date date = new Date(testdata[i][0], testdata[i][1], testdata[i][2]);
			out.printf("Datum: %s %n \n", date.toString());
			out.flush();
		}
		out.printf("Datum: %s %n \n", Date.ofYearDay(2020, 365));
		out.printf("Datum: %s %n \n", Date.ofYearDay(2018, 20));
		out.printf("Datum: %s %n \n", Date.ofYearDay(2015, 10));
		out.printf("Datum: %s %n \n", Date.ofYearDay(2012, 65));
		out.flush();
	}
}