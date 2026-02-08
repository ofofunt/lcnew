package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//617. 合并二叉树
//给你两棵二叉树： root1 和 root2 。
//
//想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
//
//返回合并后的二叉树。
//
//注意: 合并过程必须从两个树的根节点开始。
public class MergeTwoBinaryTree0617 {
    //官方解法： 简单递归
    public TreeNode mergeTreesOfficial(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTreesOfficial(root1.left,root2.left);
        root.right = mergeTreesOfficial(root2.left,root2.right);
        return root;
    }
    //手搓解法： 过于复杂了有点
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        return helper(root1,root2);
    }

    private TreeNode helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        TreeNode root;
        if(root1 !=null && root2!=null){
             root = new TreeNode(root1.val + root2.val);
        }
        else{
             root = root1==null? new TreeNode(root2.val):new TreeNode(root1.val);
        }
        root.left = helper(root1 == null? null:root1.left,root2 == null? null:root2.left);
        root.right = helper(root1 == null? null:root1.right,root2 == null? null:root2.right);
        return root;
    }
}
