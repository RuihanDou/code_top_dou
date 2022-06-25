package codetopbytedance0051to0100.codetop0057;

import java.util.Stack;

public class LeetCode0232MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    int front;

    public LeetCode0232MyQueue() {

    }

    public void push(int x) {
        if(s1.empty()){
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }


}
