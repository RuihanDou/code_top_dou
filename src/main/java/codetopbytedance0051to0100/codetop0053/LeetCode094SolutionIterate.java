package codetopbytedance0051to0100.codetop0053;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode094SolutionIterate {

    private List<Integer> inOrderList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderNR(root);
        return inOrderList;
    }

    private void inOrderNR(TreeNode node){
        if(node == null){
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = node;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()){
                cur = stack.pop();
                inOrderList.add(cur.val);
                cur = cur.right;
            }
        }
    }

}
