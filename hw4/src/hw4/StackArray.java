package hw4;

public class StackArray {
	private Node first;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String[] data) {
		Node oldFirst = first;
		first = new Node();
		first.data = data;
		first.next = oldFirst;
	}
	
	public String[] pop() {
		String[] data = first.data;
		first = first.next;
		return data;
	}
	
	private class Node {
		private String[] data;
		private Node next;
	}

}
