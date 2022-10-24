package study.arrayDnf;

import java.util.Stack;

public class Solution {
	
	public static void main(String[] args) {

		 String str = "{{{}";
	       @SuppressWarnings("unchecked")
		Stack<Character> stack =new Stack<>();
	       
	       for(int i =0; i< str.length(); i++){
	          if(stack.isEmpty()) {
	        	  stack.push(str.charAt(i));
	          }
	    	   
	          else if((stack.peek())==str.charAt(i)){
	               stack.pop();
	           }
	           else{
	               stack.push(str.charAt(i));
	           }
	           
	       }
	       
	       if(!stack.isEmpty()){
	           System.out.println("Balanced");
	       }else{
	           System.out.println("Not Balanced");
	       }
	
	
	}

}
