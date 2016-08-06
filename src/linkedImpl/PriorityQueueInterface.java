package linkedImpl;

public interface PriorityQueueInterface<T extends Comparable<? super T>> {

	/**
	 * Adds a new entry to the priority queue@param newEentry An object to be
	 * added.
	 * @param newEntry An object to be added.
	 */
	public void add(T newEntry, Comparable<? super T> comp);

	/**
	 * Removes and returns the entry having the highest priority.
	 * 
	 * @return Either the object having the highest priority or null if empty
	 */
	public T remove();
	
	/**
	 * Retrieves highest priority entry.
	 * @return highest priority object or null if empty.
	 */
	public T peek();
	
	/**
	 * Gets size of this priority queue.
	 * @return The number of entries currently in the priority queue.
	 * 
	 */
	public int getSize();
	//	end PriorityQUeueInterface
	
	/** Detects whether this priority queue is empty.
	@return true if the priority queue is empty, or false otherwise */
	public boolean isEmpty();
	
	/** Removes all entries from this priority queue */
	public void clear();
	
	public void display();
}
