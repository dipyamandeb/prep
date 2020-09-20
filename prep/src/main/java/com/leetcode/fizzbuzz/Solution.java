package com.leetcode.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int num = 15;
		List<String> words = fizzBuzz(num);
		
		for(String word: words) {
			System.out.println(word);
		}
		
	}
	
     public static List<String> fizzBuzz(int n) {
    	 List<String> words = new ArrayList<>();
    	 
    	 for (int i = 1; i <= n ; i++) {
			if (i%3 ==0 && i%5==0) {
				words.add("FizzBuzz");
			}
			else if(i%3==0) {
				words.add("Fizz");
			}
			else if(i%5==0) {
				words.add("Buzz");
			}
			else {
				words.add(Integer.toString(i));
			}
		}
    	 return words;
    }

}
