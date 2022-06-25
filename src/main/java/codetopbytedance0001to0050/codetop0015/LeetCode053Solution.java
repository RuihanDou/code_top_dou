package codetopbytedance0001to0050.codetop0015;

public class LeetCode053Solution {

    public int maxSubArray(int[] nums) {
        int preSum = 0, maxSum = nums[0];
        for(int x : nums){
            preSum = Math.max(x, preSum + x);
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

}
