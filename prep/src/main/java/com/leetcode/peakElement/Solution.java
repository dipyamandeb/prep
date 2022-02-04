package com.leetcode.peakElement;

class Solution {
	public int findPeakElement(int[] nums) {
		// base condn.
		if (nums.length < 2)
			return 0;
		// peak element is an elements which is strictly greater than its neighbour

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			// mid will be creating the corner cases when mid= 0 or mid is last element

			if (mid > 0 && mid < nums.length - 1) {
				if (((nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])))
					return mid;
				else if (nums[mid] < nums[mid + 1]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			// 1st element
			else if (mid == 0) {
				if (nums[0] > nums[1]) {
					return 0;
				} else {
					return 1;
				}
			} else if (mid == nums.length - 1) {
				if (nums[nums.length - 1] > nums[nums.length - 2]) {
					return nums.length - 1;
				} else {
					return nums.length - 2;
				}
			}

		}
		return -1;
	}
}