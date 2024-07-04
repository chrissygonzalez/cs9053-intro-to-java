package cs9053.lists;

public class TestPriorityQueue<E> {
	public static void main(String[] args) {
		// Test from midterm description
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.offer(4);
		q1.offer(3);
		q1.offer(5);
		
		Queue<Integer> q2 = new PriorityQueue<Integer>();
		q2.offer(4);
		q2.offer(3);
		q2.offer(5);
		
		System.out.println("q1:");
		System.out.println(q1);
		System.out.println("q2:");
		System.out.println(q2);
		
		// Priority Queue without comparator
		PriorityQueue<Integer> pqi = new PriorityQueue<Integer>();
		pqi.offer(4);
		pqi.offer(1);
		pqi.offer(53);
		pqi.offer(21);
		pqi.offer(9);		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		pqi.remove();		
		System.out.println(pqi);
		
		// Priority Queue with comparator
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer a, Integer b) -> b - a);
		pq.offer(8);
		pq.offer(12);
		pq.offer(24);
		pq.offer(16);
		pq.offer(4);
		System.out.println(pq);
	}
}