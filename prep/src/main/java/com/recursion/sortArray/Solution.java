package com.recursion.sortArray;

import java.util.ArrayList;
import java.util.Arrays;

/*Sort an Array.*/
public class Solution {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 2, 8, 4, 3));
		sort(arrayList);
		System.out.println(arrayList);
	}

	private static void sort(ArrayList<Integer> arrayList) {
		if (arrayList.size() == 1) {
			return;
		}
		// fetch the last element of array list
		int temp = arrayList.get(arrayList.size() - 1);
		// remove the fetched element
		arrayList.remove(arrayList.size() - 1);
		sort(arrayList);
		insert(arrayList, temp);

	}

	private static void insert(ArrayList<Integer> arrayList, int temp) {

		if (arrayList.size() == 0 || arrayList.get(arrayList.size() - 1) <= temp) {
			arrayList.add(temp);
			return;
		}
		int val = arrayList.get(arrayList.size() - 1);
		arrayList.remove(arrayList.size() - 1);
		insert(arrayList, temp);
		arrayList.add(val);
		return;
	}

}
