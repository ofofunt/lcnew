package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//98. 验证二叉搜索树
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//有效 二叉搜索树定义如下：
//
//节点的左子树只包含 严格小于 当前节点的数。
//节点的右子树只包含 严格大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
public class IsValidBFS98 {
    //官方解法2：中序遍历 binarySearchTree的中序遍历已经是按顺序排列
    //我们可以模拟中序遍历的过程 检查值是否为递增
    public boolean isValidBSTInodrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!queue.isEmpty() || root != null) {
            while(root!=null){
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            if(root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;

    }

    //手搓解法1：递归 + 判断左右子树是否严格满足条件
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

}
