package com.shuatmd.leetcodetraining.Hard;
//124. 二叉树中的最大路径和
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//路径和 是路径中各节点值的总和。
//
//给你一个二叉树的根节点 root ，返回其 最大路径和 。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

public class MathSumOfPath124 {
    int maxSum = Integer.MIN_VALUE;
    //官方解法：DFS 从下至上 + 递归
    public int maxPathSum(TreeNode root) {
        return maxGain(root);
    }

    private int maxGain(TreeNode node) {
        if(node == null){
            return 0;
        }
        //剪枝 丢弃掉总贡献小于0的部分节点
        //如果自下而上的部分总和小于0 则直接丢弃 用0替代
        int leftGain = Math.max(0,maxGain(node.left));
        int rightGain = Math.max(0,maxGain(node.right));

        int priceNewPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewPath);
        //不是每个节点都能带走左右子节点，所以只记录一个
        return node.val + Math.max(leftGain,rightGain);
    }
}
