package hw3;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>{
	private static final int DEFAULT_CAPACITY = 5;
	protected int top;
	protected T[] A;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		if(initialCapacity <= 0) {
			A = (T[]) new Object[DEFAULT_CAPACITY];
		}
		else {
			A = (T[]) new Object[initialCapacity];
		}
		top = -1;
	}
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	public boolean isEmpty() {
		return top == -1;
	}

	public T pop() throws StackException {
		T x = peek();
		A[top] = null;
		top--;
		return x;
	}

	public T peek() throws StackException {
		if(isEmpty()) 
			throw new StackException("Stack is empty");
		return A[top] ;
	}

	public void push(T e) throws StackException {
		if(top == A.length)
			throw new StackException("Stack has overflowed");
		top++;
		A[top] = e;
	}
	public String printStack() {
		String stack = "";
		for(T a:A) {
			stack += a+" ";
		}
		return stack;
	}

}
