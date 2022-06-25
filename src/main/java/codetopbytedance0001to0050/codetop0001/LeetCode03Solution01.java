package codetopbytedance0001to0050.codetop0001;

import java.util.HashSet;
import java.util.Set;

public class LeetCode03Solution01 {

    /**
     * 使用滑动窗口解决
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        // 记录窗口中出现的字符
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 初始化窗口的右边界，结果暂存量
        int r = - 1, ans = 0;
        // 查看s[l, r]子串
        for(int l = 0; l < n; l++){
            // 因为循环伊始，左指针就向右移动一格，移除的字符对应从出现的字符中移除
            if(l != 0){
                occ.remove(s.charAt(l-1));
            }
            // 右移 右边界 因为右移向右多看一格，所以 l < n - 1，向右移动得保证子串中没有重复字符
            while (r < n - 1 && !occ.contains(s.charAt(r + 1))){
                occ.add(s.charAt(r + 1));
                r++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }



}
