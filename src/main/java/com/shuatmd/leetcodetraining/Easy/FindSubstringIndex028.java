package com.shuatmd.leetcodetraining.Easy;
//28. 找出字符串中第一个匹配项的下标

public class FindSubstringIndex028 {
    //朴素解法：
    //从每个index开始进行逐位匹配
    public int strStrSimple(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    //简单解法：直接用indexOf（）
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
