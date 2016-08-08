
package arrayImpl;

import lab_3.Employee;

/**
 * @author Peter Socha Waiting list accepts entrants for an internal job
 *         opening. Hiring people removes them from the list
 * @version 1.0
 */
public class WaitingListArray {

	private ArrayPriorityQueue<Employee> waitingList;

	/**
	 * Creates empty waiting list.
	 */
	public WaitingListArray() {
		waitingList = new ArrayPriorityQueue<>();
	} // end constructor

	/**
	 * Adds employees to waiting list by priority.
	 * 
	 * @param newEmployee
	 *            the Employee object
	 * 
	 */
	public void addEmployee(Employee newEmployee) {
		waitingList.add(newEmployee);
		System.out.println("Attempting to add employee " + newEmployee.toString());
	} // end addEmployee

	/**
	 * Adds employee by separate parameters.
	 * 
	 * @param fullName
	 *            In First Name Last name formate
	 * @param dateOfHire
	 *            in YYYYMMDD format
	 */
	public void addEmployee(String fullName, String dateOfHire) {
		Employee newEmployee = new Employee(fullName, dateOfHire);
		System.out.println("Attempting to add " + newEmployee.toString());
		addEmployee(newEmployee);
	}// end addEmployee

	/**
	 * Lets you take a look at the next person in line without hiring them.
	 * 
	 * @return the next employee in line.
	 */
	public Employee getNextEmployeeInLine() {
		return waitingList.peek();
	} // end getNextEmployeeInLine

	/**
	 * Hires employee and removes them from the list.
	 * 
	 * @return the employee hired to new position.
	 */
	public Employee giveJobToEmployee() {
		return waitingList.remove();
	} // end giveJobToEmployee

	/**
	 * Clears out the waiting list by hiring everyone.
	 */
	public void hireEveryone() {
		int numberOfEntrants = waitingList.getCurrentSize();

		for (int i = 0; i < numberOfEntrants; i++) {
			System.out.println(waitingList.peek().toString() + " was hired!");
			waitingList.remove();

		}

	}

	/*
	 * public void mergeWithWaitinglist(WaitingListArray wl1){
	 * waitingList.joinArrayWithPriorityQueue(wl1); }
	 * 
	 * public WaitingListArray mergeWaitingLists(WaitingListArray
	 * wl1,WaitingListArray wl2){ waitingList.joinArrayPriorityQueues(wl1, wl2);
	 * }
	 */
	
	/**
	 * Waiting list array with last employee being first in line.
	 * @return array representation of the waiting list
	 */
	public String toString() {
		return waitingList.toString();
	}

}
