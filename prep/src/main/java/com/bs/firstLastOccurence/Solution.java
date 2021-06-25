package com.bs.firstLastOccurence;

public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 2, 4, 10, 10, 10, 18, 20 };
		int ele = 10;
		int firstEle = findFirstOccurence(arr, ele);
		int lastEle = findLastOccurence(arr, ele);
		System.out.println("First Occurence:" + firstEle);
		System.out.println("Last Occurence:" + lastEle);
	}

	private static int findLastOccurence(int[] arr, int ele) {
		if (arr.length == 0) {
			return -1;
		}

		int start = 0;
		int end = arr.length - 1;
		int res=00;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (ele == arr[mid]) {
				res = mid;
				start = mid + 1;
			} else if (ele < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	private static int findFirstOccurence(int[] arr, int ele) {
		if (arr.length == 0) {
			return -1;
		}

		int start = 0;
		int end = arr.length - 1;
		int res=00;
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
