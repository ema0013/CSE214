

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{
	private Node<T> head;

	/**
	 *  Constructs an empty list
	 */
	public LinkedList() {
		this.head = null;
	}

	/**
	 *  Returns size of the list
	 */
	public int size() {
		int size = 0;
		if(head != null) {
			size ++;
			Node<T> current = head;
			while(current.next!= null) {
				size ++;
				current = current.next;
			}
		}

		return size;
	}

	/**
	 *  Returns true if the list is empty
	 *
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 *  Removes all nodes from the list.
	 *
	 */
	public void clear() {
		this.head = null;
	}

	/**
	 *  Returns the data at the specified position in the list.
	 */
	public T get(int pos) {
		if(head == null) throw new IndexOutOfBoundsException();
		int currentIndex = 0;
		Node<T> current = head;
		while(currentIndex < pos && current!= null) {
			currentIndex ++;
			current = current.next;
		}

		if(current != null) {
			return current.data;
		} else{
			throw new IndexOutOfBoundsException();
		}

	}

	/**
	 *  Returns true if this list contains the specified element.
	 *
	 */
	public boolean contains(T x) {
		for(T temp: this) {
			if(temp.equals(x)) {
				return true;
			}
		}

		return false;
	}

	/**
	 *  Returns the first element in the list.
	 *
	 */
	public T getFirst() {
		if(head == null) throw new NoSuchElementException();
		return head.data;
	}

	/**
	 *  Inserts a new node at the beginning of this list.
	 *
	 */
	public void addToFirst(T data) {
		this.head = new Node<T>(data, head);
	}

	/**
	 *  Removes the first element in the list.
	 *
	 */
	public T removeFirst() {
		T temp = getFirst();
		head = head.next;
		return temp;
	}

	/**
	 *  Returns the last element in the list.
	 *
	 */
	public T getLast() {
		if(head == null)  throw new NoSuchElementException();
		Node<T> current = head;
		while(current.next != null) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 *  Inserts a new node to the end of this list.
	 *
	 */
	public void addToLast(T data) {
		if(head == null) {
			head = new Node<T>(data, head);
		} else{
			Node<T> current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new Node<T>(data, null);
		}
	}


	/**
	 * Removes the first occurrence of the specified element in this list.
	 * 
	 */

	public void remove(T key) {
		if(head == null) throw new NoSuchElementException();
		if(head.data.equals(key)) {
			head = head.next;
			return;
		}

		Node<T> prev = null;
		Node<T> current = head;
		while(current != null && !current.data.equals(key)) {
			prev = current;
			current = current.next;
		}
		if(current != null) {
			prev.next = current.next;
		} else{
			throw new NoSuchElementException();
		}
	}



	/**
	 * The Node class
	 */
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * 
	 * The Iterator class
	 */

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {
		private Node<T> nextNode;

		public LinkedListIterator() {
			this.nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T d = nextNode.data;
			nextNode = nextNode.next;
			return d;
		}

	}

	/**
	 *  Returns a string representation
	 *
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(Object x : this)
			result.append(x + " ");

		return result.toString();
	}

	/*
	 * *************************
	 * Homework Problems
	 * 
	 * *************************
	 */

	/**
	 *  Inserts a new node at pos.
	 */
	public void insertAt(int pos, T toInsert) {
		if(pos<0) throw new IllegalArgumentException();
		get(pos);
		Node<T> prev = head;
		int i = 0;
		while(i<pos-1) {
			prev = prev.next;
			i++;
		}
		
		Node<T> newInsert = new Node<T>(toInsert,prev.next);
		prev.next = newInsert;
		

	}

	/**
	 * Removes the item at position pos in this list.
	 * 
	 */
	public void removeAt(int pos) {
		if(pos<0) throw new IllegalArgumentException();
		get(pos);
		Node<T> prev = head;
		if(pos==0) {
			head = head.next;
			return;
		}
		int i = 0;
		while(i!=pos-1) {
			prev = prev.next;
			i++;
		}
		Node<T> curr = prev.next;
		prev.next = curr.next;

	}

	/**
	 *  Inserts a new node after a node containing the key.
	 *
	 */
	public void insertAfter(T key, T toInsert) {
		Node<T> curr = head;
		while(!(curr.data.equals(key))) {
			if(curr.next == null) throw new IndexOutOfBoundsException();
			curr = curr.next;
		}
		Node<T> newInsert = new Node<T>(toInsert,curr.next);
		curr.next = newInsert;
	}

	/**
	 *  Inserts a new node before a node containing the key.
	 */
	public void insertBefore(T key, T toInsert) {
		Node<T> curr = head;
		Node<T> prev = null;
		if(curr.data.equals(key)) {
			addToFirst(toInsert);
			return;
		}
		while(!(curr.data.equals(key))) {
			if(curr.next.equals(null)) throw new IndexOutOfBoundsException();
			prev = curr;
			curr = curr.next;
		}
		Node<T> newInsert = new Node<T>(toInsert,curr);
		prev.next = newInsert;
	}

	/**
	 *  sort the list
	 */
	public void sortList() {
		//merge sort
		mergeSort(head);
	}

	private Node<T> mergeSort(Node<T> head) {
		if(head==null||head.next==null) {
			return head;
		}
		Node<T> middle = getMiddle(head);
		Node<T> half = middle.next;
		middle.next = null;
		Node<T> left = mergeSort(head);
		Node<T> right = mergeSort(half);
		return merge(left,right);
	}

	private Node<T> merge(Node<T> nodeA, Node<T> nodeB) {
		if(nodeA==null) {
			return nodeB;
		}
		if(nodeB==null) {
			return nodeA;
		}
		Node<T> temp = new Node<T>(null,null);
		if(((Integer)nodeA.data).compareTo((Integer)nodeB.data)<=0){
			temp=nodeA;
			temp.next = merge(nodeA.next, nodeB);
		}else{
			temp=nodeB;
			temp.next = merge(nodeA, nodeB.next);
		}
		return temp;
	} 

	private Node<T> getMiddle(Node<T> head) {
		if(head==null) {
			return head;
		}
		Node<T> middle,fullTraverse;
		middle = fullTraverse = head;
		while(fullTraverse.next!=null&&fullTraverse.next.next!=null){
			middle = middle.next;
			fullTraverse = fullTraverse.next.next;
		}
		return middle;
	}

	/**
	 * removes duplicate elements from the list
	 */
	public void removeDuplicates() {
		sortList();
		for(int i = 0; i < size();i++) {
			T currentData = get(i);
			for(int j = i+1;j < size(); j++) {
				if(currentData.equals(get(j))) {
					removeAt(j);
					i--;
				}
			}
		}
	}


}
