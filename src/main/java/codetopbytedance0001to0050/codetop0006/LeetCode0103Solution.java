package codetopbytedance0001to0050.codetop0006;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode0103Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }

        deque.addLast(root);
        int levelNum = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            boolean leftToRight = levelNum % 2 == 0;
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = leftToRight ? deque.removeFirst() : deque.removeLast();
                level.add(cur.val);
                if(leftToRight){
                    if(cur.left != null){
                        deque.addLast(cur.left);
                    }
                    if(cur.right != null){
                        deque.addLast(cur.right);
                    }
                }
                else {
                    if(cur.right != null){
                        deque.addFirst(cur.right);
                    }
                    if(cur.left != null){
                        deque.addFirst(cur.left);
                    }
                }
            }
            res.add(level);
            levelNum++;
        }

        return res;
    }



}
