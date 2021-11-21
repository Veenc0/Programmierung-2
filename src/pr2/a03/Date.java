package pr2.a03;

import java.util.logging.Logger;

public class Date extends Object{
	
	protected int day;
	protected int month;
	protected int year;
	protected static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final Logger logger = Logger.getLogger("Date");

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		boolean wrongMonth = month > 12 || month <= 0;
		boolean wrongDay;
		int dayMonth;
		if (wrongMonth) {
			wrongDay = day <= 0 || day > 30;
			dayMonth = 30;
		} else {
			wrongDay = day <= 0 || daysInMonth[month - 1] < day;
			dayMonth = daysInMonth[month - 1];
		}
		boolean wrongYear = year > 3000 || year < 0;
		boolean correctDate = !wrongMonth && !wrongDay && !wrongYear;

		if (wrongMonth) {
			logger.warning("Falsches Datum: " + toString() + ": illegal month ");
		}
		if (wrongDay) {
			logger.warning("Falsches Datum: " + toString() + ": illegal day >" + dayMonth);
		}
		if (wrongYear) {
			logger.warning("Falsches Datum: " + toString() + ": year out of scope [0..3000]");
		}
		if (correctDate) {
			logger.finest("Korrektes Datum: " + toString());
		}
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public static Date of(int year, int month, int day) {
		return new Date(day, month, year);
	}

	public static Date ofYearDay(int year, int dayInYear) {
		int month = 0;
		for (int m = 0; m <= 12; m++) {
			if (dayInYear > daysInMonth[m]) {
				dayInYear -= daysInMonth[m];
			} else {
				month = m + 1;
				break;
			}
		}
		return new Date(dayInYear, month, year);
	}

	public String toString() {
		return String.format("%02d.%02d.%04d", day, month, year);
	}
}