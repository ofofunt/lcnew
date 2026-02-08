package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//222. 完全二叉树的节点个数
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
//完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层（从第 0 层开始），则该层包含 1~ 2h 个节点。
public class CountNodesCompleteTree0222 {
    //简单粗暴的递归
    //用迭代也可以实现 但是两种解法都没用使用到完全二叉树这个条件
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    //推荐解法：混合求节点数
    //由于完全二叉树的性质，至少存一个子树是满二叉树 导致递归的部分会提前返回
    public int countNodesMixed(TreeNode root) {
       TreeNode left = root;
       TreeNode right = root;
       int heightLeft = 0;
       int heightRight = 0;
       while(left!=null){
           left = left.left;
           heightLeft++;
       }
       while(right!= null){
           right = right.right;
           heightRight++;
       }
       if(heightLeft == heightRight){
           return (int)Math.pow(2,heightLeft) - 1;
       }
       return 1 + countNodesMixed(root.left) + countNodesMixed(root.right);


    }
}
