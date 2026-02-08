package com.shuatmd.leetcodetraining.Medium;

//53. 最大子数组和
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组是数组中的一个连续部分。
public class MaxSubArray053 {
    public static void main(String[] args) {
        MaxSubArray053 test = new MaxSubArray053();
        test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    //手搓解法：如果没有贡献 则直接移到新位置
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

    }
}
