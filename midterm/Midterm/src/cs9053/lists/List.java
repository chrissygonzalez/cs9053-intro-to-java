package cs9053.lists;

public abstract class List<E> {

	abstract void add(E e);
	
	abstract E get(int i);
	
	abstract E remove(int i);
	
	abstract void set(E e, int i);
	
	abstract void add(E e, int i);
	
	abstract int size();
	
	abstract boolean contains(Object o);
}