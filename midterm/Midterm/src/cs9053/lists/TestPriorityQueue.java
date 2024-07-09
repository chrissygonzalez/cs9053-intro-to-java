package cs9053.lists;

public class TestPriorityQueue<E> {
	public static void main(String[] args) {
		// Tests from midterm description
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.offer(4);
		q1.offer(3);
		q1.offer(5);
		
		Queue<Integer> q2 = new PriorityQueue<Integer>();
		q2.offer(4);
		q2.offer(3);
		q2.offer(5);
		
		System.out.println("q1:");
		while(q1.size() > 0) {
			System.out.print(q1.remove() + " ");
		}
		System.out.println();
		
		System.out.println("q2:");
		while(q2.size() > 0) {
			System.out.print(q2.remove() + " ");
		}
		System.out.println();
		
		// Priority Queue without comparator
		System.out.println("--------------------");
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
		
		// Priority Queue with comparator
		System.out.println("--------------------");
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer a, Integer b) -> b - a);
		pq.offer(8);
		pq.offer(12);
		pq.offer(24);
		pq.offer(1);
		pq.offer(16);
		pq.offer(4);
		pq.add(0, 3);
		pq.set(48, 2);
		System.out.println(pq);
		
		pq.remove(1);
		System.out.println(pq);
		
		System.out.println(pq.contains(48));
		System.out.println(pq.get(3));
		
		pq.remove();
		System.out.println(pq);
		
		pq.remove();
		System.out.println(pq);
		
		pq.remove();
		System.out.println(pq);
		
		pq.remove();
		System.out.println(pq);
		
		pq.remove();
		System.out.println(pq);

	}
}