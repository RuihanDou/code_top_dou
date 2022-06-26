package codetopbytedance0051to0100.codetop0064;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode0155MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public LeetCode0155MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
