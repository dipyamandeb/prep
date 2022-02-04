package com.leetcode.peakElement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
//		fail("Not yet implemented");
		int nums[] = {3,2,1};
		int expected = 0;
		Solution solution = new Solution();
		int actual = solution.findPeakElement(nums);
		assertEquals(expected, actual);
	}

}
