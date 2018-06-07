package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Homework3 {

	public static void main(String[] args) throws StackException {
		// TODO Auto-generated method stub
		try {
			String sCurrentLine;
			//java util stack class
			String[] operators = {"+","-","/","*","^"};
			String postFix = "";
			ArrayStack<String> operatorStack = new ArrayStack<String>();
			//			Stack<String> StackB = new Stack<String>();

			BufferedReader br = new BufferedReader(new FileReader("src/in1.txt"));
			int currentIndex = 0;
			System.out.println("Reading file in1.txt");
			while((sCurrentLine = br.readLine()) != null) {
				if(currentIndex == 0) {
					System.out.println("Number of Test Cases: "+sCurrentLine);
				}
				else {
					String reverse = new StringBuilder(sCurrentLine).reverse().toString();
					//since string is reversed left and right brackets are interpretted slightly differently
					//ex (5+4) has become )4+5(
					for(int i = 0; i < reverse.length();i++) {
						String token = reverse.substring(i,i+1);
						if(token.equals("(")) {
							postFix += operatorStack.pop();
						}
						else if (Arrays.asList(operators).contains(token) ) {
							operatorStack.push(token);
						}
						else if (!(token.equals(")"))) {
							postFix += token;
						}
					}
					System.out.println(new StringBuilder(postFix).reverse().toString());
					postFix = "";
				}
				currentIndex++;
			}
			br.close();

			System.out.println();
			//part two of hw
			br = new BufferedReader(new FileReader("src/in2.txt"));
			currentIndex = 0;
			System.out.println("Reading file in2.txt");
			while((sCurrentLine = br.readLine()) != null) {
				if(currentIndex == 0) {
					System.out.println("Number of test cases: "+sCurrentLine);
				}
				else if(currentIndex%2 == 1) {
					System.out.println("Array size: "+sCurrentLine);
					int size = Integer.parseInt(sCurrentLine);
					LeakyStack<String> leakyStack = new LeakyStack<String>(size);
					sCurrentLine = br.readLine();
					String[] operations = sCurrentLine.split(" ");
					for(String op:operations) {
						leakyStack.push(op);
					}
					System.out.println(leakyStack.printStack());
					currentIndex++;
				}
				currentIndex++;
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}


