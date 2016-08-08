package arrayImpl.tests;

import arrayImpl.WaitingListArray;
import lab_3.Employee;

public class priorityTest {

	public static void main(String[] args) {
		
		WaitingListArray waitingListArray = new WaitingListArray();
		
		waitingListArray.addEmployee(new Employee("A", "20160101"));
		waitingListArray.addEmployee(new Employee("B", "20160101"));
		// TODO Auto-generated method stub
		System.out.print("Waiting list array contents: " + waitingListArray.toString());
	}

}
