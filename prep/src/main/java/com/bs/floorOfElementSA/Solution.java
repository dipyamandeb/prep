package com.bs.floorOfElementSA;

/*
 * Find floor of an element in a sorted array
 * Floor is the greatest element which is smaller then the target
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 8, 20, 20, 23, 29 };
		int ele = 30;
		int floorNumber = findFloorInSortedArray(arr, ele);
		System.out.println("Index of Ele:" + floorNumber);
	}

	private static int findFloorInSortedArray(int[] arr, int ele) {
		if (arr.length == 0) {
			return -1;
		}
		int res = 0;
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (ele == arr[mid]) {
				return arr[mid];
			} else if (ele > arr[mid]) {
				res = mid;
				start = mid + 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			}
		}
		return arr[res];
	}
}
