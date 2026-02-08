package com.shuatmd.leetcodetraining.Easy;

//69. x 的平方根
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5
public class FindSqrt069 {
    //官方解法1：二分法来做
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //left - 1 是最后一个满足 mid * mid <= x 的整数，也就是 √x 的整数部分
        return left - 1;
    }


}
