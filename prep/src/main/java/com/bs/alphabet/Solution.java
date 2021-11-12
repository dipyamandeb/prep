package com.bs.alphabet;

/*  Ciel implementation
 *  Ceil is the smallest element which is greater than the target
 */
public class Solution {
	public static void main(String[] args) {
		char letters[] = { 'A', 'r', 'z' };
		char target = 'z';
		char result = nextGreatestAlphabet(letters, target);

		// Function call
		System.out.println("Next Alphabet is:" + result);
	}
//test1
	private static char nextGreatestAlphabet(char[] arr, char ele) {
		if (arr.length == 0) {
			return '#';
		}
		int start = 0;
		int end = arr.length - 1;
		int length = arr.length;
		int mid = 0;
		char res = '#';
		while (start <= end) {
			mid = (start + end) / 2;
			if (ele == arr[mid]) {
				res = arr[(mid + 1) % length];
				return res;
			} else if (ele < arr[mid]) {
				res = arr[mid];
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return res;
	}

}
