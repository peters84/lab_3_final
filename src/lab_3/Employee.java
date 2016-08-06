package lab_3;

import java.util.Calendar;
import java.util.Date;

public class Employee implements Comparable<Employee> {

	public Employee(String firstLast, String YYYYMMDD) {
		setFullname(firstLast);
		setDateOfHire(
				Integer.valueOf(YYYYMMDD.substring(0, 4)), 
				Integer.valueOf(YYYYMMDD.substring(4, 6)),
						Integer.valueOf(YYYYMMDD.substring(6, 8))
				);
	}

	private String fullName = "";
	private Calendar dateOfHire = Calendar.getInstance();

	@Override
	public int compareTo(Employee otherEmployee) {
		// TODO Auto-generated method stub
		//return dateOfHire.compareTo(otherEmployee.getDateOfHire())*-1;
		return otherEmployee.dateOfHire.compareTo(getDateOfHire());
	}

	public void setFullname(String firstLast) {
		fullName = firstLast;
	}

	public void setDateOfHire(int year, int month, int date) {
		dateOfHire.set(year, month, date);
		dateOfHire.clear(Calendar.AM_PM);
		dateOfHire.clear(Calendar.MINUTE);
		dateOfHire.clear(Calendar.SECOND);
		dateOfHire.clear(Calendar.MILLISECOND);
	}

	public Calendar getDateOfHire() {
		return dateOfHire;
	}

	public String getFullName() {
		return fullName;
	}
	
	public String toString(){
		String returnString= "";
		returnString+= "Full Name:" + getFullName() + " Date of Hire: "  
		+ getDateOfHire().get(Calendar.YEAR)
		+ "-" + getDateOfHire().get(Calendar.MONTH)
		+ "-" + getDateOfHire().get(Calendar.DATE);
		//+ getDateOfHire().getTimeInMillis();		
		return returnString;
	}
}
