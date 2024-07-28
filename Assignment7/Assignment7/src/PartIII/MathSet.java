package PartIII;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
	
	public Set<E> intersection(Set<E> s2) {
		Set<E> s3 = new HashSet<E>();
		this.forEach(item -> {
			if(s2.contains(item)) s3.add(item);
		});
		return s3;
	}
	
	public Set<E> union(Set<E> s2) {
		Set<E> s3 = new HashSet<E>();
		this.forEach(item -> s3.add(item));
		s2.forEach(item -> s3.add(item));
		return s3;
	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E,T>> result = new HashSet<Pair<E,T>>();
		this.forEach(item1 -> {
			s2.forEach(item2 -> {
				Pair<E,T> pair = new Pair<E,T>(item1, item2);
				result.add(pair);
			});
		});
		return result;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		System.out.println(s1);
		
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(3);
		s2.add(4);
		s2.add(5);
		System.out.println(s2);
		
		Set<Integer> s3 = s1.intersection(s2);
		System.out.println("Intersection: " + s3);
		Set<Integer> s4 = s1.union(s2);
		System.out.println("Union: " + s4);
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		Set<Pair<Integer, Integer>> product = s1.cartesianProduct(s2);
		System.out.println(product);
	}
}
