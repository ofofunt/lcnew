package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//226. 翻转二叉树
//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
public class InvertTree226 {

    //手搓解法2：DFS尝试
    //从上往下交换
    public TreeNode invertTreeDFS2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeDFS2(root.left);
        invertTreeDFS2(root.right);
        return root;
    }

    //官方解法1：DFS尝试
    //从下往上交换
    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeDFS(root.left);
        TreeNode right = invertTreeDFS(root.right);
        root.left = right;
        root.right = left;
        return root;

    }

    //手搓解法1：DFS尝试
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode left = poll.left;
            poll.left = poll.right;
            poll.right = left;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return root;

    }
}
