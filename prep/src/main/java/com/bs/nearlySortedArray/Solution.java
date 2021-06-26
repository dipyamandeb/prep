package com.bs.nearlySortedArray;
/*
 * Searching in a nearly sorted array
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 5, 10, 30, 20, 40 };
		int ele = 40;
		int index = findEleInNearlySortedArray(arr, ele);
		System.out.println("Index of Ele:" + index);
	}

	private static int findEleInNearlySortedArray(int[] arr, int ele) {
		if (arr.length == 0) {
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (ele == arr[mid]) {
				return mid;
			}
			if (arr[mid - 1] > start && ele == arr[mid - 1]) {
				return mid - 1;
			}
			if (arr[mid + 1] < end && ele == arr[mid + 1]) {
				return mid + 1;
			} else if (ele < arr[mid + 1]) {
				end = mid - 2;
			} else if (ele > arr[mid - 1]) {
				start = mid + 2;
			}

		}
		return -1;
	}
}
