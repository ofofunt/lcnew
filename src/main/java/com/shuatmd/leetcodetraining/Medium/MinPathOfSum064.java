package com.shuatmd.leetcodetraining.Medium;

//64. 最小路径和
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
public class MinPathOfSum064 {
    //官方解法1：dp
    //设dp[i][j]为空格内到[i][j]这个点的最小路径的和
    //根据题意 到达[i][j]这个点只能从左边 或者上方到达
    //则可以推出公式
    //dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j])
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        int horSum = 0;
        int[][] dp = new int[m][n];
        //初始化第一竖行
        for (int i = 0; i < m; i++) {
            horSum += grid[i][0];
            dp[i][0] = horSum;
        }
        //初始化第一列
        int verSum = 0;
        for (int i = 0; i < n; i++) {
            verSum += grid[0][i];
            dp[0][i] = verSum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
