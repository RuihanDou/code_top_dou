package codetopbytedance0001to0050.codetop0001;


import java.util.HashMap;
import java.util.Map;

public class LeetCode03Solution02 {

    /**
     * 该方案速度更快
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // ans记录答案，n为字符串s的长度
        int ans = 0, n = s.length();
        // 使用 map 记录 某字符 和 其出现的最后位置
        Map<Character, Integer> map = new HashMap<>();
        // 左边界定位开始0
        int l = 0;
        // 循环看最长子串的有边界
        for(int r = 0; r < n; r++){
            // 新遍历到的右边界出现了重复字符
            if(map.containsKey(s.charAt(r))){
                // l 位置就移动到 与 r 重复字符的后一个 位置，如果 l 本身就在 r重复字符后一个位置的后面，那么l不懂
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            ans = Math.max(r - l + 1, ans);
            map.put(s.charAt(r), r);
        }
        return ans;
    }


}
