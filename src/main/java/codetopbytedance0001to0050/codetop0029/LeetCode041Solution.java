package codetopbytedance0001to0050.codetop0029;

public class LeetCode041Solution {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        // nums 数组中 所有 <= 0 的数字 都 让它成为 大数 大数为 len + 1
        for(int i = 0; i < len; i++) {
            if(nums[i] <= 0){
                nums[i] = len + 1;
            }
        }

        // nums 中所有的 [1, len] 区间的数i 出现过
        // nums 中 i - 1 位置的值要 置成负数
        // 注意，因为 i 的值 怕出现重复，所以使用绝对值取负值
        for(int i = 0; i < len; i++){
            int num = Math.abs(nums[i]);
            if(num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // 此时 i - 1 位置的数是大于0的，那么i就是要求的结果
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return len + 1;
    }

}
