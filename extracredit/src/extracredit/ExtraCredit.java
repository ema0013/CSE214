package extracredit;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ExtraCredit {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src/in.txt");
		Scanner sc = new Scanner(file);
		System.out.println("Reading File in.txt");
		while(sc.hasNextLine()) {
			int testCases = sc.nextInt();
			for(int i = 0; i < testCases; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int[][] honeyComb = new int[row][col];
				for(int j = 0; j < row; j++) {
					for(int l = 0; l < col; l++) {
						honeyComb[j][l] = sc.nextInt();
					}
				}
				int cases = sc.nextInt();
				for(int k = 0; k < cases; k++) {
					int howMany = sc.nextInt();
					if(howMany == 1) {
						System.out.println(honeyCount1(honeyComb,sc.nextInt(),sc.nextInt()));
					}
					else {
						System.out.println(honeyCount2(honeyComb,sc.nextInt(),sc.nextInt()));
					}
				}
			}
		}

	}

	private static int honeyCount1(int[][] honeyComb, int row, int col) {
		int total = 0;
		if(col%2==1)
		{
			if(row-1>=0)total+=honeyComb[row-1][col];
			if(col-1>=0)total+=honeyComb[row][col-1];
			if(row+1<honeyComb.length){
				total+=(honeyComb[row+1][col-1]+honeyComb[row+1][col]);
				if(col+1<honeyComb[0].length)
				{
					total+=(honeyComb[row+1][col+1]+honeyComb[row][col+1]);
				}
			}
			else if(col+1<honeyComb[0].length)total+=honeyComb[row][col+1];
		}
		else
		{
			if(row>0)
			{
				total+=honeyComb[row-1][col];
				if(col>0)total+=honeyComb[row-1][col-1]+honeyComb[row][col-1];
				if(col+1<honeyComb[0].length)total+=honeyComb[row-1][col+1];
			}
			else{
				if(col>0) total+=honeyComb[row][col-1];
			}
			if(row+1<honeyComb.length)total+=honeyComb[row+1][col];
			if(col+1<honeyComb[0].length)total+=honeyComb[row][col+1];
		}
		return total;
	}

	private static int honeyCount2(int[][] honeyComb, int row, int col) {
		int total = 0;
		if(col%2==1)
		{
			if(row-1>0)
			{
				total+=honeyComb[row-2][col];

			}
			if(row>0)
			{
				if(col-1>0)total+=honeyComb[row-1][col-2];
				if(col>0)total+=honeyComb[row-1][col-1];
				if(col+1<honeyComb[0].length)total+=honeyComb[row-1][col+1];
				if(col+2<honeyComb[0].length)total+=honeyComb[row-1][col+2];
			}
			if(col-1>0)total+=honeyComb[row][col-2];
			if(col+2<honeyComb[0].length)total+=honeyComb[row][col+2];
			if(row+1<honeyComb.length){
				if(col-1>0)total+=honeyComb[row+1][col-2];
				if(col+2<honeyComb[0].length)total+=honeyComb[row+1][col+2];
			}
			if(row+2<honeyComb.length)
			{
				total+=honeyComb[row+2][col];
				if(col>0)total+=honeyComb[row+2][col-1];
				if(col+1<honeyComb[0].length)total+=honeyComb[row+2][col+1];
			}
		}
		else
		{
			if(row-1>0)
			{
				if(col>0)total+=honeyComb[row-2][col-1];
				total+=honeyComb[row-2][col];
				if(col+1<honeyComb[0].length)total+=honeyComb[row-2][col+1];
			}
			if(col-1>0)
			{
				if(row>0)total+=honeyComb[row-1][col-2];
				total+=honeyComb[row][col-2];
				if(row+1<honeyComb.length)total+=honeyComb[row+1][col-2];
			}
			if(col+2<honeyComb[0].length)
			{
				if(row>0)total+=honeyComb[row-1][col+2];
				total+=honeyComb[row][col+2];
				if(row+1<honeyComb.length)total+=honeyComb[row+1][col+2];
			}
			if(row+2<honeyComb.length){
				total+=honeyComb[row+2][col];
			}
			if(row+1<honeyComb.length)
			{
				if(col>0)total+=honeyComb[row+1][col-1];
				if(col+1<honeyComb[0].length)total+=honeyComb[row+1][col+1];
			}

		}
		return total;
	}
	
}

