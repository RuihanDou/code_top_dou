package codetopbytedance0001to0050.codetop0027;

public class LeetCode088Solution {

    // 原地排序，因为 nums1 后半部分为空，所以从后往前排不用害怕元素被覆盖的情况
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;

        while (p1 >= 0 || p2 >= 0){
            if(p1 < 0){
                cur = nums2[p2];
                p2--;
            } else if(p2 < 0){
                cur = nums1[p1];
                p1--;
            } else if(nums1[p1] > nums2[p2]){
                cur = nums1[p1];
                p1--;
            } else {
                cur = nums2[p2];
                p2--;
            }
            nums1[tail] = cur;
            tail--;
        }
    }

}
