package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//404. 左叶子之和
//给定二叉树的根节点 root ，返回所有左叶子之和。
public class SumOfLeftLeaves404 {
    //遍历：在每次loop的时候记录左边sum
    //遍历到左子节点 判断是不是叶子 如果是则加上
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
                if (curr.left.left == null && curr.left.right == null) {
                    res += curr.left.val;
                }
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return res;


    }
}
