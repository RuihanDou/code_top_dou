package codetopbytedance0051to0100.codetop0059;

public class LeetCode0122Solution {

    // 贪心，不考虑过程
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for(int i = 1; i < n; i++){
            ans += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }

}
