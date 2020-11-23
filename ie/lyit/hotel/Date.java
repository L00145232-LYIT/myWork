package ie.lyit.hotel;

public class Date {
	private int day;
	private int month;
	private int year;

	// Default Constructor
	// ==> Called when a Date object is created as follows - Date d1 = new Date();
	public Date() {
		day = month = year = 0;
	}

	// Initialization Constructor
	// ==> Called when a Date object is created as follows - Date d2 = new
	// Date(14,9,2010);
	// Initialisation Constructor
	public Date(int day, int month, int year) {
		if (day < 1 || day > 31 || month < 1 || month > 12 || year < 0 || year > 1000000)
			throw new IllegalArgumentException("INVALID YEAR");

		this.day = day;
		this.month = month;
		this.year = year;
	}

	// toString() method
	// ==> Called when a String of the class is used, e.g. - System.out.print(d1);
	// or System.out.print(d1.toString());
	@Override
	public String toString() {
		return (day + "/" + month + "/" + year);
	}

	// equals() method
	// ==> Called when comparing an object with another object, e.g. -
	// if(n1.equals(n2))
	@Override
	public boolean equals(Object obj) {
		Date dObject;
		if (obj instanceof Date)
			dObject = (Date) obj;
		else
			return false;

		return this.day == (dObject.day) && this.month == (dObject.month) && this.year == (dObject.year);
	}

	// get methods
	// ==> Called when retrieving part of an object, e.g. - if (d1.getYear() ==
	// d2.getYear())
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// set methods
	// ==> Called when setting part of an object, e.g. - d1.setDay(14);
	// d1.setMonth(9);
	// d1.setYear(2010);
	public void setDay(int setDayTo) {
		if (setDayTo < 1 || setDayTo > 31)
			throw new IllegalArgumentException("Invalid Day");

		day = setDayTo;
	}

	public void setMonth(int setMonthTo) {
		if (setMonthTo < 1 || setMonthTo > 12)
			throw new IllegalArgumentException("Invalid Month");
		month = setMonthTo;
	}

	public void setYear(int setYearTo) {
		if (setYearTo < 1 || setYearTo > 100000)
			throw new IllegalArgumentException("Invalid Year");

		year = setYearTo;
	}
}