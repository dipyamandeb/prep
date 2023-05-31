/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap();
        for(int i = 0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                int[] res = new int[2];
                res[0]=hm.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            hm.put(nums[i],i);
            
        }   
           
           return null;  
    }
}
// @lc code=end

