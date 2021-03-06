package codetopbytedance0001to0050.codetop0042;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode032SolutionStack {

    /**
     * 我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
     *
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * 我们从前往后遍历字符串并更新答案即可。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxAns = 0;
        // stack 中存的是下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else { // s.charAt(i) == ')'
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else {
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }


}
