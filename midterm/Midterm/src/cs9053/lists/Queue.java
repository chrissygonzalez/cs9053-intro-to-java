package cs9053.lists;

public interface Queue<E> {
	boolean offer(E e);
	E remove();
	E peek();
	E poll();
	E element();
	int size();
}