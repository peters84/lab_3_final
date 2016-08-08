/**
 *
 */
package arrayImpl;

import lab_3.Employee;

/**
 * @author Peter Socha
 * @version 1.0
 * 
 * Creates a waiting list and demonstrates 
 * adding and removing(hiring) employees to it.
 */
public class InternalJobOpeningArrayDemo {

	public static void demoWaitingList(Employee[] entrants){

		/*
		 * new Employee("Ahmad El-Baher", "20100405")
					,new Employee("Alexei Ostroouchko", "20100412")
					,new Employee("Ali Mouawieh", "20100617")
					,new Employee("Amit Desai", "20100823")
					,new Employee("Ankit Rajan", "20100914")
					,new Employee("Anthony Fiorito", "20101217")
					,new Employee("Barnali Ahmed", "20110117")
					,new Employee("Catherine Nguyen", "20110217")
					,new Employee("Christian Kellner", "20110331")
					,new Employee("Fahim Tazwar Hossain", "20110601")
					,new Employee("Farzad Sabahi", "20110712")
					,new Employee("Fozail Ahmad", "20110823")
					,new Employee("Gabriel Belanger", "20121219")
					,new Employee("Hamed Hamid", "20130218")
					,new Employee("Hannah Halcro", "20130626")
					,new Employee("Hassan Syyed", "20140127")
					,new Employee("Hendrik Oosenbrug", "20140207")

		 */
		System.out.println("Empty");
		WaitingListArray waitingListArray = new WaitingListArray();
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("1 entry");
		waitingListArray.addEmployee(entrants[0]);
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("3 entries");
		waitingListArray.addEmployee(entrants[1]);
		waitingListArray.addEmployee(entrants[2]);
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("10 entries");
		waitingListArray.addEmployee(entrants[3]);
		waitingListArray.addEmployee(entrants[4]);
		waitingListArray.addEmployee(entrants[5]);
		waitingListArray.addEmployee(entrants[6]);
		waitingListArray.addEmployee(entrants[7]);
		waitingListArray.addEmployee(entrants[8]);
		waitingListArray.addEmployee(entrants[9]);
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("Seek out highest seniority person ");
		System.out.println(waitingListArray.getNextEmployeeInLine().toString());
		System.out.print("Waiting list array contents: " + waitingListArray.toString());


		System.out.println("\n" );
		System.out.println("Remove highest seniority person ");
		System.out.println(waitingListArray.giveJobToEmployee().toString());
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("Give everyone a job");
		waitingListArray.hireEveryone();
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

		System.out.println("\n" );
		System.out.println("Add 4 entries, 2 of which have the same priority");
		waitingListArray.addEmployee(entrants[15]);
		waitingListArray.addEmployee(entrants[16]);
		waitingListArray.addEmployee(entrants[17]);
		waitingListArray.addEmployee(entrants[18]);
		System.out.print("Waiting list array contents: " + waitingListArray.toString());

	}
}
