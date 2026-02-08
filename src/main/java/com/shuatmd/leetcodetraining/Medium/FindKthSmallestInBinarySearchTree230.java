package com.shuatmd.leetcodetraining.Medium;
//230. 二叉搜索树中第 K 小的元素
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

public class FindKthSmallestInBinarySearchTree230 {
    int res;
    int k;
    //官方解法：
    //中序遍历,找寻从下至上的第k个节点
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        recur(root);
        return res;
    }

    private void recur(TreeNode root) {
        if(root == null){
            return;
        }
        recur(root.left);
        if(k == 0){
            return;
        }
        if(--k == 0){
            res = root.val;
        }
        recur(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{5,3,6,2,4,null,null,1});
        int k = 3;
        FindKthSmallestInBinarySearchTree230 test = new FindKthSmallestInBinarySearchTree230();
        test.kthSmallest(treeNode,k);
    }
}
