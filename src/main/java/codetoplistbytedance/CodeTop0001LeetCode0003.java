package codetoplistbytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class CodeTop0001LeetCode0003 {

//    public int lengthOfLongestSubstring(String s) {
//
//        // 使用滑动窗口 Set中存储 窗口中的不同字符
//        Set<Character> set = new HashSet<>();
//        // 定义窗口有边界 和 最长子串长度
//        int r = -1, length = 0, sLength = s.length();
//        // 窗口左边界遍历
//        for(int l = 0; l < sLength; l++){
//            if(l != 0){
//                set.remove(s.charAt(l - 1));
//            }
//            while (r + 1 < sLength && !set.contains(s.charAt(r + 1))){
//                set.add(s.charAt(r + 1));
//                r++;
//            }
//            length = Math.max(set.size(), length);
//        }
//
//        return length;
//    }

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


    public static void main(String[] args) {
        String s = "pwwkew";
        CodeTop0001LeetCode0003 solution = new CodeTop0001LeetCode0003();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

}
