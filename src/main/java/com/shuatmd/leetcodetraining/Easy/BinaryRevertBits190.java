package com.shuatmd.leetcodetraining.Easy;
//190. 颠倒二进制位
//颠倒给定的 32 位有符号整数的二进制位。
public class BinaryRevertBits190 {
    //官方解法：位运算
    public int reverseBits(int n) {
        int rev = 0;
        //因为i最多为32位 所以最多执行32次,如果n已经等于0则跳过
        for (int i = 0; i < 32 && n != 0; ++i) {
            //通过n & 1来找到当前数的最后一位
            //|= 是“按位或并赋值”操作。
            //rev |= (n & 1) << (31 - i) 是直接把n的最后一位倒序放到第i位
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;

    }
}
