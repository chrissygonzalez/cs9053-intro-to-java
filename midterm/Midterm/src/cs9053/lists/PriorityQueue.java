package cs9053.lists;

import java.util.Comparator;

public class PriorityQueue<E extends Comparable<E>> extends LinkedList<E> {
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
	
	@Override
	public boolean offer(E e) {
		int index = this.size() == 0 ? 0 : findAddIndex(e, 0, this.size() - 1);
		this.add(e, index);
		return true;
	}
	
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