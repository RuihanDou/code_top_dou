package codetopbytedance0051to0100.codetop0053;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode094SolutionRecursive {

    private List<Integer> inOrderList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return inOrderList;
    }

    private void inOrder(TreeNode node){
        if(node != null){
            inOrder(node.left);
            inOrderList.add(node.val);
            inOrder(node.right);
        }
    }

}
