package com.bs.firstinfBinSortedArray;

/*
 * FIND THE INDEX OF THE 1ST "1" IN A INFINITE BINARY SORTED ARRAY.
 * This problem is a combination of :
 * Infinite sorted array.
 * &&
 * 1st occurance of an element
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		int ele = 1;
		int index = findEle(arr, ele);
		System.out.println("Index of Ele:" + index);
	}

	private static int findEle(int[] arr, int ele) {
		// validation
		if (arr.length < 2) {
			System.out.println("array is not infinite");
			return -1;
		}

		// finding the range from infinite sorted array
		// i.e. high and lows
		int low = 0;
		int high = 1;
		while (ele > arr[high]) {
			low = high;
			high = 2 * high;
		}

		// find the 1st occurance after finding the low and high
		return findFirstOccurence(arr, low, high, ele);
	}

	private static int findFirstOccurence(int[] arr, int low, int high, int ele) {
		if (arr.length == 0) {
			return -1;
		}

		int start = 0;
		int end = arr.length - 1;
		int res = 00;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (ele == arr[mid]) {
				res = mid;
				end = mid - 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

}
