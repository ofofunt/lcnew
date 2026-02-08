package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;

//106. 从中序与后序遍历序列构造二叉树
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
public class BuildTreeBasedOnInOrderAndPostOrder106 {
    //官方解法：递归
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode treeBuilder(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        //取post_idx位的为根元素
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        root.right = treeBuilder(index + 1, in_right);
        root.left = treeBuilder(in_left,index -1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        //倒序开始遍历 从最后一位开始
        post_idx = postorder.length - 1;
        int idx = 0;
        for (int i : inorder) {
            idx_map.put(i, idx++);
        }
        return treeBuilder(0, inorder.length - 1);
    }

}
