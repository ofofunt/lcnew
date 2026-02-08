package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//129. 求根节点到叶节点数字之和
//给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//每条从根节点到叶节点的路径都代表一个数字：
//
//例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//计算从根节点到叶节点生成的 所有数字之和 。
//
//叶节点 是指没有子节点的节点。
//
//
public class PathOfNumberSUm129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        PathOfNumberSUm129 test = new PathOfNumberSUm129();
        test.sumNumbersBFS(root);
    }

    //手搓解法2：遍历尝试
    public int sumNumbersDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        queue.offer(root);
        numQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            int num = numQueue.poll();
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    queue.offer(left);
                    numQueue.offer(num*10 +left.val);
                }
                if(right != null){
                    queue.offer(right);
                    numQueue.offer(num*10 + right.val);
                }
            }
        }
        return sum;
    }

    //手搓解法1：递归尝试
    public int sumNumbersBFS(TreeNode root) {
        return recur(root, 0);
    }

    private int recur(TreeNode root, Integer prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        return recur(root.left, sum) + recur(root.right, sum);
    }
}
