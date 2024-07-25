package PartI;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<V> {
	private LinkedHashMap<Integer,V> data;
	
	public LRUCache(int capacity) {
		data = new LinkedHashMap<Integer, V>(capacity, 0.75F, true){
			protected boolean removeEldestEntry(Map.Entry<Integer, V> eldest) {
				return data.size() > capacity;
			}
		};
	}
	
	public void put(Integer k, V value) {
		data.put(k, value);
	}
	
	public V get(Integer k) {
		return data.get(k);
	}
}
