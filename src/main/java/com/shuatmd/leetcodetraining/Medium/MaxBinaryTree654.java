package com.shuatmd.leetcodetraining.Medium;
//654. 最大二叉树
//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
//创建一个根节点，其值为 nums 中的最大值。
//递归地在最大值 左边 的 子数组前缀上 构建左子树。
//递归地在最大值 右边 的 子数组后缀上 构建右子树。
//返回 nums 构建的 最大二叉树 。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxBinaryTree654 {
    Map<Integer, Integer> indexMap = new HashMap<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((a, b) -> b - a);

    public static void main(String[] args) {
        MaxBinaryTree654 test = new MaxBinaryTree654();
        test.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    //官方解法 模拟
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int maxIndex = left;
        for (int i = left+1; i <= right; i++) {
            if(nums[i] > nums[left]){
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums,left,maxIndex-1);
        node.right = construct(nums,maxIndex + 1, right);
        return node;
    }

}
