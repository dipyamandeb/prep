package com.bs.findEleInRotatedSortedArray;
/*
 * Find element in a rotated sorted array
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 3, 1};
		int numberOfRotation = findNumberOfRotOfSortedArray(arr);
		int ele = 3;
		int indexofElement = findTheIndexEle(arr, numberOfRotation, ele);
		System.out.println("indexofElement:" + indexofElement);
	}

	private static int findTheIndexEle(int[] arr, int numberOfRotation, int ele) {
		int indexFirstHalf = binarySearch(arr, ele, 0, numberOfRotation - 1);
		if (indexFirstHalf > 0) {
			return indexFirstHalf;
		}
		int indexlastHalf = binarySearch(arr, ele, numberOfRotation, arr.length - 1);
		if (indexlastHalf > 0) {
			return indexlastHalf;
		}
		return -1;
	}

	private static int binarySearch(int[] arr, int ele, int start, int end) {
		if (arr.length == 0) {
			return -1;
		}
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

	private static int findNumberOfRotOfSortedArray(int[] arr) {

		if (arr.length < 1) {
			return -1;
		}
		int length = arr.length - 1;
		int start = 0;
		int end = length;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			int next = (mid + 1) % length;
			int prev = (mid + length - 1) % length;
			if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
				return mid;
			}
			if (arr[start] < arr[mid]) {
				start = mid;

			} else if (arr[mid] <= arr[end]) {
				end = mid;
			}
		}
		return -1;
	}
}
