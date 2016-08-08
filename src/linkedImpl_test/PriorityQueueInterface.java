package linkedImpl_test;

/** An interface that describes the operations on a priority queue object */

public interface PriorityQueueInterface<T extends Comparable<? super T>> {

	/**
	 * Adds a new entry to the priority queue
	 * @param newEntry An object to be added.
	 * @param comp the priority value of type T	
	 */
	public void add(T newEntry, Comparable<? super T> comp);

	/**
	 * Removes and returns the entry having the highest priority.
	 * @return Either the object having the highest priority or null if empty
	 */
	public T remove();
	
	/**
	 * Retrieves highest priority entry.
	 * @return highest priority object or null if empty.
	 */
	public T peek();
	
	/**
	 * Gets size of priority queue.
	 * @return The number of entries currently in the priority queue.
	 */
	public int getSize();
	
	/** Detects whether priority queue is empty.
	 *	@return true if the priority queue is empty, or false otherwise
	 */
	public boolean isEmpty();
	
	/** Removes all entries from priority queue */
	public void clear();
	
	/**
	 * Displays all the entries in the priority queue from highest priority at 
	 * the top to lowest priority at the bottom.
	 */
	public void display();
}
// end of PriorityQueueInterface