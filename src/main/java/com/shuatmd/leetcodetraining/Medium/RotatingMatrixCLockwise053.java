package com.shuatmd.leetcodetraining.Medium;
//54. 螺旋矩阵
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

import java.util.ArrayList;
import java.util.List;

public class RotatingMatrixCLockwise053 {
    //官方题解：模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //排除空的部分
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0;
        int column = 0;
        //提前把方向变量设置好
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0,-1},{-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + direction[directionIndex][0];
            int nextColumn = column + direction[directionIndex][1];
            if(nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1)%4;
            }
            row+= direction[directionIndex][0];
            column+= direction[directionIndex][1];
        }
        return res;

    }
}
