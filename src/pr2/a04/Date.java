package pr2.a04;

public class Date {

	protected int day;
	protected int month;
	protected int year;

	public Date(int day, int month, int year) throws IllegalDateException {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
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
		if (wrongMonth) {
			throw new IllegalDateException("Illegal Month" + "(" + month + ")  \n");
		}
		if (wrongDay) {
			throw new IllegalDateException("Illegal Day" + "(>" + dayMonth + ") \n");
		}
		if (wrongYear) {
			throw new IllegalDateException("Illegal Year" + "(year out of scope: " + year + ") \n");
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

	public static Date of(int year, int month, int day) throws IllegalDateException {
		return new Date(day, month, year);
	}

	public static Date ofYearDay(int year, int dayInYear) throws IllegalDateException {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
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