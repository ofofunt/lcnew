package com.shuatmd.leetcodetraining.Medium;
//130. 被围绕的区域
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
//
//连接：一个单元格与水平或垂直方向上相邻的单元格连接。
//区域：连接所有 'O' 的单元格来形成一个区域。
//围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
//通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。

public class FindSurrondingArea130 {
    //官方解法1：递归
    //需要先从4个边缘开始标记
    //将与边缘相连的O标记为A
    //之后进行遍历 如果不是与边缘O相连 则一定为被包围的部分
    public void solveOfficial(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            //递归左右部分的边缘
            dfs(board, i, 0);
            dfs(board, i, n - 1);

        }
        for (int i = 1; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }

        }
    }

    //手搓方法1：递归
    //错误 无法判断被边缘部分包围的O
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, m, n);
                }
            }
        }

    }

    private void dfs(char[][] board, int m, int n) {
        if (m < 0 || n < 0 || m >= board.length || n >= board[0].length || board[m][n] != 'O') {
            return;
        }
        //对于和边缘部分O相邻的O暂时改成A
        board[m][n] = 'A';
        dfs(board, m - 1, n);
        dfs(board, m, n - 1);
        dfs(board, m + 1, n);
        dfs(board, m, n + 1);
    }
}
