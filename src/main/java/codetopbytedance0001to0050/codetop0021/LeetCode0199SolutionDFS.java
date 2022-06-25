package codetopbytedance0001to0050.codetop0021;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode0199SolutionDFS {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        // 记录层深，结点每到一个新层从右向左编列
        // 当层深 == res.size(),证明到了一个新的层，res添加一个当前层的元素，直到当前层结束前 维持 当前层 < res.size()
        dfs(root, 0);
        return res;
    }

    // 控制递归顺序，先右后左
    private void dfs(TreeNode node, int depth){
        if(node == null){
            return;
        }
        if(depth == res.size()){
            res.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }

}
