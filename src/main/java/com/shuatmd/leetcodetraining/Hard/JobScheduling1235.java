package com.shuatmd.leetcodetraining.Hard;

import java.util.Arrays;

//1235. 规划兼职工作
//你打算利用空闲时间来做兼职工作赚些零花钱。
//
//这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
//
//给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
//
//注意，时间上出现重叠的 2 份工作不能同时进行。
//
//如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
public class JobScheduling1235 {
    //官方解法:dp + 二分查找
    class Job {
        private int startTime;
        private int endTime;
        private int profit;

        Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        //按照结束顺序从小到大进行排列
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);
        //初始化dp数组
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            int currProfit = jobs[i].profit;
            int index = binarySearch(jobs, i);
            if (index != -1) {
                currProfit += dp[index];
            }
            //转换方程： dp[i] = Math.max(dp[i-1],dp[k] + profit[i])
            //如果不选当前job[i] 最高的收益是dp[i-1]
            //如果选择当前job[i] 最高的收益是最后一个endTime小于当前startTime的job对应的dp[k] + job[i].profit 当前job的profit
            dp[i] = Math.max(dp[i - 1], currProfit);
        }
        return dp[n - 1];
    }

    private int binarySearch(Job[] jobs, int i) {
        int left = 0;
        int right = i - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].endTime <= jobs[i].startTime) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
