package cs9053.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueue<E extends Comparable<E>> extends List<E> implements Queue<E> {
	private ArrayList<E> data = new ArrayList<E>();
	private Comparator<? super E> comparator = null;
	
	public PriorityQueue() {
	}
	
	public PriorityQueue(Comparator<? super E> c) {
		this.comparator = c;
	}
	
    public int compare(E a, E b) {
    	if(this.comparator != null) {
    		return this.comparator.compare(a, b);
    	} else {
    		return a.compareTo(b);
    	}
    }
	
    // Queue methods
	public boolean offer(E e) {
		data.add(e);
		heapifyFromBottom(data.size() - 1);
		return true;
	}
	
	public E remove() {
		if(data.size() == 0) throw new NoSuchElementException();
		
		int lastIndex = data.size() - 1;
		Collections.swap(data, 0, lastIndex);
		E removed = data.remove(lastIndex);
		
		if(lastIndex > 0) heapifyFromTop(0);
		return removed;
	}
	
	public E peek() {
		if(data.size() == 0) return null;
		return data.get(0);
	}
	
	public E poll() {
		if(data.size() == 0) return null;
		return this.remove();
	}
	
	public E element() {
		if(data.size() == 0) throw new NoSuchElementException();
		return data.get(0);
	}
	
	// List methods
	public void add(E e) {
		data.add(e);
		heapifyFromBottom(data.size() - 1);
	}
	
	public E get(int i) {
		return data.get(i);
	}
	
	public E remove(int i) {
		if(i < 0 || i > size()) return null;
		E removed = data.remove(i);
		if(i == 0) heapifyFromTop(0);
		return removed;
	}
	
	public void set(E e, int i) {
		data.set(i, e);
		heapifyFromBottom(i);
	}
	
	public void add(E e, int i) {
		// ignoring the index because we're going to heapify anyway,
		// and moving elements for no reason is expensive
		data.add(e);
		heapifyFromBottom(this.size() - 1);
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean contains(Object o) {
		return data.contains(o);
	}
	
	public String toString() {
		String output = "{ ";
		for(E item : data) {
			output += item + " ";
		}
		output += "}";
		return output;
	}
	
	// Heap helpers
	private void heapifyFromBottom(int i) {
		if(i == 0) return;
		E newItem = data.get(i);
		int parentIndex = parent(i);
		E parent = data.get(parentIndex);
		
		if(compare(newItem, parent) > 0) {
			Collections.swap(data, i, parentIndex);
			heapifyFromBottom(parentIndex);
		}
	}
	
	private void heapifyFromTop(int i) {
		E node = data.get(i);
		E max = node;
		int maxIndex = i;
		
		int leftIndex = left(i);
		if(leftIndex < data.size()) {
			E leftChild = data.get(leftIndex);
			if(compare(max, leftChild) < 0) {
				max = leftChild;
				maxIndex = leftIndex;
			}
		}
		
		int rightIndex = right(i);
		if(rightIndex < data.size()) {
			E rightChild = data.get(rightIndex);
			if(compare(max, rightChild) < 0) {
				max = rightChild;
				maxIndex = rightIndex;
			}
		}
		
		if(max != node) {
			Collections.swap(data, i, maxIndex);
			heapifyFromTop(maxIndex);
		}
	}
	
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return 2 * i + 2;
	}
}