package com.leetcode.reversestring;

public class Solution {
public static void main(String[] args) {
	char[] s =  {'h','e','l','l','o'};
	reverseString(s);
}

public static void reverseString(char[] s) {
	int i = s.length-1;
	int j=0;
	while(j<=i ) {
		char up = s[i];
		s[i] = s[j];
		s[j]= up;
		i--;
		j++;
	}
}
}
