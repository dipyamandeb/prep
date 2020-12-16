package com.recursion.rvrsStack;

import java.util.Stack;

//Reverse a stack
//Reverse method will give the reversed stack
//insert method will insert the element in stack
public class Solution {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		reverse(stack);
		System.out.println(stack);

	}

	private static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverse(stack);
		insert(stack, temp);
		return;
	}

	private static void insert(Stack<Integer> stack, int temp) {
		if (stack.isEmpty()) {
			stack.push(temp);
			return;
		}
		int val = stack.pop();
		insert(stack, temp);
		stack.push(val);
		return;

	}
}
