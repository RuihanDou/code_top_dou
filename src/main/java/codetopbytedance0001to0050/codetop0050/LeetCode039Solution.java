package codetopbytedance0001to0050.codetop0050;

import java.util.ArrayList;
import java.util.List;

public class LeetCode039Solution {

    /**
     * 使用递归的方式
     *
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> rst = new ArrayList<>();
        recursive(candidates, cur, rst, 0, target);
        return rst;
    }

    private void recursive(int[] candidates, List<Integer> cur, List<List<Integer>> rst, int pos, int target) {

        if(pos >= candidates.length){
            return;
        }

        if(target == 0){
            rst.add(new ArrayList<>(cur));
            return;
        }

        // 添加本元素
        if(target - candidates[pos] >= 0){
            cur.add(candidates[pos]);
            recursive(candidates, cur, rst, pos, target - candidates[pos]);
            cur.remove(cur.size() - 1);
        }

        // 不添加本元素
        recursive(candidates, cur, rst, pos + 1, target);

    }

}
