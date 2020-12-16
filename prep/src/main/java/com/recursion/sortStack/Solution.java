package com.recursion.sortStack;

import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(4);
		stack.push(1);
		stack.push(5);
		stack.push(7);

		sort(stack);
		System.out.println(stack);
	}

	private static void sort(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}
		int temp = stack.pop();
		sort(stack);
		insert(stack, temp);
	}

	private static void insert(Stack<Integer> stack, int temp) {
		if (stack.isEmpty() || stack.peek() <= temp) {
			stack.push(temp);
			return;

		}

		int val = stack.pop();
		insert(stack, temp);
		stack.push(val);
		return;

	}
}
