package com.prep.jsw;

import java.util.Stack;

// find if the balanced paranthesis
public class Solution {

	public static void main(String[] args) {
		String str = "{}";
		System.out.println(isValid(str));
	}

	 public static boolean isValid(String s) {
	        Stack<Character> stack = new Stack();
	        String openBrackets = "{([";
	        String closeBrackets = "})]";
	        
	        for(int i=0;i<s.length();i++){
	        if(stack.isEmpty()){
	            stack.push(s.charAt(i));
	        }
	            else if((stack.peek()==openBrackets.charAt(0) && s.charAt(i) ==closeBrackets.charAt(0))
	                    || (stack.peek()==openBrackets.charAt(1) && s.charAt(i) ==closeBrackets.charAt(1))
	                    || (stack.peek()==openBrackets.charAt(2) && s.charAt(i) ==closeBrackets.charAt(2))){
	                stack.pop();
	            }
	            else{
	                stack.push(s.charAt(i));
	            }
	        
	    }
	      return stack.isEmpty();  
	    }

}
