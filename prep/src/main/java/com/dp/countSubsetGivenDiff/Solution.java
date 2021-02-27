package com.dp.countSubsetGivenDiff;
/*/*
 * Target Sum 25/02/2021
 * arr: 1 1 2 3 
 * sum:1
 * O/P:3
 * 
 * Here we have to find the count of subset where sum :1  
 * by putting +/- be before each element in array.
 * Different combination of +/-
 * 
 *
 *Note the Target sum is similar to that of  Count the subset with a given diff 
 * 
 * 
 * Count the subset with a given diff 
 * 24/02/2021
 * arr[]:1 1 2 3
 * Diff:1
 * O/P:3
 * s1+s2 = diff-------1
 * s1+s2 = sum(arr)---2
 * 1+2
 * -----------------------------------
 * 2s1 = diff+sum(arr)
 * s1 = diff+sum(arr)/2
 * 
 */

public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 1, 1, 1, 1 };
		int n = arr.length;
		int diff = 3;
		int sum = arraySum(arr);
		System.out.println("countSubsetGivenDiff : " + countSubsetGivenDiff(arr, n, sum, diff));
	}

	private static int countSubsetGivenDiff(int[] arr, int n, int sum, int diff) {
		// Implementing the above equation , find s1
		int s1 = findS1(sum, diff);
		return countOfSubsetSum(arr, n, s1);
	}

	private static int countOfSubsetSum(int[] arr, int n, int sum) {

		int t[][] = new int[n + 1][sum + 1];
		for (int i = 0; i < n + 1; i++) {
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

	private static int findS1(int sum, int diff) {
		return (diff + sum) / 2;
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
