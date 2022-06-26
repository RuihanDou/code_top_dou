package codetopbytedance0051to0100.codetop0066;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0662SolutionDFS {

    // 因为 宽度无法设计为dfs递归函数的返回值，使用全局变量标记
    private int ans;
    // 记录每一层的最左边的位置
    private Map<Integer, Integer> leftMostPos;

    /**
     * 使用深度优先遍历
     * 设 二叉树 的层数从0开始
     * 第i层能容纳的 节点一共是 2^i 个
     * 第i层上 的位置j的节点的左子节点的 位置是i+1层上的 2*j, 右子节点的位置是 i+1 层上的 2*j + 1
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        leftMostPos = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth, int pos){
        if(node == null){
            return;
        }
        if(!leftMostPos.containsKey(depth)){
            leftMostPos.put(depth, pos);
        }
        ans = Math.max(ans, pos - leftMostPos.get(depth) + 1);
        dfs(node.left, depth + 1, 2 * pos);
        dfs(node.right, depth + 1, 2 * pos + 1);
    }

}
