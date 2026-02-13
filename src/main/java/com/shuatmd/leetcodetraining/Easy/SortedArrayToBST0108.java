package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//108. 将有序数组转换为二叉搜索树
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
public class SortedArrayToBST0108 {
    public static void main(String[] args) {
        SortedArrayToBST0108 test = new SortedArrayToBST0108();
        test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        int rootVal = nums[length / 2];
        TreeNode res = new TreeNode(rootVal);
        int left = length / 2 - 1;
        int right = length - 1;
        TreeNode leftNode = res;
        TreeNode rightNode = res;
        while (left >= 0 || right > length / 2) {
            while (left >= 0) {
                leftNode.left = new TreeNode(nums[left]);
                leftNode = leftNode.left;
                left--;
            }

            rightNode.right = new TreeNode(nums[right]);
            rightNode = rightNode.right;
            while (right > length / 2) {
                rightNode.left = new TreeNode(nums[right]);
                rightNode = rightNode.left;
                right--;
            }
        }
        return res;
    }
}
