package cs9053.lists;

public class LinkedList<E> extends List<E> implements Queue<E> {
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	// LinkedList methods
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public E getHead(){
		if(this.head == null) return null;
		return this.head.value;
	}
	
	public E getTail(){
		if(this.tail == null) return null;
		return this.tail.value;
	}
	
	// List methods
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
		// return if index is out of bounds
		if(i > this.size || i < 0) return;
		
		// insert at head
		if(i == 0) {
			if(this.head == null) {
				Node<E> n = new Node<E>(e);
				this.head = n;
				this.tail = n;
			} else {
				Node<E> n = new Node<E>(e);
				n.setNext(this.head);
				this.head = n;
			}
			this.size++;
			return;
		}
		
		// insert within list
		Node<E> prev = getNode(i - 1);
		Node<E> node = prev.getNext();
		Node<E> n = new Node<E>(e);
		prev.setNext(n);
		n.setNext(node);
		this.size++;
	}
	
	public E get(int i) {
		Node<E> node = getNode(i);
		if(node == null) return null;
		return node.getVal();
	};
	
	public E remove(int i) {
		// return null if index out of bounds
		if(i > this.size - 1 || i < 0) return null;
		
		// removing head
		if(i == 0) {
			E value = this.head.getVal();
			// special case if head was only node
			if(this.size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.getNext();
			}
			this.size--;
			return value;
		}
		
		// removing from within list
		Node<E> prev = getNode(i - 1);
		Node<E> node = prev.getNext();
		E value = node.getVal();
		
		// special case if removing tail
		if(i == this.size - 1) {
			this.tail = prev;
		}
		
		prev.setNext(node.getNext());
		this.size--;
		return value;
	};
	
	public void set(E e, int i) {
		if(i > this.size || i < 0) return;
		
		Node<E> node = getNode(i);
		node.setVal(e);
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
	
	public E remove() {
		Node<E> n = this.head;
		if(n == null) throw new NoSuchElementException();
		
		this.size--;
		this.head = n.getNext();
		return n.getVal();
	}
	
	public E peek() {
		if(this.head == null) return null;
		
		return this.head.getVal();
	}
	
	public E poll() {
		Node<E> n = this.head;
		if(n == null) return null;
		
		this.size--;
		this.head = n.getNext();
		return n.getVal();
	}
	
	public E element() {
		Node<E> n = this.head;
		if(n == null) throw new NoSuchElementException();
		
		return n.getVal();
	}
	
	public String toString() {
		String s = "{ ";
		Node<E> n = this.head;
		while(n != null) {
			s = s + n + " ";
			n = n.getNext();
		}
		s = s + "}\n";
		return s;
	}
	
	// private helper for LinkedList
	private Node<E> getNode(int i){
		int count = 0;
		Node<E> node = head;
		
		while(count < i && node != null) {
			node = node.getNext();
			count++;
		}
		
		return node;
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
		
		public String toString() {
			return this.value.toString();
		}
	}
}