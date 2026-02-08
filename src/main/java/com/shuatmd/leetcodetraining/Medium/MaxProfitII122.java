package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//122. 买卖股票的最佳时机 II
//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
//
//在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
//
//返回 你能获得的 最大 利润 。
//
//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class MaxProfitII122 {
    //官方解法2：dp
    //合理解法
    //首先构造转换方程
    //dp[i][0]代表第i天手中没有持有股票的最大收益
    //dp[i][0] = Math.max(dp[i - 1][0] )
    //官方解法1：贪心
    //官方的贪心更简单 因为可以同天进行买入卖出
    //只需要考虑两天之内的差值即可
    public int maxProfit2OfficialGreedy(int[] prices) {
        //对prices数组进行遍历
        //取出22中间的差值
        //只有差值为正才说明有收益 只需要统计差值为正的部分
        int maxProfit = 0;
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 1; i < prices.length; i++) {
            int curPrice = prices[i];
            int prePrice = prices[i - 1];
            int profit = curPrice - prePrice;
            if(profit >0){
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
    //手搓方法2： 贪心
    //思路比较简单 只要赚钱就停
    public int maxProfit2(int[] prices) {
        int sumProfit = 0;
        int n = prices.length;
        int index = 0;
        while (index < n - 1) {
            int preValue = prices[index];
            int curProfit = 0;
            for (int i = index + 1; i < prices.length; i++) {
                int curValue = prices[i];
                if (curValue - preValue <= 0) {
                    preValue = curValue;
                } else {
                    if (curValue - preValue > curProfit) {
                        index = i;
                        curProfit = curValue - preValue;
                        break;
                    }
                }
                index++;
            }
            sumProfit += curProfit;
        }
        return sumProfit;
    }

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
        maxProfit.maxProfit2(new int[]{7,1,5,3,6,4});
    }
}
