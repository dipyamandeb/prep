package com.prep.tiaa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Happy number
//19 is a happy number
public class Solution {

	private static Set<Integer> hs = new HashSet<>();

	public static void main(String[] args) {
		int testNumber = 42;
		System.out.println("Is Happy: " + isHappy(testNumber));

	}

	private static boolean isHappy(int testNumber) {
		if (testNumber == 0) {
			return false;
		}

		List<Integer> digitList = getDigits(testNumber);
		int newNumber = 0;
		// iterate over the list

		for (Integer digit : digitList) {
			newNumber = newNumber + (digit * digit);
		}

		if (newNumber == 1) {
			return true;
		}
		if (hs.contains(newNumber)) {
			return false;
		}

		else {
			hs.add(newNumber);
		}
		return isHappy(newNumber);
	}

	private static List<Integer> getDigits(int testNumber) {
		List<Integer> digitList = new ArrayList<>();

		while (testNumber != 0) {
			int digit = testNumber % 10;
			testNumber = testNumber / 10;
			digitList.add(digit);

		}
		return digitList;
	}

}
