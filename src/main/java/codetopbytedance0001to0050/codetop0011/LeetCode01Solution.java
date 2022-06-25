package codetopbytedance0001to0050.codetop0011;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode01Solution {

    public int[] twoSum(int[] nums, int target) {

        // map 的key 是 target - nums[i], value 是 i
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num) && map.get(num) != i){
                return new int[] {map.get(num), i};
            }
            map.put(target - num, i);
        }
        throw new RuntimeException("no result.");
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;

        LeetCode01Solution solution = new LeetCode01Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

}
