package com.shuatmd.leetcodetraining.Easy;
//121. 买卖股票的最佳时机
//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
//
//你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
//
//返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class MaxProfit121 {
    //手搓解法1： 顺序遍历
    public int maxProfit(int[] prices) {
        //顺序遍历整个数组
        //用指针p指向最开始的元素
        //遍历过程中 将当前遍历元素与指针相减,如果为负数 则说明当前遍历数小于指针所指向的数字,替换指针指向的数字
        //如果为正数 则说明有profit 记录max profit
        if(prices.length < 2){
            return 0;
        }
        int p = prices[0];
        int cur = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            cur = prices[i];
            if(cur - p <= 0){
                p = cur;
            }
            else{
                profit = Math.max(profit,cur - p);
            }
        }
        return profit;
    }
}
