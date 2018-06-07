package hw5;

public class MaxHeap {
	private int[] data;
	private int heapSize;
	private int maxSize;

	public MaxHeap(int maxSize) {
		if(maxSize<1) this.maxSize = 100;
		else this.maxSize = maxSize;
		data = new int[maxSize];
		heapSize = 0;
	}
	public boolean isEmpty() {
		if(heapSize==0)return true;
		else return false;
	}
	public boolean isFull() {
		if(heapSize == maxSize) return true;
		else return false;
	}

	public void insert(int item) throws Exception {
		int position;
		if (isFull()) throw new Exception();
		heapSize++;
		data[heapSize-1] = item;
		position = heapSize-1;
		while (position > 0 &&
				data[position] > data[(position-1)/2]){
			swap(position, (position-1)/2);
			position = (position-1) / 2;
		}
	}
	public int delete() throws Exception{
		int answer;
		if (isEmpty()) throw new Exception();
		answer = data[0];
		data[0] = data[heapSize-1];
		heapSize--;
		heapify();
		return answer;
		}
	private void heapify() {
		int position = 0; int childPos;
		while (position*2 + 1 < heapSize) {
			childPos = position*2 + 1;
			if (childPos < heapSize-1
					&& data[childPos+1] > data[childPos])
				childPos++;
			if (data[position]>= data[childPos])
				return;
			swap(position, childPos);
			position = childPos;
		}
	}
	private void swap(int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}


}
