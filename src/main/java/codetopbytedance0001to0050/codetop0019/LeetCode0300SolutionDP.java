package codetopbytedance0001to0050.codetop0019;

public class LeetCode0300SolutionDP {

    /**
     * 动态规划 dp[i] 为以第 i 个数字结尾的最长上升子序列长度 nums[i] 必须在子序列中
     *
     * 0 <= j < i 且 nums[j] < nums[i] 的 所有 dp[j]中的最大的 +1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

}
