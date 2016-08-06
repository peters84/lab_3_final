/**
 *
 */
package arrayImpl;

import java.lang.reflect.Array;

import lab_3.Employee;
import lab_3.PriorityQueueInterface;

/**
 * @author Peter Socha
 *
 *
 */


public class ArrayPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface <T> {
	private T[] theArray;
	private static final int DEFAULT_SIZE = 10;
	private int capacity;
	private int numberOfEntries = 0;



	public ArrayPriorityQueue(int newCapacity) {

		@SuppressWarnings("unchecked")
		T[] anArray = (T[])(new Comparable[newCapacity]);
		theArray  = anArray;
	}

	public ArrayPriorityQueue() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_SIZE);
	}
	@Override
	public void add(T newEntry) {
	//public void add(T newEntry) {

		System.out.println("Attempting to add employee" + newEntry.toString());
		// TODO Auto-generated method stub


		int addIndex = numberOfEntries - 1;
		while ( addIndex>= 0 && newEntry.compareTo(theArray[addIndex])<0){
		//while ( addIndex>= 0 && isLowerPriorityThan(newEntry,theArray[addIndex])){
			theArray[addIndex+1] = theArray[addIndex];
			addIndex--;
		}
		theArray[addIndex +1] = newEntry;
		numberOfEntries++;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		T removedObject = theArray[getLastIndex()];
		theArray[getLastIndex()] = null;
		numberOfEntries--;
		return removedObject;


	}

	public int getLastIndex(){
		return numberOfEntries-1;
	}
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return theArray[getLastIndex()];
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		int copyNumberOfEntries = numberOfEntries;
		return copyNumberOfEntries;
	}

	public T[] toArray(){
		@SuppressWarnings("unchecked")
		T[] populatedArrayCopy = (T[]) new Object[numberOfEntries];
		for(int i = 0; i<numberOfEntries;i++){
			populatedArrayCopy[i] = theArray[i];
		}
		return populatedArrayCopy;
	}


	public void joinArrayWithPriorityQueue(ArrayPriorityQueue<T> apq1){
		int apq1Entries =  apq1.getCurrentSize();
		int mergedCapacity = apq1Entries + capacity;

		@SuppressWarnings("unchecked")
		T[] mergedArray = (T[])(new Comparable[mergedCapacity]);
		T[] mergingArray = apq1.toArray();

		ArrayPriorityQueue<T> mergedArrayPriorityQueue = new ArrayPriorityQueue<T>(mergedCapacity);

		for (int i =0; i< numberOfEntries;i++){
			mergedArrayPriorityQueue.add(theArray[i]);
		}
		for (int i =0; i< apq1Entries;i++){
			mergedArrayPriorityQueue.add(mergingArray[i]);
		}

		theArray = mergedArrayPriorityQueue.toArray();

	}

	public ArrayPriorityQueue<T> joinArrayPriorityQueues(ArrayPriorityQueue<T> apq1,ArrayPriorityQueue<T> apq2){
		int apq1Size = apq1.getCurrentSize();
		int apq2Size = apq2.getCurrentSize();
		T[] apq1Array = apq1.toArray();
		T[] apq2Array = apq2.toArray();

		int mergedCapacity = apq1Size+ apq2Size;

		ArrayPriorityQueue<T> mergedArrayPriorityQueue = new ArrayPriorityQueue<T>(mergedCapacity);

		for (int i =0; i< apq1Size;i++){
			mergedArrayPriorityQueue.add(apq1Array[i]);
		}
		for (int i =0; i< apq2Size;i++){
			mergedArrayPriorityQueue.add(apq2Array[i]);
		}

		return mergedArrayPriorityQueue;

	}

	public String toString(){
		String theString = "";
		for (int i = 0; i<numberOfEntries;i++){
			theString = theString + "\n" + theArray[i].toString();
		}
		return theString;
	}

	public void clear(){
		for (int i = 0; i<numberOfEntries;i++){
			remove();
		}
	}

}
