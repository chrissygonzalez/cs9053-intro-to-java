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
    // TODO add heapify and call heapify after insert
	public boolean offer(E e) {
		int index = this.size() == 0 ? 0 : findAddIndex(e, 0, this.size() - 1);
		this.add(e, index);
		return true;
	}
	
	public E remove() throws NoSuchElementException {
		if(data.size() == 0) {
			try {
				throw new NoSuchElementException();
			} catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
		
		int lastIndex = data.size() - 1;
		Collections.swap(data, 0, lastIndex);
		return data.remove(lastIndex);
	}
	
	public E peek() {
		if(data.size() == 0) return null;
		return data.get(0);
	}
	
	public E poll() {
		if(data.size() == 0) return null;
		return this.remove();
	}
	
	public E element() throws NoSuchElementException {
		if(data.size() == 0) {
			try {
				throw new NoSuchElementException();
			} catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
		}
		return data.get(0);
	}
	
	// List methods
	public void add(E e) {
		this.offer(e);
	}
	
	public E get(int i) {
		return data.get(i);
	}
	
	public E remove(int i) {
		return data.remove(i);
	}
	
	public void set(E e, int i) {
		// not sure what to do here
	}
	
	public void add(E e, int i) {
		// not sure what to do here
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean contains(Object o) {
		return data.contains(o);
	}
	
	// may not need this method anymore
	private int findAddIndex(E e, int start, int end) {
		if(start > end) {
			return start;
		}
		int midpoint = (start + end) / 2;
		E midValue = get(midpoint);
		
		// same value
		if(compare(e, midValue) == 0) {
			return midpoint;
		}
		
		// value is lower, goes to right
		if(compare(e, midValue) < 0) {
			return findAddIndex(e, midpoint + 1, end);
		}
		
		// value is higher, goes to left
		return findAddIndex(e, start, midpoint - 1);
	}
}