package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//236. 二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//
public class LowestCommonAnsestor236 {
    //官方解法1：递归 + 记录
    //递归的同时进行分类讨论
    //如果left和right子树都不存在p q 则返回null
    //如果left 存在p或者q right也存在p或者q 则说明他们的祖先一定为root
    //如果left同时存在pq,则直接返回left 否则返回right
    //如果right同时存在pq，则相反
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        //先左后右查询
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //分类讨论
        if(left == null && right == null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;


    }
}
