package com.bs.noOfRotation;
/*
 * The number of rotation will be the  position(index) of the minimum value.
 * Minimum value will lie in the unsorted part  
 */
public class Solution {
public static void main(String[] args) {
		int arr[] = new int[] { 11, 12, 15, 18, 20, 22, 2, 6, 8 };
	int numberOfRotation = findNumberOfRotOfSortedArray(arr);
	System.out.println("Number of rotation:"+numberOfRotation);
}

	private static int findNumberOfRotOfSortedArray(int[] arr) {

		if (arr.length == 0) {
			return -1;
		}
		int length = arr.length-1;
		int start = 0;
		int end = length;
		int mid = 0;
		while (start <= end) {
 			mid = (start + end) / 2;
			int next = (mid+1)%length;
			int prev= (mid+length-1)%length;
			if (arr[prev]>arr[mid] && arr[mid]<arr[next]) {
				return mid;
			}
			if (arr[start] < arr[mid]) {
				start = mid ;

			} else if (arr[mid] <= arr[end]) {
				end = mid;
			}
		}
		return -1;
	}
}
