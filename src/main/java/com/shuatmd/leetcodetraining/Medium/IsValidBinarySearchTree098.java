package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//98. 验证二叉搜索树
//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
//有效 二叉搜索树定义如下：
//
//节点的左子树只包含 严格小于 当前节点的数。
//节点的右子树只包含 严格大于 当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
public class IsValidBinarySearchTree098 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        IsValidBinarySearchTree098 test = new IsValidBinarySearchTree098();
        test.isValidBST(root);
    }
    //官方解法1：中序遍历 然后不断比较大小
    public boolean isValidBSTBFS(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        double inorder = - Double.MAX_VALUE;
        while(!queue.isEmpty() || root!=null){
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


    //需要注意的点：需要一直检查是否严格满足
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(TreeNode node, int lowerBound, int upperBound) {
        if (node == null) {
            return true;
        }
        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }
        return check(node.left, lowerBound, node.val) && check(node.right, node.val, upperBound);

    }
}
