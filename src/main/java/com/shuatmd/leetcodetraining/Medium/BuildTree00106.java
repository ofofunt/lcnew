package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;

//106. 从中序与后序遍历序列构造二叉树
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
public class BuildTree00106 {
    int postIdx;
    int[] postOrder;
    int[] inOrder;
    Map<Integer,Integer> indexMap = new HashMap<>();
    //递归解法： 从后续遍历的最后一位开始 轮流build左右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        this.postIdx = postOrder.length - 1;
        int idx = 0;
        for (int i : inOrder) {
            indexMap.put(i,idx);
            idx++;
        }
        return helper(0,inOrder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right){
            return null;
        }
        int rootVal = postOrder[right];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = indexMap.get(rootVal);
        postIdx --;
        root.right = helper(rootIndex + 1,right);
        root.left = helper(left,rootIndex - 1);
        return root;

    }
}
