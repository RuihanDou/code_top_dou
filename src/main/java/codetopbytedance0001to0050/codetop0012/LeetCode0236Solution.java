package codetopbytedance0001to0050.codetop0012;

import struct.TreeNode;

public class LeetCode0236Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return null;

    }

}
