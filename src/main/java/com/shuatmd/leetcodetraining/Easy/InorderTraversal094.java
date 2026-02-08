package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//94. 二叉树的中序遍历
//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
public class InorderTraversal094 {
    List<Integer> res = new LinkedList<>();
    //手搓2:BFS
    public List<Integer> inorderTraversalBFS(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while(root != null || !nodeQueue.isEmpty()){
            while(root!=null){
                nodeQueue.push(root);
                root = root.left;
            }
            root = nodeQueue.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;

    }
    //手搓1：DFS
    public List<Integer> inorderTraversalDFS(TreeNode root) {
        recur(root);
        return res;

    }

    private void recur(TreeNode node) {
        if(node == null){
            return;
        }
        recur(node.left);
        res.add(node.val);
        recur(node.right);
    }
}
