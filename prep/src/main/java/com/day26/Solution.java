package com.day26;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int returnDay = sc.nextInt();
		int returnMonth = sc.nextInt();
		int returnYear = sc.nextInt();
		
		int dueDay = sc.nextInt();
		int dueMonth = sc.nextInt();
		int dueYear = sc.nextInt();
		System.out.println(calculateFineAmt(returnDay, returnMonth, returnYear, dueDay, dueMonth, dueYear));
		sc.close();
	}

	private static int calculateFineAmt(int returnDay, int returnMonth, int returnYear, int dueDay, int dueMonth,
			int dueYear) {
		if (returnYear<dueYear) {
			return 0;
		}
		if(returnYear - dueYear>0){
			return 10000;
		}
		
		if (returnMonth - dueMonth>0) {
			return (500 * (returnMonth - dueMonth));
		}
		if(returnDay -dueDay>0){
			return (15 * (returnDay -dueDay));
		}
		return 0;
	}
}
