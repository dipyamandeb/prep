package com.dp.minSubsetSumDiff;

/*
 * Minimum subset sum difference 
 * 25/01/21
 * arr[]:1 6 11 5
 * op:1
 * 
 * Find the minimum diff for the sum of subsets
 * 
 * 
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 1,6,11,5 };
		int n = arr.length;
		int sum = arraySum(arr);
		System.out.println("minDiffSubsetSum : " + minDiffSubsetSum(arr, n, sum));
	}

	private static int arraySum(int[] arr) {
		if (arr.length == 0)
			return 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	private static int minDiffSubsetSum(int[] arr, int n, int sum) {
		boolean t[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					t[i][j] = false;
				}
				if (j == 0) {
					t[i][j] = true;
				}
				if (i != 0 && j != 0) {
					if (arr[i - 1] <= j) {
						t[i][j] = t[i - 1][j - arr[i - 1]] | t[i - 1][j];
					} else {
						t[i][j] = t[i - 1][j];
					}
				}

			}
		}

		int minans = Integer.MAX_VALUE;

		// finding the minimum difference
		for (int i = 0; i < (sum + 1) / 2; i++)
			if (t[n][i] == true) {
				minans = Math.min(minans, sum - (2 * i));
			}
		return minans;
	}
}
