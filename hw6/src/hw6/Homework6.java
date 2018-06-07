package hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class Homework6 {
	public static void main(String[] args) throws IOException {
		try {
			File file = new File("src/in1.txt");
			Scanner sc = new Scanner(file);
			System.out.println("READING FILE in1.txt");
			while(sc.hasNextLine()) {
				int cases = sc.nextInt();
				for(int i = 0; i < cases; i++) {
					int r = sc.nextInt();
					int c = sc.nextInt();
					int[][] arr = new int[r][c];
					for(int j = 0; j < r; j++) {
						for(int k = 0; k < c; k++) {
							arr[j][k] = sc.nextInt();
						}
					}
					int tests = sc.nextInt();
					for(int l = 0; l < tests; l++) {
						System.out.println(search2DArray(arr,sc.nextInt()));
					}
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//part 2
		try {
			File file = new File("src/in2.txt");
			Scanner sc = new Scanner(file);
			System.out.println("READING FILE in2.txt");
			while(sc.hasNextLine()) {
				int cases = sc.nextInt();
				for(int i = 0; i < cases; i++) {
					int totalInts = sc.nextInt();
					int mythicConstant = sc.nextInt();
					int[] values = new int[totalInts];
					for(int j = 0; j < totalInts; j++) {
						values[j] = sc.nextInt();
					}
//					System.out.println(hash.values());
					System.out.println(totalTriplets(values,mythicConstant));
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int totalTriplets(int[] arr, int mythicConstant) {
		int total = 0;
		Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length; i++) {
			hash.put(i,arr[i]); //key refers to the integer values
		}
		Hashtable<Integer,Integer> previous = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length; i++) {
			Hashtable<Integer,Integer> tracker = new Hashtable<Integer,Integer>();
			int complement = mythicConstant - arr[i];
			for(int j = i+1; j < arr.length; j++) {
				int complement2 = complement - arr[j];
				if(hash.contains(complement2)&&!hash.get(i).equals(complement2)
						&&!tracker.contains(complement2)&&!hash.get(j).equals(complement2)) {
					tracker.put(j, arr[j]);
					total++;
				}
			}
			previous.put(i, hash.remove(i));
		}
		return total;
	}
	public static void printArray(int[] arr) {
		for(int a: arr) {
			System.out.print(a+" ");
		}
		System.out.println("");
	}

	private static String search2DArray(int[][]arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] <= key || arr[i][arr[i].length-1] >= key) {
				for(int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] == key) {
						return i+" "+j;
					}
				}
			}
		}
		return "-1 -1";
	}
}
