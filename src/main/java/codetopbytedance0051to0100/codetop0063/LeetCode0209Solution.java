package codetopbytedance0051to0100.codetop0063;

public class LeetCode0209Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int sum = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while (sum >= target){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return  ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
