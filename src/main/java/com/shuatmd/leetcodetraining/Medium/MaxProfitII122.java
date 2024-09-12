package com.shuatmd.leetcodetraining.Medium;

//122. 买卖股票的最佳时机 II
//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//
//在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//
//返回 你能获得的 最大 利润 。
//
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class MaxProfitII122 {
    //手搓方法1：
    //尝试先找到最大profit的段落 之后找段落之后的最大盈利
    //想法不成立
    public int maxProfit(int[] prices) {
        int index = 0;
        int sumProfit = 0;
        int n = prices.length;
        while (index < n) {
            int pointer = index;
            int value = prices[pointer];
            int curProfit = 0;
            for (int i = index + 1; i < prices.length; i++) {
                int curValue = prices[i];
                if (curValue - value <= 0) {
                    pointer = i;
                    value = curValue;
                } else {
                    if (curValue - value > curProfit) {
                        index = i;
                        curProfit = curValue - value;
                    }
                }
            }
            index++;
            sumProfit += curProfit;
        }
        return sumProfit;
    }

    public static void main(String[] args) {
        MaxProfitII122 maxProfit = new MaxProfitII122();
        maxProfit.maxProfit(new int[] {7,1,5,3,6,4});
    }
}
