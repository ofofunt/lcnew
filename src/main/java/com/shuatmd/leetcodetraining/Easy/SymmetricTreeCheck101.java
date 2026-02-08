package com.shuatmd.leetcodetraining.Easy;
//101. 对称二叉树
//给你一个二叉树的根节点 root ， 检查它是否轴对称。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTreeCheck101 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        SymmetricTreeCheck101 test = new SymmetricTreeCheck101();
        test.isSymmetricBFS(treeNode);


    }
    //官方解法1：递归
    //好难想明白
    public boolean isSymmetricDFS(TreeNode root) {
        boolean b = root == null || recur(root.left, root.right);
        return b;

    }

    private boolean recur(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if((left == null || right == null) ||left.val!=right.val){
            return false;
        }
        return recur(left.left,right.right) && recur(left.right, right.left);
    }

    //官方解法1：BFS
    //方法与手搓类似，但是有小操作
    //可以轮流吧左右branch加入queue来解决while对比的问题
    public boolean isSymmetricBFSOfficial(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode u = root;
        TreeNode v = root;
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            //如果都为空 则跳过
            if (u == null && v == null) {
                continue;
            }
            //如果uv只有一个是空,或者数值不相等 直接返回false
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }
            //将 uv的左右交替放入queue 方便顺序对比 不需要在用while双指针对比
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;


    }

    //手搓尝试 先从BFS开始
    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> leftList = new LinkedList<>();
            List<Integer> rightList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                    leftList.add(poll.left.val);
                } else {
                    leftList.add(999);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    rightList.add(poll.right.val);
                } else {
                    rightList.add(999);
                }
                size--;
            }
            if (leftList.size() != rightList.size()) {
                return false;
            }
            int left = 0;
            int right = rightList.size() - 1;
            while (left < leftList.size()) {
                if (!leftList.get(left).equals(rightList.get(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;

    }
}
