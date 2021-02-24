package com.dp.equalSumPartition;

/*
 * is  equal sum partition for a given array T/F
 * 
 */
public class Solution {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 5, 4, 11 };
		int n = arr.length;
		System.out.println("isEqualSumPartition : " + isEqualSumPartition(arr, n));
		System.out.println("isEqualSumPartitionDp : " + isEqualSumPartitionDP(arr, n));
	}

	private static boolean isEqualSumPartitionDP(int[] arr, int n) {
		int sum = arraySum(arr);
		if (n == 0 || sum % 2 != 0) {
			return false;
		}

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

	private static boolean isEqualSumPartition(int[] arr, int n) {
		int sum = arraySum(arr);
		if (n == 0 || sum % 2 != 0) {
			return false;
		}
		return isSumPartition(arr, n, sum / 2);

	}

	private static boolean isSumPartition(int[] arr, int n, int sum) {
		if (n == 0 && sum != 0) {
			return false;
		}
		if (sum == 0) {
			return true;
		}

		if (arr[n - 1] > sum)
			return isSumPartition(arr, n - 1, sum);

		return isSumPartition(arr, n - 1, sum - arr[n - 1]);
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

}
