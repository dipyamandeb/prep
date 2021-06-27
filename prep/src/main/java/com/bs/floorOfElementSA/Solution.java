package com.bs.floorOfElementSA;

/*
 * Find floor & Ceil of an element in a sorted array
 * Floor is the greatest element which is smaller then the target
 * Ceil is the smallest element which is greater than the target
 */
public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 8, 20, 20, 23, 29 };
		int ele = 24;
		int floorNumber = findFloorInSortedArray(arr, ele);
		System.out.println("Floor:" + floorNumber);
		int ceilNumber = findCeilNumber(arr,ele);
		System.out.println("Ceil:"+ceilNumber);
		
	}

	private static int findCeilNumber(int[] arr, int ele) {
		if (arr.length==0) {
			return -1;
		}
		
		int res =0 ;
		int mid = 0;
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			mid = (start+end)/2;
			if (ele ==arr[mid]) {
				return arr[mid];
			}
			else if (ele>arr[mid]) {
				start = mid+1;
			}else if(ele<arr[mid]){
				res = mid;
				end = mid -1;
			}
			
		}
		return arr[res];
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
