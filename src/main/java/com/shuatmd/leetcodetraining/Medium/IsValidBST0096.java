package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//98. 验证二叉搜索树
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//有效 二叉搜索树定义如下：
//
//节点的左子树只包含 严格小于 当前节点的数。
//节点的右子树只包含 严格大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
public class IsValidBST0096 {
    public static void main(String[] args) {
        TreeNode test = TreeNode.buildTree(new Integer[]{5,1,4,null,null,3,6});
        IsValidBST0096 testValid = new IsValidBST0096();
        testValid.isValidBST(test);
    }
    //手搓解法：递归+层层判断
    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right == null){
            return true;
        }
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }

        return helper(root.left,minValue,root.val) && helper(root.right, root.val, maxValue) && (root.val > minValue && root.val < maxValue);
    }
}
