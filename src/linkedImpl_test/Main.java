package linkedImpl_test;

/** A client program that tests the class LinkedPriorityQueue */
public class Main {
	
	public static void main(String args[]){
		
		/** Elements with smaller priority value have the highest priority.
		 *  Elements that have same priority value are placed in the queue according
		 *  to the order in which they were added 
		 */
		
		// Declare a new object of the LinkedPriorityQueue class
		PriorityQueueInterface<String> myqueue = new LinkedPriorityQueue<String>();
		// Add elements to the queue
		myqueue.add("John", "2");
		myqueue.add("Jill", "2");
		myqueue.add("Jim", 	"3");
		myqueue.add("Jeff", "1");
		myqueue.add("Jack", "0");
		
		/** Expect Jack to have the highest priority, followed by Jeff, then by John and Jill and at the last
			position should be Jim.	*/
		
		System.out.println("The queue elements are: ");
		
		// Displays the queue
		myqueue.display();
		
		// Retrieves the front element of the queue which is Jack
		System.out.println("The element stored at the front is: " + myqueue.peek());
		
		// Retrieves and removes the front element of the queue which is Jack
		System.out.println("The element removed from the front is: " + myqueue.remove());
		
		// Prints the size of the queue which is 4 since Jack has been removed
		System.out.println("The size of the queue is: " + myqueue.getSize());
		
		// Clears all the elements in the queue
		myqueue.clear();
		
		System.out.println("The queue is now empty!");;
		
		// Gives us boolean value true when asked if the queue is empty
		System.out.println("Is the queue empty: " + myqueue.isEmpty());
		
		// Adding new elements to the queue
		System.out.println("\nAdding new elements to the queue: ");
		myqueue.add("Taha", "1");
		myqueue.add("Jill", "3");
		myqueue.add("Omer", "2");
		myqueue.add("Ravi", "5");
		myqueue.add("Shehryar", "0");
		
		// Display the queue
		myqueue.display();
		
		// Removes the element at the front of the queue which is Shehryar
		System.out.println("\nThe element removed from the front is: " + myqueue.remove());
		// Removes the element at the front of the queue which is Taha
		System.out.println("The element removed from the front is: " + myqueue.remove());
		// Removes the element at the front of the queue which is Omer
		System.out.println("The element removed from the front is: " + myqueue.remove());
		// Retrieves the element at the front of the queue which is Jill
		System.out.println("The element stored at the front of the queue is: " + myqueue.peek());
		System.out.println("\nThe queue contains: ");
		// Displays the queue
		myqueue.display();
		// Should return false 
		System.out.println("Is the queue empty: " + myqueue.isEmpty());
		
	}// end main method
	
	
}// end Main 
