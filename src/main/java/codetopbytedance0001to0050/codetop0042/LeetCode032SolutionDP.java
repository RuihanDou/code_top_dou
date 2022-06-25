package codetopbytedance0001to0050.codetop0042;

public class LeetCode032SolutionDP {

    /**
     * 动态规划
     *
     * 定义 dp[i] 是 以下标 i 字符结尾的最长有效括号序列长度
     *
     * 如果 s[i] = ')' , s[i - 1] = '(' 那么形如 “...()” 的有效序列
     *      此时，dp[i] = dp[i - 2] + 2
     *
     * 如果 s[i] = ')' , s[i - 1] = ')' 那么形如 “...))” 的有效序列 如果 这个时候有 s[i - dp[i - 1] - 1] = '('
     *      此时，dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2
     *
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                // 两种状态递推公式
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0)) + 2;
                }
                maxAns = Math.max(dp[i], maxAns);
            }
        }
        return maxAns;
    }

}
