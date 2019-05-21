package com.day25;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			isPrime(ele);
		}
		sc.close();
	}

	private static void isPrime(int ele) {
		boolean isPrime = ele == 1 ? false : true;

		for (int i = 2; i <= Math.sqrt(ele); i++) {
			if (ele % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime == true) {
			System.out.println("Prime");
		} else {
			System.out.println("Not prime");
		}

	}

}
