package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//110. 平衡二叉树
//给定一个二叉树，判断它是否是 平衡二叉树
public class IsBalancedTree00110 {
    //自上而下: 算每个左右子树的最大height 然后对比
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);

    }

    private int getHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    //自下而上进行对比判断
    public boolean isBalancedFromBottom(TreeNode root) {
       return findHeight(root) >= 0;

    }

    private int findHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        else{
            return Math.max(leftHeight,rightHeight) + 1;
        }

    }
}
