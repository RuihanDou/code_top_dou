package codetopbytedance0001to0050.codetop0028;

import struct.TreeNode;

public class LeetCode0124Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftVal = Math.max(dfs(node.left), 0);
        int rightVal = Math.max(dfs(node.right), 0);

        maxSum = Math.max(leftVal + rightVal + node.val, maxSum);

        return Math.max(leftVal, rightVal) + node.val;
    }

}
