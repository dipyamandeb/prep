/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            // if digit is <9
            if (digits[i] < 9) {
                digits[i]++;
                System.out.println(digits[i]);
                return digits;
            }
            // if digit is 9, make that digit as 0;
            digits[i] = 0;
        }
        // if the digit[0] is 9 then we have to increase the size of the array by +1,
        // setting the digit[0] to 1 for new array.
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
// @lc code=end
