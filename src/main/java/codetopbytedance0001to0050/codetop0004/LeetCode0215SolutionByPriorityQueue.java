package codetopbytedance0001to0050.codetop0004;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode0215SolutionByPriorityQueue {

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 最小优先队列 return o1.compareTo(o2);
                // 最大优先队列 return o2.compareTo(o1);
                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(!pq.isEmpty() && nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }


}
