package codetopbytedance0001to0050.codetop0034;

import struct.TreeNode;

public class LeetCode0129Solution {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int preSum) {

        if(node == null){
            return 0;
        }

        int sum = preSum * 10 + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }

    }

}
