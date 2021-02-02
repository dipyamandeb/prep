package com.recursion.kthSymbol;

public class Solution {

	public static void main(String[] args) {
		int N = 2;
		int K = 2;

		System.out.println(kthGrammar(N, K));

	}

	public static int kthGrammar(int N, int K) {
		if (N == 1 && K == 1)
			return 0;

		int mid = (int) (Math.pow(2, N - 1) / 2);

		if (K <= mid) {
			return kthGrammar(N - 1, K);

		} else {
			return 1 - kthGrammar(N - 1, K - mid);
		}

	}

}
