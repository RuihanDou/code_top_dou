package codetopbytedance0001to0050.codetop0004;

import java.util.Random;

public class LeetCode0215SolutionByBinarySearch {

    public int findKthLargest(int[] nums, int k) {
        Random rnd = new Random();
        // 因为 k 是从右向左的 第 k 个，所以 partition 找的从左向右第 n - k = t (target)
        int l = 0, r = nums.length - 1, t = nums.length - k;
        while (l <= r){
            int p = partition(nums, l, r, rnd);

            if(p == t){
                return nums[t];
            }

            if(t < p){
                r = p - 1;
            }
            else {
                l = p + 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r, Random rnd) {
        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(nums, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while(true){

            while(i <= j && nums[i] < nums[l]){
                i ++;
            }
            while(j >= i && nums[j] > nums[l]){
                j --;
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
            i ++;
            j --;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
