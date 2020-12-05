package com.recursion.printN;

public class Solution {
	public static void main(String[] args) {
		int num = 5;
		print1toN(num);
	}

	private static void print1toN(int num) {
		// TODO Auto-generated method stub
			if(num==0) {
				System.out.println(0);
				return;
			}
			//Solution for printing from 1 to N
//			print1toN(num-1);
//			System.out.println(num);
			
			//Solution for printing from N to 1
			System.out.println(num);
			print1toN(num-1);
		
	}	
	
}
