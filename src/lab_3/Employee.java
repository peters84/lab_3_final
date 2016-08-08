package lab_3;

import java.util.Calendar;
import java.util.Date;

public class Employee implements Comparable<Employee> {
	/**
	 * @param firstLast
	 *            Name in the form of First Last
	 * @param YYYYMMDD
	 *            Date of hire in the form of year, month and day concatenated
	 */
	public Employee(String firstLast, String YYYYMMDD) {
		setFullName(firstLast);
		setDateOfHire(Integer.valueOf(YYYYMMDD.substring(0, 4)), Integer.valueOf(YYYYMMDD.substring(4, 6)),
				Integer.valueOf(YYYYMMDD.substring(6, 8)));
	}

	private String fullName = "";
	private Calendar dateOfHire = Calendar.getInstance();

	/**
	 * Compares seniority based on date of hire between this and another
	 * employee. The one with the earliest date of hire gets highest seniority.
	 * 
	 * @param otherEmployee
	 *            the other employee to compare to
	 * @return a number indicating lower priority (-1),higher seniority(1) or
	 *         equal seniority(0)
	 */
	@Override
	public int compareTo(Employee otherEmployee) {
		// Using the Calendar class' compareTo return treats the newest date as
		// higher.
		// Reversing the parameters allows for earlier dates to be of higher
		// seniority.
		return otherEmployee.dateOfHire.compareTo(getDateOfHire());
	}

	/**
	 * Allows to change the name of an employee
	 * 
	 * @param firstLast
	 *            Name in the form of First Last
	 */
	public void setFullName(String firstLast) {
		fullName = firstLast;
	}

	/**
	 * Allows to change the date of hire of an employee
	 * @param year in YYYY format
	 * @param month in MM format
	 * @param date day of the month in DD format
	 */
	public void setDateOfHire(int year, int month, int date) {
		dateOfHire.set(year, month, date);
		//Calendar objects get instantiated with a specific time during runtime.
		//This ensures that two of the same days are equal.
		dateOfHire.clear(Calendar.AM_PM);
		dateOfHire.clear(Calendar.MINUTE);
		dateOfHire.clear(Calendar.SECOND);
		dateOfHire.clear(Calendar.MILLISECOND);
	}

	/**
	 * @return Returns a Calendar object of the date of hire
	 */
	public Calendar getDateOfHire() {
		return dateOfHire;
	}

	/**
	 * 
	 * @return The employee's full name in First Last form
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Provides all the employee's information in a legible form
	 * @return A string of form Full Name: [First Last] Date of Hire: [YYYY-MM-DD]
	 * 
	 */
	public String toString() {
		String returnString = "";
		returnString += "Full Name:" + getFullName() + " Date of Hire: " + getDateOfHire().get(Calendar.YEAR) + "-"
				+ getDateOfHire().get(Calendar.MONTH) + "-" + getDateOfHire().get(Calendar.DATE);
		// + getDateOfHire().getTimeInMillis();
		return returnString;
	}
}
