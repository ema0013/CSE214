import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TwoSum{
	
	public static void main(String[] args) throws IOException{
		String sCurrentLine; 
		BufferedReader br = new BufferedReader(new FileReader("src/test2sum.txt"));
		
		int currentIndex = 0;
		int[] numbers = null;
		int sumValue = 0;
		while ((sCurrentLine = br.readLine()) != null) {
			if(currentIndex % 2 == 0) {
				numbers = getNumbers(sCurrentLine);
			} else {
				sumValue = Integer.parseInt(sCurrentLine);
				boolean hasTwoSum = hasTwoSumInArray(numbers, sumValue);
				System.out.println(hasTwoSum);
			}
			currentIndex ++;
			
		}
	}
	
	private static boolean hasTwoSumInArray(int[] numbers, int sumValue) {
		boolean result = false;
		// Your code goes here and set result
		for(int i = 0; i < numbers.length;i++) {
			int diff = sumValue - numbers[i];
			for(int j = i+1; j < numbers.length; j++) {
				if(j != i &&numbers[j] == diff) {
					result = true;
				}
			}
		}
		return result;
	}
	
	private static int[] getNumbers(String currentLine) {
		String[] items = currentLine.split(",");
		int[] numbers = new int[items.length];
		for(int i = 0; i < items.length; i++) {
			try {
				numbers[i] = Integer.parseInt(items[i]);
			} catch(NumberFormatException e) {
				System.out.println("Error Occurred: " + e.getMessage());
			}
		}
		
		return numbers;
	}
}