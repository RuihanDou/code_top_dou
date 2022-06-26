package codetopbytedance0051to0100.codetop0083;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0239Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // deque 存 nums 中的索引
        Deque<Integer> deque = new LinkedList<>();
        // 0 ~ k - 1 前 k 个数
        // 维护一个最长长度为k的 从头到尾 索引处数字 递减的单调队列
        for(int i = 0; i < k; i++){
            // 队列不为空，且队列里的末位的索引处的数字小于当前考察的数字，则删除末尾处索引
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for(int i = k; i < n; i++){
            // 与上面的单调队列同理
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


}
