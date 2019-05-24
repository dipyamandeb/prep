package com.day29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		List<Pair<Integer, Integer>> pairList = new ArrayList<Pair<Integer, Integer>>();
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			Pair<Integer, Integer> pair = new Pair<Integer, Integer>(n, k);
			pairList.add(pair);
		}
		callBitwise(pairList);

		scanner.close();
	}

	private static void callBitwise(List<Pair<Integer, Integer>> pairList) {
		pairList.forEach(p -> System.out.println(bitwiseMax(p.getKey(), p.getValue())));
	}

	private static int bitwiseMax(int range, int limit) {
		int maxNum = 0;

		for (int i = 1; i < range; i++) {
			for (int j = i+1; j <= range; j++) {
				int currNum = i & j;
				if (currNum > maxNum && currNum < limit) {
					maxNum = currNum;
				}
			}
		}
		return maxNum;
	}
}
