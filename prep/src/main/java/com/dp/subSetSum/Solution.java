package com.dp.subSetSum;

/* arr[]: 2 3 7 8 10
 * sum: 11
 * Find if the subset is present whose sum is 11 
 * o/p:T/F
 * Implement using matrix and return the last matrix
 */

public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 7, 8, 10 };
		int sum = 4;
		int n = arr.length;
//		boolean result = isSubsetPresentForSum(arr, n, sum);
		boolean result = isSubsetPresntForSumRcr(arr, n, sum);
		System.out.println("isSubsetPresentForSum: " + result);
	}

	private static boolean isSubsetPresntForSumRcr(int[] arr, int n, int sum) {
		if (sum > 0 && n == 0)
			return false;
		if (sum == 0) {
			return true;
		}
		// If last element is greater than
		// sum, then ignore it
		if (arr[n - 1] > sum)
			return isSubsetPresntForSumRcr(arr, n - 1, sum);

		return isSubsetPresntForSumRcr(arr, n - 1, sum) || isSubsetPresntForSumRcr(arr, n - 1, sum - arr[n - 1]);
	}

	private static boolean isSubsetPresentForSum(int[] arr, int n, int sum) {
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
						t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
					} else {
						t[i][j] = t[i - 1][j];
					}
				}

			}
		}

		return t[n][sum];
	}

}
