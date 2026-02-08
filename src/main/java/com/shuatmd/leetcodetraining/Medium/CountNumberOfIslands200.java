package com.shuatmd.leetcodetraining.Medium;

//200. 岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
public class CountNumberOfIslands200 {
    //递归查找
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        //两层while逐步查找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当找到为1的点 开始dfs
                //只需递归知道不是岛位置
                //递归中间需要把遍历过得grid点重置为0 防止重复查找
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;


    }

    private void dfs(char[][] grid, int m, int n) {
        //终止条件 m,n越界或者当前点是0
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m - 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m + 1, n);
        dfs(grid, m, n + 1);
    }
}
