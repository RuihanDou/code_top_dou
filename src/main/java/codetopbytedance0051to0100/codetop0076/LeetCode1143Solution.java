package codetopbytedance0051to0100.codetop0076;

public class LeetCode1143Solution {

    /**
     * 动态规划
     * 设 text1 和 text2 的字符串长度为 m， n
     * 设 dp[m+1][n+1] 中 dp[i][j] 表示 text1[0:i] text2[0:j]的最长公共子序列长度
     *
     * 当 i = 0 时，text1[0:i]为空，空字符串与任何字符串的最长子序列长度都是0 dp[0][j] = 0 同理dp[i][0] = 0
     * 当 i > 0, j > 0
     *
     *  当 text1[i - 1] == text[j - 1] dp[i][j] = dp[i-1][j-1] + 1
     *  当 text1[i - 1] != text[j - 1] dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
