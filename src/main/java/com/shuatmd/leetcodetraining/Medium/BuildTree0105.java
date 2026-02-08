package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//105. 从前序与中序遍历序列构造二叉树
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
public class BuildTree0105 {
    public static void main(String[] args) {
        BuildTree0105 test = new BuildTree0105();

        test.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    //手搓尝试: 递归
    //理解好难
    public TreeNode buildTreeStack(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        //前序第0位一定是root
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            //如果当前栈顶的val不等于inorder中的value 说明目前的node依然是左子树
            if(node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }
            //如果当前node = stack.peek
            //说明左子树已经构建完毕,需要出栈到对应的根节点
            else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);

            }
        }
        return root;
    }
    //手搓尝试：不断分左右构建
    //bfs实现不了 只能dfs实现
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        int n = inorder.length;
        if(m == 0 || n == 0 || m != n){
            return new TreeNode(0);
        }
        int index = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            int currVal = curr.val;
            for (int i = 0; i < m; i++) {
                if(inorder[i] == currVal){
                    index = i;
                    break;
                }
            }
            //如果index - 1 >= 0 说明一定有左边部分
            if(index - 1 >= 0){
                curr.left = new TreeNode(preorder[index - 1]);
                queue.offer(curr.left);
            }
            if(index + 1 < m){
                curr.right = new TreeNode(inorder[index + 1]);
                queue.offer(curr.right);
            }
        }
        return root;
    }
}
