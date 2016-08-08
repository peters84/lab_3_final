/**
 * 
 */
package lab_3;

import java.util.Scanner;

import arrayImpl.InternalJobOpeningArrayDemo;
import linkedImpl_test.Main;

/**
 * 
 * Main class used to launch a demonstration of a program using an Priority queue.
 * You can choose between 1)Array implementation and 2)Linked List
 * Originally indented to pass an array of employees to each implementation to
 * demo similar outputs. 
 * @author Peter Socha
 * @version 1.0
 * 
 */
public class InternalJobOpeningDemo {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		//Array of 41 employees using COEN 352's participant list
		Employee[] entrants =
				
			{new Employee("Ahmad El-Baher", "20100405")
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
					,new Employee("Hendrik Oosenbrug", "20140917")
					,new Employee("Ho Man Chan", "20140321")
					,new Employee("Ivan Ilyushchenko", "20140917")
					,new Employee("James Francis McDougall", "20150507")
					,new Employee("Joshua Kukulsky", "20150512")
					,new Employee("Kaveh Mahdy-Dehno", "20150731")
					,new Employee("Kenny Lee Sin Cheong", "20151013")
					,new Employee("Kevin Yau", "20160715")
					,new Employee("Kyle Gehmlich", "20160729")
					,new Employee("Marc Bass", "20100823")
					,new Employee("Michael Scalera", "20110712")
					,new Employee("MOKHTAR BELDJEHEM", "20150512")
					,new Employee("Nathan Shummoogum", "20160729")
					,new Employee("Paul Daccache", "20130612")
					,new Employee("Piotr Socha", "20131113")
					,new Employee("Ryan Poitras", "20131115")
					,new Employee("Samrat Debroy", "20140131")
					,new Employee("Sana Syed", "20140324")
					,new Employee("Shehryar Haider", "20140421")
					,new Employee("Simaar Ahmad", "20141027")
					,new Employee("Simon Bourque", "20141107")
					,new Employee("Sonia Aude Panka Metangmo", "20150102")
					,new Employee("Suzette Slim", "20150121")
					,new Employee("Tony Bhamdouni", "20150224")
					,new Employee("Yuchen Liang", "20150821")};
		System.out.println("Choose implementation type:"
		+"\n 1)Array"
		+"\n 2)Linked List");
		Scanner keyboardScanner = new Scanner(System.in);
		int option = keyboardScanner.nextInt();
		
		//Chooses a demo and exits once done.
		switch(option){
			case 1:System.out.println("Pressed 1");
				keyboardScanner.close();
				InternalJobOpeningArrayDemo.demoWaitingList(entrants);;
				break;
			case 2:System.out.println("Pressed 2");
				keyboardScanner.close();
				Main.main(null);
				break;
		default: System.out.println("Invalid entry");
			main(new String[]{""});
		}
	}

}
