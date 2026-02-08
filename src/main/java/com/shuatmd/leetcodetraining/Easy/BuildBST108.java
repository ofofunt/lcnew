package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//108. 将有序数组转换为二叉搜索树
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
public class BuildBST108 {
    //手搓解法1：递归
    //因为已经是左右平衡 所以不断取中间数来当构建树就行
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return recur(0, length - 1, nums);
    }

    private TreeNode recur(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = recur(left, mid - 1, nums);
        res.right = recur(mid + 1, right, nums);
        return res;
    }
}
