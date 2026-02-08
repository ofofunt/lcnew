package com.shuatmd.leetcodetraining.Medium;

//62. 不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//问总共有多少条不同的路径？
public class DifferentPathsToEnd062 {
    //手搓解法：dp
    //设dp[i][j]为到达[i][j]这个点的所有可行路线的和
    //因为可以从上方或者左方到达
    //dp[i][j] = dp[i -1][j] + dp[i][j-1];
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        int[][] dp = new int[m][n];
        //初始化数组
        for (int i = 0; i < m; i++) {
            dp[m][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][n] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
