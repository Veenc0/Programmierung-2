package pr2.a04;

import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DateTest {

	private static final Logger logger = Logger.getLogger("Date");

	static {
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		logger.addHandler(consoleHandler);
		FileHandler filehandler = null;
		try {
			filehandler = new FileHandler("./data/file.log", 1000, 3, true);
			filehandler.setFormatter(new SimpleFormatter());
		} catch (Exception e) {
			e.printStackTrace();
		}
		filehandler.setLevel(Level.ALL);
		logger.addHandler(filehandler);
	}

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out);
		int[][] testdata = { { 1, 5, 2013 }, { 42, 38, 2013 }, { 15, 6, 2017 }, { 30, 2, 2018 }, { 5, 15, 2019 },
				{ 3, 12, 2020 }, { 30, 11, 3150 }, { 59, 5, 2022 }, { 15, 12, 3010 }, };
		Date[] dates = new Date[testdata.length];
		for (int i = 0; i < testdata.length; i++) {
			try {
				Date date = new Date(testdata[i][0], testdata[i][1], testdata[i][2]);
				dates[i] = date;
			} catch (IllegalDateException e) {
				out.print(e);
				out.printf("Falsches Datum: %d.%d.%4d \n", testdata[i][0], testdata[i][1], testdata[i][2]);
				logger.warning(e + "" + testdata[i][0] + "." + testdata[i][1] + "." + testdata[i][2] + " \n");
				out.println();
			}
		}
		for (int i = 0; i < dates.length; i++) {
			Date correct = dates[i];
			if (!(correct == null)) {
				out.println();
				out.println("Korrektes Datum: " + correct);
				out.flush();
			}
		}
	}
}
	