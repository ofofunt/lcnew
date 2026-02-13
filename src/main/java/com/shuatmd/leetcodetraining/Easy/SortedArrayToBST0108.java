package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//108. 将有序数组转换为二叉搜索树
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
public class SortedArrayToBST0108 {
    public static void main(String[] args) {
        SortedArrayToBST0108 test = new SortedArrayToBST0108();
        test.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
    //中序遍历保证升序
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length -1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

}
