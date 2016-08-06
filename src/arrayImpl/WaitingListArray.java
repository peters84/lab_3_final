/**
 *
 */
package arrayImpl;

import lab_3.Employee;

/**
 * @author Peter Socha
 *
 */
public class WaitingListArray {

	private ArrayPriorityQueue<Employee> waitingList;

	public WaitingListArray(){
		waitingList = new ArrayPriorityQueue<>();
	}	// end constructor

	public void addEmployee(Employee newEmployee){
		waitingList.add(newEmployee);
	}	// end addEmployee

	public void addEmployee(String fullName, String dateOfHire){
		Employee newEmployee  = new Employee(fullName, dateOfHire);
		addEmployee(newEmployee);
	}//end addEmployee

	public Employee getNextEmployeeInLine(){
		return waitingList.peek();
	} // end getNextEmployeeInLine

	public Employee giveJobToEmployee(){
		return waitingList.remove();
	} // end giveJobToEmployee

	public void hireEveryone(){
		int numberOfEntrants = waitingList.getCurrentSize();

		for(int i = 0;i<numberOfEntrants;i++){
			System.out.println(waitingList.peek().toString() + " was hired!");
			waitingList.remove();

		}


	}
/*
	public void mergeWithWaitinglist(WaitingListArray wl1){
		waitingList.joinArrayWithPriorityQueue(wl1);
	}

	public WaitingListArray mergeWaitingLists(WaitingListArray wl1,WaitingListArray wl2){
		waitingList.joinArrayPriorityQueues(wl1, wl2);
	}
*/
	public String toString(){
		return waitingList.toString();
	}


}
