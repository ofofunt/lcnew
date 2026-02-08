package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

//230. 二叉搜索树中第 K 小的元素
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
public class KthSmallestInBST230 {
    private int count;
    private int res;

    public int kthSmallestBFS(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while(root!=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    //手搓解法： dfs，找到最左之后 循环k -1 直到k = 0
    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (count == 0) {
            return;
        }
        if (--count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
