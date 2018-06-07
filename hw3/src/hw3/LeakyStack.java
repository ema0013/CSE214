package hw3;

public class LeakyStack<T> extends ArrayStack<T> {
	public LeakyStack(int initialCapacity){
		super(initialCapacity);
	}
	public LeakyStack() {
		super();
	}
	public void push(T e) throws StackException {
		if(top == A.length-1) {
			for(int i = 0; i < A.length-1; i++) {
				A[i] = A[i+1];
			}
			A[top] = e;
		}
		else {
			super.push(e);
		}
	}
	
}
