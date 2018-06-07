package hw4;

public class Queue {
	private Node head,end;
	private int nodeCount;
	
	public Queue() {
		head = end = null;
		nodeCount = 0;
	}
	
	private class Node {
		int roll;
		int school;
		Node next;
		public Node() {
			roll = 0;
			school = 0;
			next = null;
		}
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void enqueue(int S, int R) {
		//insert at end of deque
		Node node = new Node();
		node.roll = R;
		node.school = S;
		if(head == null) {
			head = end = node;
			head.next = null;
		}
		else {
			end.next = node;
			end = node;
			end.next = null;
		}
		nodeCount++;
	}
	public int[] dequeue() {
		//remove from front
		int R = head.roll;
		int S = head.school;
		int[]data = new int[2];
		if(nodeCount == 1)  head = end = null;
		else {
			Node temp = head.next;
			head.next = null;
			head = temp;
		}
		nodeCount --;
		data[0] = S;
		data[1] = R;
		return data;
	}
}
