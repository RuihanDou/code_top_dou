package codetopbytedance0001to0050.codetop0041;

public class LeetCode072Solution {

    // 动态规划 -- 自底向上

    /**
     *  word1[0~i] 变成 word2[0~j] 需要的编辑距离 记录到dp[i][j];
     *
     *  如果 word[i] == word[j], dp[i][j] = dp[i-1][j-1]
     *  否者， dp[i][j] = 1 + min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][ j - 1])
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        int len1 = word1.length(), len2 = word2.length();

        // 讨论边界情况，如果有字符串为空
        if(len1 * len2 == 0){
            return len1 + len2;
        }

        // 定义动态规划数组
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++){
            dp[0][j] = j;
        }

        // 进行状态更新
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                int left = dp[i - 1][j];
                int down = dp[i][j - 1];
                int leftDown = dp[i - 1][j - 1];

                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(left, down), leftDown) + 1;
                }
            }
        }

        return dp[len1][len2];

    }



}
