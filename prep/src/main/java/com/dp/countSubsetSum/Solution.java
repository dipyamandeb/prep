package com.dp.countSubsetSum;

/*
 * Count of subsets sum with given sum.
 * arr[]: 2 3 5 6 8 10
 * sum:10
 * 
 */
public class Solution {

	public static void main(String[] args) {
		int arr[] = new int[] { 2, 3, 5, 8, 10 };
		int n = arr.length;
		int sum = 10;
		System.out.println("countOfSubsetSum : " + countOfSubsetSum(arr, n, sum));
	}

	private static int countOfSubsetSum(int[] arr, int n, int sum) {

		int t[][] = new int[n+1][sum + 1];
		for (int i = 0; i < n+1 ; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}
				if (j == 0) {
					t[i][j] = 1;
				}
				if (i != 0 && j != 0) {
					if (arr[i - 1] <= j) {
						t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
					} else {
						t[i][j] = t[i - 1][j];
					}
				}

			}
		}

		return t[n][sum];

	}

}
