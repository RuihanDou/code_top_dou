package codetopbytedance0051to0100.codetop0082;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0139Solution {

    /**
     * dp[i] 表示字符串s  前i个字符组成的字符串 s[0 .. i - 1]能否被空格拆分成若干个字典中出现的单词
     *
     * 转移方程为 dp[i] = dp[j] && check(s[j .. i-1])
     * 其中 check(s[j .. i - 1]) 表示子串 s[j .. i - 1] 是否出现在字典中
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        // 空字符串合法
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


}
