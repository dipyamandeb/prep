package com.bs.infiniteSortedArray;

/*
 * Find the element in the infinite sorted array
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 5, 10, 30, 20, 40, 50, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190,
				200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340, 350, 360 };
		int ele = 40;
		int index = findEleInfiniteSortedArray(arr, ele);
		System.out.println("Index of Ele:" + index);
	}

	private static int findEleInfiniteSortedArray(int[] arr, int ele) {
		// Find the end in Infinite sorted array is the 1st sub problem,
		// then, implement binary search

		// Basic validation
		if (arr.length < 2) {
			System.out.println("Array is not infinite");
			return -1;
		}

		// Problem logic implementation

		int low = 0;
		int high = 1;

		while (ele > arr[high]) {
			low = high;
			high = 2 * high;
		}
		// implement simple binary search on the arr between low and high
		return binarySearch(arr, low, high, ele);
	}

	private static int binarySearch(int[] arr, int low, int high, int ele) {
		if (arr.length == 0) {
			return -1;
		}

		int start = low;
		int end = high;

		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (ele == arr[mid]) {
				return mid;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

}
