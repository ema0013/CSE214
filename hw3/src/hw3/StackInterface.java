package hw3;

import java.util.EmptyStackException;

public interface StackInterface<T> {
	public boolean isEmpty();
	
	public T pop() throws StackException;
	
	public T peek() throws StackException;
	
	public void push(T e) throws StackException;

}
