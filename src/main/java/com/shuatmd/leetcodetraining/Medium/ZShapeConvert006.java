package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//6. Z 字形变换
//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);
public class ZShapeConvert006 {
    //官方解法：
    //模拟：简单来说是首先正序，遇到numsRow则倒序
    //然后当回到i = 0 则继续正序
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            sbList.get(i).append(c);
            if(i == 0 || i == numRows - 1){
                flag = -flag;
            }
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbList) {
            res.append(sb.toString());
        }
        return res.toString();
    }
}
