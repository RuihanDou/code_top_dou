package codetopbytedance0001to0050.codetop0022;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode020Solution {

    private static final Map<Character, Character> brankets = new HashMap<>();
    static {
        brankets.put(')','(');
        brankets.put(']','[');
        brankets.put('}','{');
    }

    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            // 如果是左括号，压入栈
            if (brankets.values().contains(c)) {
                stack.push(c);
            }
            // 如果是右括号，此时如果栈内没有对应的左括号，return false
            else if (brankets.keySet().contains(c)) {
                if (stack.size() == 0 || !brankets.get(c).equals(stack.pop())) {
                    return false;
                }
            }
            // 不进行操作
            else {
                continue;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        LeetCode020Solution solution = new LeetCode020Solution();
        System.out.println(solution.isValid(s));
    }
}
