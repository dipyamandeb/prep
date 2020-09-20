package com.leetcode.palindrome;

public class Solution {

	public static void main(String[] args) {
		int num = 12;
		System.out.println(isPalindrome(num));
	}

	public static boolean isPalindrome(int num) {
		if (num < 0)
			return false;
		int reversed = 0;
		int originalNum = num;
		while (num != 0) {
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num = num / 10;
		}
		return originalNum == reversed ? true : false;
	}

}
