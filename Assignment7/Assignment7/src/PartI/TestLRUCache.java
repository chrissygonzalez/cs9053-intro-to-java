package PartI;

public class TestLRUCache{
	public static void main(String[] args) {
		LRUCache<String> test = new LRUCache<String>(3);
		test.put(1, "first");
		test.put(2, "second");
		test.put(3, "third");
		test.get(1);
		test.put(4, "fourth");
	}
}