package com.shuatmd.leetcodetraining.Medium;

//63. 不同路径 II
//给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
//
//返回机器人能够到达右下角的不同路径数量。
//
//测试用例保证答案小于等于 2 * 109。
public class PathCountWithObstacles063 {
    //手搓解法：dp
    //因为题目中说了机器人只能想下或者向右移动
    //设置dp[i][j]为到达[i][j]点的不同路径的和
    //dp[i][j] = dp[i -1][j] + dp[i][j - 1]
    //如果当前点为障碍物 则设为0
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        //初始化dp数值
        //为竖行赋值,如果没有障碍就全赋值1
        //如果有障碍则剩下部分全部为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        //同理为横行赋值
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];

    }
}
