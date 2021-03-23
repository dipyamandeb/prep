package com.bs.simpleSearch;
/**
 * 
 * @author dipyaman
 *	Binary search implementation 
 *  complexity logn2
 *  23/03/21
 *  
 */

public class Solutions {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };
		int ele = 4;
		int index = binarySearch(arr, ele);
		System.out.println("Element present at:" + index);
	}

	private static int binarySearch(int[] arr, int ele) {
		if (arr.length == 0) {
			return -1;
		}

		int start = 0;
		int end = arr.length - 1;

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
