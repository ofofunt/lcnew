package com.shuatmd.leetcodetraining.Easy;
//66. 加一
//给定一个表示 大整数 的整数数组 digits，其中 digits[i] 是整数的第 i 位数字。这些数字按从左到右，从最高位到最低位排列。这个大整数不包含任何前导 0。
//
//将大整数加 1，并返回结果的数字数组。
public class AddOne066 {
    public static void main(String[] args) {
        AddOne066 test = new AddOne066();
        test.plusOneOfficial(new int[]{0});
    }
    //官方解法1：倒序查找 找到第一个不为9的位 然后+1
    //如果数组全为9 则new一个length+1的心数组
    public int[] plusOneOfficial(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //如果当前尾数为9 则变为0
            if(digits[i] == 9){
                digits[i] = 0;
            }
            //找到第一个不为9的尾数 +1后直接return
            else{
                digits[i] +=1;
                return digits;
            }
        }
        //如果循环走完都没return 说明所有数都是9
        //需要return一个新的1开头 length+1的数组
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    //简单解法1： 模拟
    //没法通过 int会过大
    public int[] plusOne(int[] digits) {
        int curr = 0;
        for (int i = 0; i < digits.length; i++) {
            curr *= 10;
            curr += digits[i];
        }
        curr = curr + 1;
        String s = String.valueOf(curr);
        int length = s.length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;

    }
}
