package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//700. 二叉搜索树中的搜索
//给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
//
//你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
public class searchBST0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(val == root.val){
            return root;
        }
        return searchBST(root.val > val? root.left:root.right,val);
    }

}
