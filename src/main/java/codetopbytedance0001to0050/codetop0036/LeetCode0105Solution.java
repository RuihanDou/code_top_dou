package codetopbytedance0001to0050.codetop0036;

import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode0105Solution {

    // 为了快速从中序序列中获取 root 的索引，所以先用map记录 值和其对应索引
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if(preLen != inLen){
            throw new RuntimeException("Incorrect input data.");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);

    }

    /**
     *  前序遍历序列 preLeft preRight 之间可以拆成 3 部分
     *
     *  preLeft 根节点
     *  preLeft + 1 到 pIndex - inLeft + preLeft 为根节点的左子树
     *  pIndex - inLeft + preLeft + 1 到 preRight 为根节点的右子树
     *
     * 中序遍历序列 inLeft inRight 之间可以拆成 3 部分
     *
     * inLeft 到 pIndex - 1 为根节点的左子树
     * pIndex 根节点
     * pIndex + 1 到 inRight 为根节点的右子树
     *
     * @param preOrder 前序遍历序列
     * @param preLeft 前序遍历序列子区间的左边界 闭区间
     * @param preRight 前序遍历序列子区间的有边界 闭区间
     * @param map    在中序遍历序列里 数值与其下标的对应关系
     * @param inLeft   中序遍历序列子区间的左边界 闭区间
     * @param inRight  中序遍历序列子区间的有边界 闭区间
     * @return
     */
    private TreeNode buildTree(int[] preOrder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        int rootVal = preOrder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);

        root.left = buildTree(preOrder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preOrder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }


}
