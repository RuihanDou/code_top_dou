package codetopbytedance0001to0050.codetop0019;

public class LeetCode0300SolutionGreedy {

    public int lengthOfLIS(int[] nums) {
        // 因为 最长上升子序列 最差有一个元素，所以 len 初始化为 1
        // 只要 nums 不为空，就至少又一个上升子序列 长度为1，包含nums[0]
        int len = 1, n = nums.length;
        if(n == 0){
            return 0;
        }
        // 记忆数组 d
        // d 上的 第 i 个位置存储 长度最长为 i 的上升子序列的 最后(右)结尾元素
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for(int i = 1; i < n; i++){
            // 延长上升子序列的情况
            if(nums[i] > d[len]){
                len++;
                d[len] = nums[i];
            }
            // 否则 上一个记录的上升子序列中有
            else{
                // 如果找不到，说明所有上升子序列里的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r){
                    int mid = l + (r - l) / 2;
                    if(d[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }
                    else{
                        r = mid - 1;
                    }
                }
                // 找到 pos d[pos] < nums[i]
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
