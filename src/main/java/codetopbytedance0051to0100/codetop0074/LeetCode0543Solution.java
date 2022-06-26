package codetopbytedance0051to0100.codetop0074;

import struct.TreeNode;

public class LeetCode0543Solution {

    private int globalMax = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return globalMax - 1;
    }

    /**
     *  dfs 有两个过程，一个是线上返回经过本节点的最深路径，这个值 作为dfs的返回
     *
     *                 另一个是更新 globalMax 由于 globalMax 和 返回值要分别返回
     *
     *
     * @param node
     * @return
     */
    private int dfs(TreeNode node){

        if(node == null){
            return 0;
        }

        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);

        globalMax = Math.max(globalMax, leftDepth + rightDepth + 1);

        return Math.max(leftDepth, rightDepth) + 1;

    }
}
