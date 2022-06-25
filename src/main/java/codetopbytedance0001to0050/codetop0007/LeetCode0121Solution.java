package codetopbytedance0001to0050.codetop0007;

public class LeetCode0121Solution {

    public int maxProfit(int prices[]) {
        // 设置最佳买入点的价格
        int minprice = Integer.MAX_VALUE;
        // 设置最大利润
        int maxprofit = 0;
        // 一次遍历，先尝试更新最佳买入点价格，代表本日买入，如果没有更新买入点价格，证明该日可以卖出(也可以不卖出)，则更新卖出获取最大利润
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
