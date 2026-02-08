package com.shuatmd.leetcodetraining.Easy;

//191.位1的个数
//给定一个正整数 n，编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。
public class HammingWeight191 {
    //简单解法1：观察这个运算：n & (n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果
    //在实际代码中，我们不断让当前的 n 与 n−1 做与运算，直到 n 变为 0 即可
    public int hammingWeightOfficial(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    //普通解法1：无限数最后一位的1 + 进位

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
