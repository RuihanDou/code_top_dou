package codetopbytedance0001to0050.codetop0039;

import struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode0101SolutionBFS {

    // BFS
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode t1, TreeNode t2){
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(t1);
        q2.offer(t2);

        while (!q1.isEmpty() && !q2.isEmpty()){
            TreeNode s1 = q1.poll(), s2 = q2.poll();
            if(s1 == null && s2 == null){
                continue;
            }
            if(s1 == null || s2 == null || s1.val != s2.val){
                return false;
            }

            q1.offer(s1.left);
            q2.offer(s2.right);
            q1.offer(s1.right);
            q2.offer(s2.left);
        }
        return true;
    }


}
