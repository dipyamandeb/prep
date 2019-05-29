package com.practice.dp;

public class SolutionMaxArraySumNonAdjacent {

	public static void main(String[] args) {
		int arr[] = { -2, 1, 3, -4, 5 };
		int maxSum = getMaxSum(arr);

		System.out.println("Max sum of non-adjacent array= " + maxSum);
	}

	private static int getMaxSum(int[] arr) {
		int incl = 0;
		int excl = 0;

		if (arr == null) {
			return 0;
		}

		for (int i = 0; i < arr.length; i++) {

			int temp = incl;
			incl = Math.max(incl, excl + arr[i]);
			excl = temp;
		}
		return incl;
	}

}
