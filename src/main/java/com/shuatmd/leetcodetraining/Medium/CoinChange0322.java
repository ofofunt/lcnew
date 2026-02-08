package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

public class CoinChange0322 {
    //dp推算
    //假设当前有硬币 1 2 5
    //已知dp[1]为满足1块钱时需要最少的硬币数量 = 1
    //则dp[2] = Math.min(dp[2 - 1], dp[2-2],dp[2-5]) + 1
    public int coinChange(int[] coins, int amount) {
        int max = amount +1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount? -1 : dp[amount];

    }
}
