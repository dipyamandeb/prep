package com.bs.minDiffEle;

/*
 * Minimum diff element in a sorted array
 * Element to be found which when absolute subtracted from the key gives the minimum diff
 * -If the key is already present then then min diff. will be 0
 * -If key is not present then the min diff will be min of key minus nearest neighbours 
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 4, 6, 10 };
		int ele = 6;
		int minEle = findEle(arr, ele);
		System.out.println("Index of Ele:" + minEle);
	}

	private static int findEle(int[] arr, int ele) {
		// Validate array
		if (arr.length == 0) {
			System.out.println("Empty array");
			return -1;
		}
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (ele == arr[mid]) {
				// if the key is present than that will give the minimum diff i.e. 0 on
				// substarction
				return arr[mid];
			} else if (ele < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		// after the while loop is over the start and end will be the nearest
		// neighbours, so absolute of substartction from one of them will give minium.
		return Math.abs(arr[start] - ele) < Math.abs(arr[end] - ele) ? arr[start] : arr[end];
	}
}
