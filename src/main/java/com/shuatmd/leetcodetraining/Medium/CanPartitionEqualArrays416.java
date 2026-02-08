package com.shuatmd.leetcodetraining.Medium;

//416. 分割等和子集
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
public class CanPartitionEqualArrays416 {
    //官方解法：dp解决
    //转变为0-1口袋问题,用dp求解是否能找到一个subArray，且和刚好为nums的sum的一半
    //设dp[i][j]为从index 0 到 i能满足和为j的转换方程
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        //排除掉length小于2的情况
        if (len < 2) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        //如果sum是奇数,则说明不可能存在能均分的数组
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        //如果最大数超过了和的一半 则也排除
        if (maxNum > target) {
            return false;
        }
        //因为是从0开始到target 所以长度要为target+1
        boolean dp[][] = new boolean[len][target + 1];
        //初始化 所有dp[i][0]都为true
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 0; j <= target; j++) {
                //如果当前需要的j 大于 当前的数字num
                //则可以考虑是否需要将num放入数组
                //如果选择不放入数组 则dp[i][j] = dp[i-1][j]
                //如果选择放入数组 则dp[i][j] = dp[i-1][j-num]
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
                //如果j小于num 则一定不需要放入当前数字
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
