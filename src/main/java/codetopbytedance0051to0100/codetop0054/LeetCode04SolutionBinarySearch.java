package codetopbytedance0051to0100.codetop0054;

public class LeetCode04SolutionBinarySearch {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 减少讨论，让 num1 长度 保持 小于等于 nums2
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线 左边的元素数量 = 分割线 右边的元素数量 [(m + n) 是偶数] 或者 左边 比 右边 多一个 totalLeft = (m + n + 1) / 2 [(m + n) 是奇数]
        int totalLeft = m + (n - m + 1) / 2;

        // 循环不变体在[left, right] 里寻找恰当的分割线
        // num1里分割线 x（分割线前有x个元素） 那 num2里分割线为 totalLeft - x
        // 设 num1 里分割线 为 i num2 里分割线为j
        // num1[i - 1] <= num2[j] && num2[j - 1] <= nums1[i]
        int left = 0, right = m;
        while (left < right){
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;

            if(nums1[i - 1] > nums2[j]){
                // 下一轮搜索的区间为[left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间为[i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int nums1rightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
        int nums2rightMin = j == n ? Integer.MAX_VALUE :nums2[j];

        if ((m + n) % 2 == 1){
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1rightMin, nums2rightMin)) / 2.0;
        }
    }

}
