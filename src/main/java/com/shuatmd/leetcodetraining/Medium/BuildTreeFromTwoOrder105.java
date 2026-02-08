package com.shuatmd.leetcodetraining.Medium;
//105. 从前序与中序遍历序列构造二叉树
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

public class BuildTreeFromTwoOrder105 {
    private Map<Integer,Integer> indexMap;
    public static void main(String[] args) {
        BuildTreeFromTwoOrder105 test = new BuildTreeFromTwoOrder105();
        test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
    //官方姐法2：DFS + 递归
    //前序遍历找根节点 然后中序遍历去找左右子树 递归生成树
    public TreeNode buildTreeBFSOfficial(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTreeBFS(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildTreeBFS(int[] preorder, int preStart, int preEnd, int[] inorder, int inorderStart, int inorderEnd) {
        //终止条件
        //超过边界
        if(preStart>preEnd || inorderStart>inorderEnd){
            return null;
        }
        //当前preorder的第一位一定是root节点
        int rootVal = preorder[preStart];
        int index = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - preStart;
        root.left = buildTreeBFS(preorder,preStart+1,preStart+leftSize,inorder,inorderStart,index-1);
        root.right = buildTreeBFS(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inorderEnd);
        return root;
    }

    //官方解法1：BFS + 栈
    public TreeNode buildTreeOfficial(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        //初始化，将头节点放入queue中
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        //已经放入root所以从1开始
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            int preorderVal = preorder[i];
            //如果当前遍历的点不等于中序遍历最左边的点,则说明一定处于root节点的左半边
            //将当前节点持续放入左边
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }
            //如果当前节点指向的index为最左,则不断pop出stack中的node，直到stack的peek与当前节点指向的node相等
            //然后吧当前数放入pop出的node的右边
            else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }

        }
        return root;
    }

    //手搓想法1： 根据前序为主，判断点在中序的位置 逐步遍历
    //想法错误
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return new TreeNode(0);
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode res = new TreeNode(preorder[0]);
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(res);
        int count = 1;
        int preIndex = 1;
        while (count < preorder.length || treeNodes != null) {
            TreeNode poll = treeNodes.poll();
            int index = indexMap.get(poll.val);
            TreeNode nextLeft = new TreeNode(preorder[count]);
            int indexNext = indexMap.get(nextLeft.val);
            if (indexNext < index) {
                poll.left = nextLeft;
                treeNodes.offer(nextLeft);
                count++;
            } else {
                poll.right = nextLeft;
                treeNodes.offer(nextLeft);
                count++;
                continue;
            }
            TreeNode nextRight = new TreeNode(preorder[count]);
            int indexRight = indexMap.get(nextRight.val);
            if (indexRight > index) {
                poll.right = nextRight;
                treeNodes.offer(nextRight);
                count++;
            }
        }
        return res;
    }

}
