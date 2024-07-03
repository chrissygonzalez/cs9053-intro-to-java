package cs9053.lists;

public class LinkedList<E> extends List<E> implements Queue<E> {
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public E getHead(){
		if(this.head != null) {
			return this.head.value;
		}
		return null;
	}
	
	public E getTail(){
		if(this.tail != null) {
			return this.tail.value;
		}
		return null;
	}
	
	public void add(E e) {
		Node<E> n = new Node<E>(e);
		
		if(this.head == null) {
			this.head = n;
			this.tail = n;
		} else {
			this.tail.setNext(n);
			this.tail = n;
		}
		this.size++;
	};
	
	public void add(E e, int i) {
		Node<E> prev = getNode(i - 1);
		Node<E> node = prev != null ? prev.getNext() : null;
		
		if(prev != null) {
			Node<E> n = new Node<E>(e);
			prev.setNext(n);
			n.setNext(node);
			this.size++;
		}
	}
	
	public E get(int i) {
		Node<E> node = getNode(i);
		if(node != null) {
			return node.getVal();
		}
		
		return null;
	};
	
	public E remove(int i) {
		// no nodes or index higher than available nodes
		if(this.size == 0  || i > this.size - 1) {
			return null;
		}
		
		// removing head: special case if only head exists
		if(i == 0) {
			E value = this.head.getVal();
			if(this.size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.getNext();
			}
			this.size--;
			return value;
		}
		
		// list has size, valid index, not removing head
		Node<E> prev = getNode(i - 1);
		Node<E> node = prev.getNext();
		E value = node.getVal();
		
		// removing tail
		if(i == this.size - 1) {
			this.tail = prev;
		}
		
		prev.setNext(node.getNext());
		this.size--;
		return value;
	};
	
	public void set(E e, int i) {
		Node<E> node = getNode(i);
		if(node != null) {
			node.setVal(e);
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean contains(Object o) {
		Node<E> n = this.head;
		
		while(n != null) {
			if(n.getVal().equals(o)) return true;
			n = n.getNext();
		}
		
		return false;
	}
	
	// Queue methods
	public boolean offer(E e) {
		this.add(e);
		return true;
	}
	
	public E remove() throws NoSuchElementException {
		Node<E> n = this.head;
		
		if(n == null) {
			try {
				throw new NoSuchElementException();
			} catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		
		this.head = n.getNext();
		return n.getVal();
	}
	
	public E peek() {
		if(this.head == null) return null;
		
		return this.head.getVal();
	}
	
	public E poll() {
		if(this.head == null) return null;
		
		Node<E> n = this.head;
		this.head = n.getNext();
		return n.getVal();
	}
	
	public E element() throws NoSuchElementException {
		Node<E> n = this.head;
		
		if(n == null) {
			try {
				throw new NoSuchElementException();
			} catch(NoSuchElementException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		
		return n.getVal();
	}
	
	// private helper for LinkedList
	private Node<E> getNode(int i){
		int count = 0;
		Node<E> node = head;
		
		while(count < i && node != null) {
			node = node.getNext();
			count++;
		}
		
		if(node != null) {
			return node;
		}
		
		return null;
	}
	
	// Node inner class
	public class Node<F> {
		private F value;
		private Node<F> next;
		
		public Node() {
			this.value = null;
			this.next = null;
		}
		
		public Node(F value) {
			this.value = value;
		}
		
		public Node(F value, Node<F> next) {
			this.value = value;
			this.next = next;
		}
		
		public Node<F> getNext() {
			return this.next;
		}
		
		public void setNext(Node<F> f) {
			this.next = f;
		}
		
		public F getVal() {
			return value;
		}
		
		public void setVal(F f) {
			this.value = f;
		}
	}
}