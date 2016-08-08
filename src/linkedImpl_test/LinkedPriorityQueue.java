package linkedImpl_test;

/** A class that implements the PriorityQueueInterface to describes the methods 
 * 	of the PrioriyQueue object 
 */
public class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	
	/** Declare the variable firstNode which points to the first node in the queue  */
	private Node firstNode;
	/** Declare the variable length which stores the length of the queue */
	private int length;
	
	// Default constructor of the class
	public LinkedPriorityQueue(){
		
		firstNode = null;
		length = 0;
	}// end default constructor
	
	/** 
	 * Method to add a new entry to the priority queue
	 * @param newEntry the object to be added to the queue
	 * @param comp the priority of the object of type T
	 */
	public void add(T newEntry, Comparable<? super T> comp) {
		
		Node newNode = new Node(newEntry, comp);
		Node nodeBefore = getPreviousNode(newNode);
		
		if(isEmpty() || (nodeBefore == null)){
			
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}else{
			
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		length++;
		
	}// end add

	/**
	 * Method to remove a node from the priority queue
	 * @return the top entry of the priority queue or
	 * null if queue is empty 
	 */
	public T remove() {
		
		return removeNode(1);
	}// end remove

	/**
	 * Method to retrieve the highest priority entry from the queue
	 * @return the top entry of the priority queue or 
	 * null if queue is empty
	 */
	public T peek() {
		
		return getEntry(1);
	}// end peek

	/** Method to find the size of the priority queue
	 * @return the number of the elements in the queue 
	 */
	public int getSize() {
		
		return length;
	}// end getSize

	/** Method to check if the queue is empty or not
	 * @return true if queue is empty or false otherwise
	 */
	public boolean isEmpty() {
		// create a boolean variable
		boolean result;
		// check if priority queue is empty
		if(length == 0){
			// make sure the first node is null
			assert firstNode == null; 
			// update the variable result
			result = true;
		}
		// if queue is not empty
		else{
			// check if first node is not equal to null
			assert firstNode != null;
			// assign result is equal to false 
			result = false;
			
		}
		// return value of the variable result
		return result;
	}// end isEmpty

	// Method which clears all the elements in the priority queue
	public void clear() {
		// set the first node null
		firstNode = null;
		// set length to zero
		length = 0;
	} // end clear
	
	// Method which displays all the entries in the priority queue
	public void display(){
		
		// the node currenNode stores the first node
		Node currentNode = firstNode;
		// execute the while loop while the currentNode is not null
		while(currentNode != null){
			// print the data value of the currentNode
			System.out.println(currentNode.getData());
			// set the currentNode to its next node
			currentNode = currentNode.getNextNode();
		}
	}//end display
	
	/** ---------------THE CORE METHODS ENDS----------------------------------------------*/
	
	/** ---------------THE PRIVATE METHODS OF THE CLASS BEGIN-----------------------------*/
	
	/** Method to find the node which comes before the given node
	 * @param aNode which is the given node
	 * @return the node that comes before the given node
	 */
	private Node getPreviousNode(Node aNode){
		
		Node currentNode = firstNode;
		Node previousNode = null;
		
		while((currentNode != null) && (compareNodes(aNode.comp, currentNode.comp) >= 0)){
			
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		return previousNode;
	}// end getPreviousNode
	
	/** A method to compare the priorities between two nodes
	*	@param <T> the comparison value of the two priority values	
	*	@param Node1 the priority value of one node
	*	@param Node2 the priority value of the other node
	*	@return the comparison between the two values  
	*/
	private <T extends Comparable> int compareNodes(T Node1, T Node2){
		
		return Node1.compareTo(Node2);
	}// end compareNodes
	
	/** Method to find the node at any given position 
	 * @param givenPosition the position of the node in the priority queue
	 * @return the node at any given position
	 */
	private Node getNodePosition(int givenPosition){
		
		// make sure that the queue is not empty and the givenPosition is 
		// between the length of the priority queue
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
		//set currentNode to the first node
		Node currentNode = firstNode;
		// execute loop till the given position
		for(int counter = 1; counter < givenPosition; counter++){
			
			// check if the currentNode is not null
			assert currentNode != null;
			// move the currentNode to its next node
			currentNode = currentNode.getNextNode();
		}
		// return the currentNode
		return currentNode;
	}// end getNodePosition
	
	/** Method to get the data entry of a node at any given position
	 * @param givenPosition the position of the node in the priority queue
	 * @return the data entry at a given position  
	 */
	private T getEntry(int givenPosition){
		
		T result = null;
		
		if((givenPosition >= 1) && (givenPosition <= length)){
			
			assert!isEmpty();
			result = getNodePosition(givenPosition).getData();
		}
		return result;
	}// end getEntry
	
	/** Method which removes an entry from a given node
	 * 	@param givenPosition the position of any node in the queue 
	 *	@return the data value at the given node  
	 */
	private T removeNode(int givenPosition){
		// declare variable which stores the value to return
		T result = null;
		// check if the givenPosition is between the length of the queue
		if((givenPosition >= 1) && (givenPosition <= length)){
			// check if queue is empty
			assert!isEmpty();
			// if the given position is the first entry then remove the first entry
			if(givenPosition == 1){
				// set the value of result to the data of the firstNode
				result = firstNode.getData();
				// set the firstNode to its next node
				firstNode = firstNode.getNextNode();
			}
				// if the given position is not the first entry
				else{
				// store the node at given position to a new declared node variable nodeBefore
				Node nodeBefore = getNodePosition(givenPosition - 1); 
				// set the variable nodeToRemove to the node after nodeBefore
				Node nodeToRemove = nodeBefore.getNextNode();
				// set the variable nodeAfter to the nodeToRemove next node
				Node nodeAfter = nodeToRemove.getNextNode();
				// remove the nodeBefore
				nodeBefore.setNextNode(nodeAfter);
				// save the entry to be removed in variable result
				result = nodeToRemove.getData();	
			}// end if
			// decrement the size of the queue
			length --;
		}// end if
		
		// return the result
		return result;
	}// end removeNode
	
	/** ------------------------THE PRIVATE NODE CLASS STARTS------------------------------------ */
	
	// Defines the constructors and get and set methods for the Node class
	private class Node{
		
		private T data;
		private Comparable<? super T> comp;
		private	Node next;
		
		// 	Create constructor of the class Node that initializes the default values of
		//	the class variables 
		private Node(T dataPortion, Comparable<? super T> c){
			
			data = dataPortion;
			comp = c;
			next = null;
			
		}// end default constructor
		
		// Another constructor of the class Node
		private Node(T dataPortion, Comparable<? super T> c, Node nextNode){
			
			data = dataPortion;
			comp = c;
			next = nextNode;
		}// end constructor
		
		// Getter method for the data of the node
		private T getData(){
			
			return data;
		}
		
		// Set method for setting the data value of a given node
		private void setData(T newData){
			
			data = newData;
		}
		
		// Method which gets the node that comes after the given node 
		private Node getNextNode(){
			
			return next;
		}
		
		// Set method for the getNextNode
		private void setNextNode(Node nextNode){
			
			next = nextNode;
		}
			
	}// end Node

}// end LinkedPriorityQueue
