package com.leetcode.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    
//	public static int[] twoSum(int[] nums, int target) {
//
//		int[] output = new int[2];
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] + nums[j] == target) {
//					output[0] = i;
//					output[1] = j;
//					break;
//				}
//
//			}
//
//		}
//
//		return output;
//	}
	
	public static int[] twoSum(int[] nums, int target) {
		
		HashMap< Integer, Integer> hm = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			int compliment = target- nums[i];
			if (hm.containsKey(compliment)) {
				return new int[] {i,hm.get(compliment)};
			}
			hm.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum value.");
		
		
	}
//	public static int[] twoSum(int[] nums, int target) {
//	    Map<Integer, Integer> map = new HashMap<>();
//	    for (int i = 0; i < nums.length; i++) {
//	        int complement = target - nums[i];
//	        if (map.containsKey(complement)) {
//	            return new int[] { map.get(complement), i };
//	        }
//	        map.put(nums[i], i);
//	    }
//	    throw new IllegalArgumentException("No two sum solution");
//	}
	
	public static void main(String[] args) throws Exception{
		int[] num = new int[] { 2, 7, 11, 15 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum(num, target)));

	}
}
