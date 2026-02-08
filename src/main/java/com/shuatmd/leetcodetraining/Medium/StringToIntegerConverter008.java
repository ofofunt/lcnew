package com.shuatmd.leetcodetraining.Medium;

//8. 字符串转换整数 (atoi)
//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。
//
//函数 myAtoi(string s) 的算法如下：
//
//空格：读入字符串并丢弃无用的前导空格（" "）
//符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
//转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
//舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
//返回整数作为最终结果。
public class StringToIntegerConverter008 {
    //官方解法：主要结局4个问题就好
    public int myAtoi(String s) {
        //使用trim解决第一个可能出现的空格问题
        char[] chars = s.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        int sign = 1;
        int i = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            //如果第一位之后遇到非数字则直接返回
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if (res > boundary || res == boundary && chars[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return sign * res;
    }
}

