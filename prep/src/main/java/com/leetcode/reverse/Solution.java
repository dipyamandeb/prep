package com.leetcode.reverse;
//Given a 32-bit signed integer, reverse digits of an integer.

public class Solution {
public static void main(String[] args) {
	int num = 1534236469;
	System.out.println(reverse(num));
	
}

public static int reverse(int x) {

	long reversed = 0;
	while (x!=0) {
		int digit = x%10;
		reversed = reversed*10+digit;
		if(reversed>Integer.MAX_VALUE || reversed<Integer.MIN_VALUE) return 0;
		x=x/10;
	}
	
	return (int)reversed;
}

}
