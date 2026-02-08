package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//110.平衡二叉树
//给定一个二叉树，判断它是否是 平衡二叉树
//平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。
public class CheckIfBalancedBInaryTree110 {
    //手搓解法：dfs
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int heightLeft = 0;
        int heigtRight = 0;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left !=null){
                heightLeft++;
                queue.offer(curr.left);
            }
            else{
                heightLeft =0;
            }
            if(curr.right !=null){
                heigtRight ++;
                queue.offer(curr.right);
            }
            else{
                heigtRight =0;
            }
            if(Math.abs(heigtRight - heightLeft)>1){
                return false;
            }

        }
        return Math.abs(heigtRight - heightLeft)>1;
    }
}
