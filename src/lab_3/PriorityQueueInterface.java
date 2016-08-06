/**
 * 
 */
package lab_3;

/**
 * @author Peter Socha
 *
 */
public interface PriorityQueueInterface<T extends Comparable<? super T>> {

	/**
	 * Adds a new entry to the priority queue@param newEentry An object to be
	 * added.
	 * @param newEntry An object to be added.
	 */
	public void add(T newEntry);

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
	public int getCurrentSize();
}	//	end PriorityQUeueInterface
