package codetopbytedance0051to0100.codetop0055;

import java.util.Arrays;

public class LeetCode0322Solution {

    /**
     *  动态规划
     *
     *  dp[i] 为组成金额i所需要的最少硬币数量
     *
     *  dp[i] = min(dp[i - cj]) + 1
     *  其中 j = 0 ... (n - 1)
     *  cj为 第j个硬币的价值（面额）
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                // 修建搜索范围，当钱币金额coins[j]小于要凑齐的金额i,才有更新的必要
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
