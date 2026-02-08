package com.shuatmd.leetcodetraining.Medium;
//
public class LengthOfLongestIncreasingSubArray300 {
    //官方解法：dp
    //记录dp[i]为第i为时最长递增子序列的长度
    //当i+1位如果出现比i[j]大的数字时候 则dp[i+1] = Max(dp[i], dp[j] + 1)
    //循环所有可能的j 得到i的dp[i]
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        //从1开始进行dp流程
        for (int i = 1; i < nums.length; i++) {
            //初始设为最大子序列长度设为1
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }
}
