package codetopbytedance0051to0100.codetop0073;

import java.util.List;

public class LeetCode064Solution {

    // 使用动态规划
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        //定义 dp[i][j] 为 grid[i][j] 到达 grid[m][n] 的最短路径
        int[] dp = new int[n];
        // dp[i][j] = grid[i][j] + min(dp[i+1][j], dp[i][j+1])
        // 由于dp 第i行 只依赖于最多 第i+1行 和 本行的数值，所以只保留一行
        // 初始化，先获取 第 m - 1 行的 dp
        int cur = 0;
        for(int j = n - 1; j >= 0; j--){
            cur += grid[m-1][j];
            dp[j] = cur;
        }
        // 从 m - 2 行 开始 到 第 0 行， 按行更新dp
        for(int i = m - 2; i >= 0; i--){
            // 先获取 该行 的最后一列的数值
            dp[n - 1] = dp[n - 1] + grid[i][n-1];
            for(int j = n - 2; j >= 0; j--){
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];

    }


}
