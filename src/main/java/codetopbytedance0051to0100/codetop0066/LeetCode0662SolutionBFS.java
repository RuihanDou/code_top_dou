package codetopbytedance0051to0100.codetop0066;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0662SolutionBFS {


    private class PositionNode{
        public TreeNode treeNode;
        public int depth;
        public int pos;

        public PositionNode(TreeNode treeNode, int depth, int pos){
            this.treeNode = treeNode;
            this.depth = depth;
            this.pos = pos;
        }
    }

    /**
     * 广度优先搜索
     * 设 二叉树 的层数从0开始
     * 第i层能容纳的 节点一共是 2^i 个
     * 第i层上 的位置j的节点的左子节点的 位置是i+1层上的 2*j, 右子节点的位置是 i+1 层上的 2*j + 1
     *
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }

        Queue<PositionNode> queue = new LinkedList<>();
        queue.offer(new PositionNode(root, 0, 0));
        int width = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int l = -1, r = -1;
            for(int i = 0; i < size; i++){
                PositionNode pn = queue.poll();
                if(i == 0){
                    l = pn.pos;
                }
                if(i == size - 1){
                    r = pn.pos;
                }
                if(pn.treeNode.left != null){
                    queue.offer(new PositionNode(pn.treeNode.left, pn.depth + 1, 2 * pn.pos));
                }
                if(pn.treeNode.right != null){
                    queue.offer(new PositionNode(pn.treeNode.right, pn.depth + 1, 2 * pn.pos + 1));
                }
            }
            width = Math.max(width, r - l + 1);
        }
        return width;
    }

}
