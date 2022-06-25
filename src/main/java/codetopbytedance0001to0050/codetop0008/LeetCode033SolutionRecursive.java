package codetopbytedance0001to0050.codetop0008;

public class LeetCode033SolutionRecursive {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    private int search(int[] nums, int l, int r, int target) {
        int mid = l + (r - l) / 2;
        // System.out.println("l:" + l + " r:" + r + " mid:" + mid);

        if (nums[mid] == target){
            return mid;
        }

        if(l == r){
            return -1;
        }

        if(nums[l] < nums[mid]){
            if(target >= nums[l] && target <= nums[mid]){
                return search(nums, l, mid, target);
            } else {
                return search(nums, mid+1, r, target);
            }
        } else {
            if(target >= nums[mid + 1] && target <= nums[r]){
                return search(nums, mid + 1, r, target);
            } else {
                return search(nums, l, mid, target);
            }
        }
    }

}
