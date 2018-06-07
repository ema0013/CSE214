
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LinkedListTest {

	private static final int INSERT_AT = 1;
	private static final int REMOVE_AT = 2;
	private static final int INSERT_AFTER = 3;
	private static final int INSERT_BEFORE = 4;
	private static final int SORT_LIST = 5;
	private static final int REMOVE_DUPLICATES = 6;
	
	public static void main(String[] args) {
		
		try {
			String sCurrentLine;
			LinkedList<Integer> list1 = null;
			LinkedList<Integer> list2 = null;
			
			// read and test first input file and create list1
			BufferedReader br = new BufferedReader(new FileReader("src/input1.txt"));
			int currentIndex = 0;
			System.out.println("reading input file: input1.txt");
			while ((sCurrentLine = br.readLine()) != null) {
				if(currentIndex == 0) {// read elements 
					list1 = createListFromInput(sCurrentLine);	
					System.out.println("List: " + list1.toString());
				} else { // read commands
					String[] command = sCurrentLine.split(" ");
					int commandCode = Integer.parseInt(command[0]);
					
					switch(commandCode) {
						case INSERT_AT:
							int pos = Integer.parseInt(command[1]);
							int data = Integer.parseInt(command[2]);
							list1.insertAt(pos,data);
							System.out.println("insertAt (" + pos + ", " + data +")");
							System.out.println("List: " + list1.toString());
							break;
						case REMOVE_AT:
							pos = Integer.parseInt(command[1]);
							list1.removeAt(pos);
							System.out.println("removeAt (" + pos + ")");
							System.out.println("List: " + list1.toString());
							break;
						case INSERT_AFTER:
							int key = Integer.parseInt(command[1]);
							data = Integer.parseInt(command[2]);
							list1.insertAfter(key,data);
							System.out.println("insertAfter (" + key + ", " + data +")");
							System.out.println("List: " + list1.toString());
							break;
						case INSERT_BEFORE:
							key = Integer.parseInt(command[1]);
							data = Integer.parseInt(command[2]);
							list1.insertBefore(key,data);
							System.out.println("insertBefore (" + key + ", " + data +")");
							System.out.println("List: " + list1.toString());
							break;
						case SORT_LIST:
							list1.sortList();
							System.out.println("sortList()");
							System.out.println("List: " + list1.toString());
							break;
						case REMOVE_DUPLICATES:
							list1.removeDuplicates();
							System.out.println("removeDuplicates()");
							System.out.println("List: " + list1.toString());
							break;
						default:
					}
					
					
				}
				currentIndex ++;
			}
			br.close();
			
			System.out.println();
			// read and test second input file and create list1
			br = new BufferedReader(new FileReader("src/input2.txt"));
			currentIndex = 0;
			System.out.println("reading input file: input2.txt");
			while ((sCurrentLine = br.readLine()) != null) {
				if(currentIndex == 0) {// read elements 
					list2 = createListFromInput(sCurrentLine);	
					System.out.println("List: " + list2.toString());
				} else { // read commands
					String[] command = sCurrentLine.split(" ");
					int commandCode = Integer.parseInt(command[0]);
					
					switch(commandCode) {
						case INSERT_AT:
							int pos = Integer.parseInt(command[1]);
							int data = Integer.parseInt(command[2]);
							list2.insertAt(pos,data);
							System.out.println("insertAt (" + pos + ", " + data +")");
							System.out.println("List: " + list2.toString());
							break;
						case REMOVE_AT:
							pos = Integer.parseInt(command[1]);
							list2.removeAt(pos);
							System.out.println("removeAt (" + pos + ")");
							System.out.println("List: " + list2.toString());
							break;
						case INSERT_AFTER:
							int key = Integer.parseInt(command[1]);
							data = Integer.parseInt(command[2]);
							list2.insertAfter(key,data);
							System.out.println("insertAfter (" + key + ", " + data +")");
							System.out.println("List: " + list2.toString());
							break;
						case INSERT_BEFORE:
							key = Integer.parseInt(command[1]);
							data = Integer.parseInt(command[2]);
							list2.insertBefore(key,data);
							System.out.println("insertBefore (" + key + ", " + data +")");
							System.out.println("List: " + list2.toString());
							break;
						case SORT_LIST:
							list2.sortList();
							System.out.println("sortList()");
							System.out.println("List: " + list2.toString());
							break;
						case REMOVE_DUPLICATES:
							list2.removeDuplicates();
							System.out.println("removeDuplicates()");
							System.out.println("List: " + list2.toString());
							break;
						default:
					}
					
				}
				currentIndex ++;
			}
			br.close();
			
			System.out.println();
			// merge 2 lists
			if(list1 != null && list2 != null) {
				System.out.println("List 1: " + list1.toString());
				System.out.println("List 2: " + list2.toString());
				LinkedList<Integer> output = mergeLists(list1, list2);
				System.out.println("Output: " + output.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 
	 * Implement a mergeLists method in LinkedListTest class that merges 2 given
	 * lists and returns an output list. While merging make sure: 1. Output list is
	 * sorted 2. Remove any duplicate
	 * 
	 */

	public static LinkedList<Integer> mergeLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> output = new LinkedList<Integer>();
		for(int i = 0; i < list1.size();i++) {
			output.addToLast(list1.get(i));
		}
		for(int i = 0; i < list2.size();i++) {
			output.addToLast(list2.get(i));
		}
		output.removeDuplicates();
		return output;

	}
	
	public static LinkedList<Integer> createListFromInput(String input) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(input != null) {
			String[] numbers = input.split(" ");
			for(String number:numbers) {
				list.addToLast(Integer.parseInt(number));
			}
		}
		return list;
		
	}

}
