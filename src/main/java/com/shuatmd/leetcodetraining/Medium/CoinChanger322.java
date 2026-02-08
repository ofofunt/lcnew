package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//322. 零钱兑换
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
//
//计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
//
//你可以认为每种硬币的数量是无限的。
public class CoinChanger322 {
    //官方题解：dp自下而上去做
    //假设coin是[1,2,3]
    //dp[i] = min(dp[i-1],dp[i-2],dp[i-3]) + 1
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化dp中的值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //如果当前coins小于目标,则没必要选
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount? -1:dp[amount];
    }
}
