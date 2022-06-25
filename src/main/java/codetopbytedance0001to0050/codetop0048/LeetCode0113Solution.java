package codetopbytedance0001to0050.codetop0048;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0113Solution {

    private List<List<Integer>> ret = new ArrayList<>();
    private Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recursive(root, targetSum);
        return ret;
    }

    private void recursive(TreeNode node, int targetSum){
        if (node == null){
            return;
        }
        path.offerLast(node.val);
        targetSum -= node.val;
        if(node.left == null && node.right == null && targetSum == 0){
            ret.add(new ArrayList<>(path));
        }
        recursive(node.left, targetSum);
        recursive(node.right,targetSum);
        path.pollLast();
    }

}
