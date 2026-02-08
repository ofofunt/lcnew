package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//112. 路径总和
//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//叶子节点 是指没有子节点的节点。
public class PathOfSum0112 {
    public static void main(String[] args) {
        TreeNode node = TreeNode.buildTree(new Integer[]{-2, null, -3});
        PathOfSum0112 test = new PathOfSum0112();
        test.hasPathSum(node, 5);

    }

    //尝试递归做：
    public boolean hasPathSumRecur(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return calculatePathSum(root, 0, targetSum);
    }

    private boolean calculatePathSum(TreeNode root, int val, int targetSum) {
        if (root == null) {
            return false;
        }
        if(root != null){
            val+=root.val;
        }
        if(root.left == null && root.right == null){
            return val == targetSum;
        }
        boolean left = calculatePathSum(root.left,val,targetSum);
        boolean right = calculatePathSum(root.right,val,targetSum);
        return left || right;
    }

    //尝试用遍历做
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> pathSum = new LinkedList<>();
        queue.offer(root);
        pathSum.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int currSum = pathSum.poll();
            if (currSum == targetSum && currNode.left == null && currNode.right == null) {
                return true;
            }
            if (currNode.left != null) {
                queue.offer(currNode.left);
                pathSum.offer(currSum + currNode.left.val);
            }
            if (currNode.right != null) {
                queue.offer(currNode.right);
                pathSum.offer(currSum + currNode.right.val);
            }
        }
        return false;
    }
}
