package codetopbytedance0001to0050.codetop0025;

import java.util.Arrays;

public class LeetCode0031Solution {

    // 4，5，2，6，3，1 -> 4，5，3，1，2，6
    public void nextPermutation(int[] nums) {

        //第一步，寻找最右边的逆序对
        // 下面 的while 循环和其初始化设置 i = nums.length - 2 是为了寻找最右边的一个逆序对(逆序对是指左小于右)
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //第二步，寻找逆序对，左边的元素位置i右边的  从数组最右边的比nums[i]大的元素， swap
        // nums[i] = 2
        // i >= 1 代表 nums 中存在这么一个逆序对
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // nums[j] = 3
            swap(nums, i, j);
        }
        //第三步，i+1位置之后的元素翻转
        // 4，5，3，6，2，1 元素3 i位置以后的元素反转
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 6, 3, 1};
        LeetCode0031Solution solution = new LeetCode0031Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


}
