package linkedImpl;

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	
	private Node firstNode;
	private int length;
	
	public LinkedPriorityQueue(){
		
		firstNode = null;
		length = 0;
	}
	
	@Override
	public void add(T newEntry, Comparable<? super T> comp) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, comp);
		Node nodeBefore = getNodeBefore(newNode);
		
		if(isEmpty() || (nodeBefore == null)){
			
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}else{
			
			Node nodeAfter = nodeBefore.getNextNode();
			newNode.setNextNode(nodeAfter);
			nodeBefore.setNextNode(newNode);
		}
		length++;
		
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return remove(1);
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return getEntry(1);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean result;
		if(length == 0){
			assert firstNode == null; 
			result = true;
		}else{
			
			assert firstNode != null;
			result = false;
			
		}
		return result;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		firstNode = null;
		length = 0;
	}
	
	public void display(){
		
		Node currentNode = firstNode;
		while(currentNode != null){
			
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNextNode();
		}
	}
	
	/** ---------------THE CORE METHODS ENDS----------------------------------------------*/
	
	private Node getNodeBefore(Node aNode){
		
		Node currentNode = firstNode;
		Node nodeBefore = null;
		
		while((currentNode != null) && (compareHelper(aNode.comp, currentNode.comp) >= 0)){
			
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		return nodeBefore;
	}
	
	private <T extends Comparable> int compareHelper(T compA, T compB){
		
		return compA.compareTo(compB);
	}
	
	private Node getNodeAt(int givenPosition){
		
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= length);
		Node currentNode = firstNode;
		
		for(int counter = 1; counter < givenPosition; counter++){
			
			assert currentNode != null;
			
		}
		return currentNode;
	}
	
	private T getEntry(int givenPosition){
		
		T result = null;
		
		if((givenPosition >= 1) && (givenPosition <= length)){
			
			assert!isEmpty();
			result = getNodeAt(givenPosition).getData();
		}
		return result;
	}
	
	private T remove(int givenPosition){
		
		T result = null;
		if((givenPosition >= 1) && (givenPosition <= length)){
			
			assert!isEmpty();
			
			if(givenPosition == 1){
				
				result = firstNode.getData();
				firstNode = firstNode.getNextNode();
			}else{
				
				Node nodeBefore = getNodeAt(givenPosition - 1); 
				Node nodeToRemove = nodeBefore.getNextNode();
				Node nodeAfter = nodeToRemove.getNextNode();
				nodeBefore.setNextNode(nodeAfter);
				result = nodeToRemove.getData();	
			}
			length --;
		}
		
		return result;
	}
	
	/** ------------------------THE PRIVATE NODE CLASS STARTS------------------------------------ */
	
	// Defines the constructors and get and set methods for the Node class
	private class Node{
		
		private T data;
		private Comparable<? super T> comp;
		private	Node next;
		
		private Node(T dataPortion, Comparable<? super T> c){
			
			data = dataPortion;
			comp = c;
			next = null;
			
		}
		
		private Node(T dataPortion, Comparable<? super T> c, Node nextNode){
			
			data = dataPortion;
			comp = c;
			next = nextNode;
		}
		
		private T getData(){
			
			return data;
		}
		
		private void setData(T newData){
			
			data = newData;
		}
		
		private Node getNextNode(){
			
			return next;
		}
		
		private void setNextNode(Node nextNode){
			
			next = nextNode;
		}
			
	}

}
