package codetopbytedance0001to0050.codetop0013;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode042SolutionMonotonicStack {

    public int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int ans = 0, len = height.length;
        for(int i = 0; i < len; i++){
            while (!deque.isEmpty() && height[i] > height[deque.peekLast()]){
                int top = deque.pollLast();
                if(deque.isEmpty()){
                    break;
                }
                int distance = i - deque.peekLast() - 1;
                int boundedHeight = Math.min(height[i], height[deque.peekLast()]) - height[top];
                ans += distance * boundedHeight;
            }
            deque.offerLast(i);
        }
        return ans;
    }

}
