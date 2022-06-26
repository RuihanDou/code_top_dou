package codetopbytedance0051to0100.codetop0067;

import java.util.ArrayList;
import java.util.List;

public class LeetCode078Solution {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int i, int[]nums) {
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(i + 1, nums);
    }


}
