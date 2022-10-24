package com.dp.knapsack;

import study.util.FillArray;

//Implementation of 0/1 knapsack

//Find the max profit;

public class Solution {
	// Initialize a matrix
	static int n = 20, w = 20;
	public static int t[][] = FillArray.initialize(n, w, -1);

	public static void main(String[] args) {
		int wt[] = { 1, 3, 4, 5 };
		int val[] = { 1, 4, 5, 7 };
		int w = 7;
		int n = wt.length;
//		int maxProfit = knapsack(wt, val, w, n);
//		int maxProfit = memoknapsack(wt, val, w, n);
		int maxProfit = topDownknapsack(wt, val, w, n);
		System.out.println("Max Profit = " + maxProfit);
	}

	private static int topDownknapsack(int[] wt, int[] val, int w, int n) {
		// initialisation condition
		for (int i = 0; i < n + 1; i++)
			t[i][0] = 0;
		for (int i = 0; i < w + 1; i++)
			t[0][i] = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < w + 1; j++) {
				if (wt[i - 1] <= j) {
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
					System.out.println("row:" + i + "column:" + j + "value:" + t[i][j]);
				} else {
					t[i][j] = t[i - 1][j];
					System.out.println("row:" + i + "column:" + j + "value:" + t[i][j]);
				}
			}
		}

		return t[n][w];
	}

	private static int memoknapsack(int[] wt, int[] val, int w, int n) {
		// base condition
		if (w == 0 || n == 0)
			return 0;
		if (t[n][w] != -1) {
			System.out.println("row:" + n + "column:" + w + "value:" + t[n][w]);
			return t[n][w];
		}

		if (wt[n - 1] <= w) {
			t[n][w] = Math.max(val[n - 1] + memoknapsack(wt, val, w - wt[n - 1], n - 1),
					memoknapsack(wt, val, w, n - 1));
			System.out.println("row:" + n + "column:" + w + "value:" + t[n][w]);
			return t[n][w];
		} else {
			t[n][w] = memoknapsack(wt, val, w, n - 1);
			System.out.println("row:" + n + "column:" + w + "value:" + t[n][w]);
			return t[n][w];
		}

	}

//Using base recursion
	private static int knapsack(int[] wt, int[] val, int w, int n) {
		// Base conditon
		if (w == 0 || n == 0) {
			return 0;
		}
		if (wt[n - 1] <= w) {
			return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
		} else {
			return knapsack(wt, val, w, n - 1);
		}

	}

}
