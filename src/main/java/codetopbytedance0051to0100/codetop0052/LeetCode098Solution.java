package codetopbytedance0051to0100.codetop0052;

import struct.TreeNode;

public class LeetCode098Solution {

    public boolean isValidBST(TreeNode root) {

        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private boolean recursion(TreeNode node, long lower, long upper){
        if(node == null) {
            return true;
        }

        if(node.val <= lower || node.val >= upper){
            return false;
        }

        return recursion(node.left, lower, node.val) && recursion(node.right, node.val, upper);

    }

}
