package codetopbytedance0001to0050.codetop0049;

public class LeetCode0162Solution {

    // 二分查找法
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (compare(nums, mid - 1, mid) < 0 && compare(nums, mid, mid + 1) > 0) {
                ans = mid;
                break;
            }
            if (compare(nums, mid, mid + 1) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int compare(int[] nums, int idx1, int idx2){
        if(idx1 < 0){
            return -1;
        }
        if(idx2 >= nums.length){
            return 1;
        }
        if(nums[idx1] == nums[idx2]){
            return 0;
        }
        return nums[idx1] > nums[idx2] ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        LeetCode0162Solution solution = new LeetCode0162Solution();
        System.out.println(solution.findPeakElement(nums));
    }

}
