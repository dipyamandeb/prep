package com.recursion.delMidEle;

import java.util.Stack;

//Delete middle element of a stack
public class Solution {
	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		delMidElement(stack);
		System.out.println(stack);

	}

	private static void delMidElement(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int midIndex = stack.size() / 2 + 1;
		solve(stack, midIndex);

	}

	private static void solve(Stack<Integer> stack, int midIndex) {
		if (midIndex == 1) {
			stack.pop();
			return;
		}
		int val = stack.pop();
		solve(stack, midIndex - 1);
		stack.push(val);
		return;

	}
}
