package codetopbytedance0051to0100.codetop0077;


/**
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 */
public class BackToOriginSolution {

    private int length = 10;

    /**
     * 动态规划
     * dp[n + 1][length]
     * dp[i][j] 为 从0点出发走 i 步 到达 j 点分的方案
     *
     * dp[0][0] = 1 从 0 点 用 0 步到达 0 点的方式只有一种
     *
     * dp[i][j] = dp[i-1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length]
     *
     * @param steps
     * @return
     */
    public int backToOrigin(int steps){
        int[][] dp = new int[steps + 1][length];
        dp[0][0] = 1;
        for(int i = 0; i<= steps; i++){
            for (int j = 0; j < length; j++){
                dp[i][j] = dp[i-1][(j - 1 + length) % length] + dp[i - 1][( j + 1) % length];
            }
        }
        return dp[steps][0];
    }

}
