package codetopbytedance0001to0050.codetop0035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode056Solution {

    public int[][] merge(int[][] intervals) {

        // 考虑为空的情况
        if(intervals.length == 0){
            return new int[0][2];
        }

        // 以左区间大小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            // 如果 结果集里为空，或者，结果集里的最右界 在目前区间的左界之前，证明要开启新的一段区间
            if(merged.size() < 1 || merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            }
            // 当前区间可以附着到结果集的最右区间上
            else {
                merged.get(merged.size() - 1)[1] = Math.max(R, merged.get(merged.size() - 1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
