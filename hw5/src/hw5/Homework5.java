package hw5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework5 {

	public static void main(String[] args) throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader("src/in1.txt"));
		int currentIndex = 0;
		//part 1
		System.out.println("Reading file in1.txt");
		int cases = 0;
		while((sCurrentLine = br.readLine()) != null) {
			if(currentIndex==0) {
				cases = Integer.parseInt(sCurrentLine);
			}
			else {
				for(int j = 0; j < cases; j++) {
					int inserts = Integer.parseInt(sCurrentLine);
					BinarySearchTree bst = new BinarySearchTree();
					sCurrentLine = br.readLine();
					currentIndex++;
					for(int i = 0; i < inserts; i ++) {

						bst.insert(Integer.parseInt(sCurrentLine.substring(i*2, i*2+1)));
						currentIndex++;
					}
					bst.topView();
					System.out.println("");
					sCurrentLine = br.readLine();
					currentIndex++;
				}

			}
			currentIndex++;
		}
		br.close();
		//part two
		br = new BufferedReader(new FileReader("src/in2.txt"));
		currentIndex = 0;
		System.out.println("Reading file in2.txt");
		cases = 0;
		while((sCurrentLine = br.readLine()) != null) {
			if(currentIndex==0) {
				cases = Integer.parseInt(sCurrentLine);
			}
			else {
				for(int i = 0; i < cases; i ++) {
					MaxHeap mh = new MaxHeap(1000000);
					int rows = Integer.parseInt(sCurrentLine.substring(0,1));
					int people = Integer.parseInt(sCurrentLine.substring(2, 3));
					int money = 0;
					sCurrentLine = br.readLine();
					currentIndex++;
					for(int j = 0; j < rows; j ++) {
						mh.insert(Integer.parseInt(sCurrentLine.substring(j*2, j*2+1)));
					}
					for(int k = 0; k < people; k ++) {
						int ticket = mh.delete();
						money+=ticket;
						if(ticket-1!=0) {
							mh.insert(ticket-1);
						}
					}
					System.out.println(money);
				}
			}
			currentIndex++;
		}




	}

}
