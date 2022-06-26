package codetopbytedance0051to0100.codetop0070;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0958Solution {

    /**
     * 广度优先搜索
     * 设 二叉树 的层数从0开始
     * 第i层能容纳的 节点一共是 2^i 个
     * 第i层上 的位置j的节点的左子节点的 位置是i+1层上的 2*j, 右子节点的位置是 i+1 层上的 2*j + 1
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i-1).code == nodes.size();
    }

    private class ANode {  // Annotated Node
        TreeNode node;
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }


}
