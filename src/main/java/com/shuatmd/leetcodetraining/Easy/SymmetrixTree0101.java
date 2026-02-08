package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//101. 对称二叉树
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
public class SymmetrixTree0101 {
    //递归判断:两个相反的指针 递归整个root
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

    //遍历做法：用两个queue 一个正向塞入元素 一个反向 循环比较值是否相等
    public boolean isSymmetric2(TreeNode root) {
        return checkForLoop(root, root);
    }

    private boolean checkForLoop(TreeNode left, TreeNode right) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(left);
        rightQueue.offer(right);
        while (!leftQueue.isEmpty()) {
            TreeNode leftCur = leftQueue.poll();
            TreeNode rightCur = rightQueue.poll();
            if (leftCur == null && rightCur == null) {
                continue;
            }
            if ((rightCur == null || leftCur == null) || (rightCur.val != leftCur.val)) {
                return false;
            }
            leftQueue.add(leftCur.left);
            leftQueue.add(leftCur.right);
            rightQueue.add(rightCur.right);
            rightQueue.add(rightCur.left);
        }
        return true;
    }
}
