package com.shuatmd.leetcodetraining.Medium;

//53. 最大子数组和
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组是数组中的一个连续部分。
public class MasSumSubarray053 {
    //官方解法：dp 同样的思维 但是更清晰
    //设最后的结果为dp[n] = Math.max(dp[n-1] + nums[i],nums[i])就好
    public int maxSubArrayOfficial(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxValue = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxValue = Math.max(maxValue, dp[i]);

        }
        return maxValue;
    }

    //手搓尝试：尝试使用那个什么算法来做，统计左边部分的贡献，如果小于0则直接舍弃
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (curr < 0) {
                max = Math.max(max, curr);
                curr = 0;
            } else {
                max = Math.max(max, curr);
            }

        }
        return max;
    }
}
