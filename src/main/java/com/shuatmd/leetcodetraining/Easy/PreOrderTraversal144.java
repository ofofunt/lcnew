package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//144. 二叉树的前序遍历
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
public class PreOrderTraversal144 {
    //手搓：递归
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorderTraversalDFS(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        list.add(root.val);
        preorderTraversalDFS(root.left);
        preorderTraversalDFS(root.right);
        return list;
    }
    //手搓：遍历
    public List<Integer> preorderTraversalBFS(TreeNode root) {
        if(root == null){
            return new LinkedList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> res = new LinkedList<>();
        TreeNode node = root;
        while(!queue.isEmpty()||root!=null){
           while(node!=null){
               res.add(node.val);
               queue.push(node);
               node = node.left;
           }
           node = queue.pop();
           node = node.right;
        }
        return res;
    }
}
