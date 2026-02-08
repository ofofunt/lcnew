package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//226. 翻转二叉树
public class InvertTree00226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        swap(root);
        return root;
    }
    private void swap(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        swap(root.left);
        swap(root.right);
    }
}
