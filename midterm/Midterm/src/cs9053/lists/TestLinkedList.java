package cs9053.lists;

public class TestLinkedList {
	public static void main(String[] args) {
		// Testing Queue methods on a LinkedList
		LinkedList<Integer> q = new LinkedList<Integer>();
		try {
			q.remove();
		} catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Adding to list now");
		q.offer(5);
		q.offer(15);
		q.offer(25);
		q.offer(35);
		System.out.println("peek: " + q.peek());
		System.out.println("poll: " + q.poll()); // should remove head
		System.out.println("peek: " + q.peek());
		System.out.println("element: " + q.element());
		q.remove();
		System.out.println("peek: " + q.peek());
		q.remove();
		q.remove();
		try {
			q.element();
		} catch(NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------------------");
		
		// Testing List and LinkedList methods on a LinkedList
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(12);
		l.add(8);
		l.add(16);
		l.add(24);
		l.add(32);
		System.out.println("head: " + l.getHead());
		System.out.println("tail: " + l.getTail());
		System.out.println("get index 2: " + l.get(2));
		
		l.remove(2);
		System.out.println("get index 2: " + l.get(2));
		
		l.add(16, 2);
		System.out.println("get index 2: " + l.get(2));
		
		l.set(17, 2);
		System.out.println("get index 2: " + l.get(2));
		System.out.println("size: " + l.size());
		
		Integer n = new Integer(16);
		System.out.println("contains 16: " + l.contains(n));
		
		n = new Integer(17);
		System.out.println("contains 17: " + l.contains(n));

		System.out.println(l);
		
		int s = l.size();
		while(s > 0) {
			System.out.println("-- size: " + l.size());
			System.out.println("-- head: " + l.getHead());
			System.out.println("-- tail: " + l.getTail());
			l.remove(--s);
		}
		System.out.println("size: " + l.size());
		System.out.println("head: " + l.getHead());
		System.out.println("tail: " + l.getTail());
	}
}