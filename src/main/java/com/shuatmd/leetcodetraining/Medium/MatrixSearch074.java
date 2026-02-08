package com.shuatmd.leetcodetraining.Medium;

//74. 搜索二维矩阵
//给你一个满足下述两条属性的 m x n 整数矩阵：
//
//每行中的整数从左到右按非严格递增顺序排列。
//每行的第一个整数大于前一行的最后一个整数。
//给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
public class MatrixSearch074 {
    //从右上角或者左下角开始 左边一定比他小 下边一定比他大 以此来二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix.length;
        int length = matrix[0].length;
        int i = 0;
        int j = length - 1;
        while (i < width && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }
}
