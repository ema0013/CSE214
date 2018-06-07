package hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Homework4 {

	public static void main(String[] args) throws IOException {
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader("src/in1.txt"));
		int currentIndex = 0;
		//part 1
		int cases = 0;
		System.out.println("Reading file in1.txt");
		Queue s1 = new Queue();
		Queue s2 = new Queue();
		Queue s3 = new Queue();
		Queue s4 = new Queue();
		int school,roll = 0;
		ArrayList<Integer> schoolOrder = new ArrayList<Integer>();
		while((sCurrentLine = br.readLine()) != null) {
			if(currentIndex == 0) {
				cases = Integer.parseInt(sCurrentLine);
			}
			else {
				for(int i = 0; i < cases; i++) {
					System.out.println(i+1);
					int lines = Integer.parseInt(sCurrentLine);
					s1 = new Queue();
					s2 = new Queue();
					s3 = new Queue();
					s4 = new Queue();
					schoolOrder.clear();
					for(int j = 0; j < lines;j++) {
						sCurrentLine = br.readLine();
						currentIndex++;
						if(sCurrentLine.substring(0, 1).equals("E")) {
							school = Integer.parseInt(sCurrentLine.substring(2, 3));
							roll = Integer.parseInt(sCurrentLine.substring(4, 5));
							switch(school){
							case(1):{
								s1.enqueue(school,roll);
								break;
							}
							case(2):{
								s2.enqueue(school,roll);
								break;
							}
							case(3):{
								s3.enqueue(school,roll);
								break;
							}
							case(4):{
								s4.enqueue(school,roll);
								break;
							}
							}
							if(schoolOrder.isEmpty()||!schoolOrder.contains(school)) {
								schoolOrder.add(school);
							}
						}
						else {
							
							school = schoolOrder.get(0);
							if(school == 1) {
								int[] data = s1.dequeue();
								System.out.println(data[0]+" "+data[1]);
								if(s1.isEmpty()) {
									schoolOrder.remove(0);
								}
							}
							else if (school == 2) {
								int[] data = s2.dequeue();
								System.out.println(data[0]+" "+data[1]);
								if(s2.isEmpty()) {
									schoolOrder.remove(0);
								}
							}
							else if (school == 3) {
								int[] data = s3.dequeue();
								System.out.println(data[0]+" "+data[1]);
								if(s3.isEmpty()) {
									schoolOrder.remove(0);
								}
							}
							else if (school == 4) {
								int[] data = s4.dequeue();
								System.out.println(data[0]+" "+data[1]);
								if(s4.isEmpty()) {
									schoolOrder.remove(0);
								}
							}
						}
//						System.out.println(sCurrentLine);
					}
					sCurrentLine = br.readLine();
				}
			}
			currentIndex++;
		}
		br.close();
		
		//part 2
		br = new BufferedReader(new FileReader("src/in2.txt"));
		currentIndex = 0;
		LinkedList<Coin> Moana = new LinkedList<Coin>();
		Stack<Coin> Teka = new Stack<Coin>();
		//java api linkedlist has queue functions
		int commands = 0;
		int goal = 0;
		int totalCoins = 0;
		int totalValue = 0;
		System.out.println("Reading file in2.txt");
		while((sCurrentLine = br.readLine())!=null) {
			if(currentIndex == 0) {
				cases = Integer.parseInt(sCurrentLine);
			}
			else {
				for(int i = 0; i < cases; i++) {
					int coinCount = Integer.parseInt(sCurrentLine);
					for(int j = 0; j < 2; j++) {
						if(j == 0) {
							sCurrentLine = br.readLine();
							currentIndex++;
							String[] data = sCurrentLine.split(" ");
							for(int m = 0; m < coinCount;m++) {
								Moana.add(new Coin(Integer.parseInt(data[m])));
							}
						}
						else if (j == 1) {
							sCurrentLine = br.readLine();
							String[] data = sCurrentLine.split(" ");
							commands = Integer.parseInt(data[0]);
							goal = Integer.parseInt(data[1]);
							for(int k = 0; k < commands; k++) {
								totalCoins = 0;
								totalValue = 0;
								sCurrentLine = br.readLine();
								currentIndex++;
								if(sCurrentLine.equals("Take")) {
									Teka.push(Moana.removeFirst());
								}
								else {
									Teka.pop();
								}
								Stack<Coin> placeHolder = new Stack<Coin>();
								while(!Teka.isEmpty()) {
									Coin temp = Teka.pop();
									totalCoins++;
									totalValue += temp.getValue();
									placeHolder.push(temp);
								}
								if(totalValue>=goal) {
									System.out.println(totalCoins);
									int difference = commands - (k+1);
									for(int g = 0; g < difference; g++) {
										sCurrentLine = br.readLine();
									}
									break;
								}
								while(!placeHolder.isEmpty()) {
									Teka.push(placeHolder.pop());
								}
							}
							if(totalValue<goal) {
								System.out.println("-1");
							}
						}
					}
					sCurrentLine = br.readLine();
				}
			}
			currentIndex++;
		}
		br.close();
	}
}
