package com.shuatmd.leetcodetraining.Medium;
//59. 螺旋矩阵 II
//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

public class RotatingMatrixII059 {
    public static void main(String[] args) {
        RotatingMatrixII059 test = new RotatingMatrixII059();
        test.generateMatrix(3);
    }
    //手搓解法：模拟操作
    //首先初始化一下方向
    int[] dx = new int[]{1, 0, -1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int[][] generateMatrix(int n) {
        int val = 0;
        int[][] res = new int[n][n];
        int currX = -1;
        int currY = 0;
        int currDirection = 0;
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                val++;
                int nextY = currY + dy[currDirection];
                int nextX = currX + dx[currDirection];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n &&
                        !isVisited[nextY][nextX]) {
                    currX = nextX;
                    currY = nextY;
                } else {
                    currDirection += 1;
                    currDirection %= 4;
                    currY = currY + dy[currDirection];
                    currX = currX + dx[currDirection];
                }
                res[currY][currX] = val;
                isVisited[currY][currX] = true;
            }
        }
        return res;
    }
}
