package codetopbytedance0051to0100.codetop0085;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0128Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int longestStreak = 0;
        for(int num : numSet){
            if(!numSet.contains(num - 1)){
                int curNum = num;
                int curStreak = 1;

                while (numSet.contains(curNum + 1)){
                    curNum += 1;
                    curStreak += 1;
                }

                longestStreak = Math.max(longestStreak, curStreak);
            }
        }
        return longestStreak;
    }


}
