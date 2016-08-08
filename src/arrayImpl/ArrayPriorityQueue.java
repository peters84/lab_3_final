/**
 *
 */
package arrayImpl;

import java.lang.reflect.Array;

import lab_3.Employee;
import lab_3.PriorityQueueInterface;

/**
 * Implementation of a priority queue that uses an array that is sorted upon
 * insertion of new elements. Last element ends up highest in priority and first
 * in line to get removed
 * 
 * @author Peter Socha
 * @version
 *
 */

// Generic object requires a compareTo in order to sort
public class ArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	private T[] theArray;
	private static final int DEFAULT_SIZE = 10;
	private int capacity;
	private int numberOfEntries = 0;

	public ArrayPriorityQueue(int newCapacity) {
		// Empty array of object therefore cast deemed safe
		@SuppressWarnings("unchecked")
		T[] anArray = (T[]) (new Comparable[newCapacity]);
		theArray = anArray;
	}

	/**
	 * Creates empty priority queue of capacity 10
	 */
	public ArrayPriorityQueue() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_SIZE);
	}

	/**
	 * Adds entries to the array starting from the back. If the object is of
	 * lower priority, it traverses the array until it either finds one of
	 * equivalent priority or reaches the beginning of the array. During this
	 * process, the higher priority elements get moved to the right by one.
	 * 
	 * @param newEntry
	 *            T that must be Comparable
	 */
	@Override
	public void add(T newEntry) {
		// public void add(T newEntry) {

		// TODO Auto-generated method stub

		int compareIndex = numberOfEntries - 1; // Index of last populated spot
		while (compareIndex >= 0 && newEntry.compareTo(theArray[compareIndex]) <= 0) {
			// move each higher by one to the right
			theArray[compareIndex + 1] = theArray[compareIndex];
			compareIndex--;
		}
		theArray[compareIndex + 1] = newEntry;
		numberOfEntries++;
	}

	/**
	 * Removes the last object in the array since it is assumed to be the the
	 * highest priority.
	 * 
	 * @return The removed object
	 */
	@Override
	public T remove() {
		T removedObject = theArray[getLastIndex()];
		theArray[getLastIndex()] = null;
		numberOfEntries--;
		return removedObject;

	}

	/**
	 * Returns the location of the last populated array element. This is tracked
	 * using the capacity of the array.
	 * 
	 * @return the index of the last populated array element.
	 */
	private int getLastIndex() {
		return numberOfEntries - 1;
	}

	/**
	 * Non-destructive return of the highest priority object.
	 * 
	 * @return The peeked object
	 */
	@Override
	public T peek() {
		return theArray[getLastIndex()];
	}

	/**
	 * @return the current populated size of the array.
	 */
	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		int copyNumberOfEntries = numberOfEntries;
		return copyNumberOfEntries;
	}

	/**
	 * 
	 * @return an array copy of the internal array object.
	 */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] populatedArrayCopy = (T[]) new Object[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++) {
			populatedArrayCopy[i] = theArray[i];
		}
		return populatedArrayCopy;
	}

	/**
	 * Joins a priority queue to the current one.
	 * @param apq1
	 */
	public void joinArrayWithPriorityQueue(ArrayPriorityQueue<T> apq1) {
		int apq1Entries = apq1.getCurrentSize();
		int mergedCapacity = apq1Entries + capacity;

		@SuppressWarnings("unchecked")
		T[] mergedArray = (T[]) (new Comparable[mergedCapacity]);
		T[] mergingArray = apq1.toArray();

		ArrayPriorityQueue<T> mergedArrayPriorityQueue = new ArrayPriorityQueue<T>(mergedCapacity);

		for (int i = 0; i < numberOfEntries; i++) {
			mergedArrayPriorityQueue.add(theArray[i]);
		}
		for (int i = 0; i < apq1Entries; i++) {
			mergedArrayPriorityQueue.add(mergingArray[i]);
		}

		theArray = mergedArrayPriorityQueue.toArray();

	}
/**
 * Joins two Array Priority queues 
 * @param apq1 the first priority queue
 * @param apq2 the second priority queue
 * @return a merged copy of both priority queues.
 */
	public ArrayPriorityQueue<T> joinArrayPriorityQueues(ArrayPriorityQueue<T> apq1, ArrayPriorityQueue<T> apq2) {
		int apq1Size = apq1.getCurrentSize();
		int apq2Size = apq2.getCurrentSize();
		T[] apq1Array = apq1.toArray();
		T[] apq2Array = apq2.toArray();

		int mergedCapacity = apq1Size + apq2Size;

		ArrayPriorityQueue<T> mergedArrayPriorityQueue = new ArrayPriorityQueue<T>(mergedCapacity);

		for (int i = 0; i < apq1Size; i++) {
			mergedArrayPriorityQueue.add(apq1Array[i]);
		}
		for (int i = 0; i < apq2Size; i++) {
			mergedArrayPriorityQueue.add(apq2Array[i]);
		}

		return mergedArrayPriorityQueue;

	}

	/**
	 * Returns a representation of the array's contents in the order of the
	 * array itself. Therefore last entry is of highest priority. Uses the
	 * tostring method of each object if overriden.
	 * 
	 * @return The string representation of the array.
	 */
	public String toString() {
		String theString = "";
		for (int i = 0; i < numberOfEntries; i++) {
			theString = theString + "\n" + theArray[i].toString();
		}
		return theString;
	}

	/**
	 * Removes all array elements
	 */
	public void clear() {
		for (int i = 0; i < numberOfEntries; i++) {
			remove();
		}
	}

}
