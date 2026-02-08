package com.shuatmd.leetcodetraining.Medium;
//459. 重复的子字符串
//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。

public class RepeatedSubStringPattern0459 {
    public boolean repeatedSubstringPattern(String s) {
       return (s + s).indexOf(s,1) != s.length();
    }
}
