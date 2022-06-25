package codetopbytedance0001to0050.codetop0047;

public class LeetCode076Solution {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen == 0 || tLen == 0 || sLen < tLen){
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // 使用字符频数数组记录
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        for (char c : charArrayT){
            tFreq[c]++;
        }

        // 滑动窗口中需要的变量，滑动窗口中包含多少t中的字符，对应的频数超过了不重复计算
        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;
        // [left, right) right 左边的字符都是看过的且 长度为 right - left
        int left = 0;
        int right = 0;

        while (right < sLen){
            // 如果有边界上的字符不在t中出现，有边界右移
            if(tFreq[charArrayS[right]] == 0){
                right++;
                continue;
            }
            // 此时 charArrayS[right] 的字符一定在 t 中出现， 统计该字符对应的频率并且右移一位，看下一个字符, 维护distance 和 winFreq
            if(winFreq[charArrayS[right]] < tFreq[charArrayS[right]]){
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while (distance == tLen){

                if(right - left < minLen){
                    minLen = right - left;
                    begin = left;
                }

                if(tFreq[charArrayS[left]] == 0){
                    left++;
                    continue;
                }

                if(winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    distance--;
                }

                winFreq[charArrayS[left]]--;
                left++;

            }


        }
        if(minLen == sLen + 1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }


}
