package com.shuatmd.leetcodetraining.Medium;

//151. 反转字符串中的单词
//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
//注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
public class ReverseWords00151 {
    public static void main(String[] args) {
        ReverseWords00151 test = new ReverseWords00151();
        test.reverseWords("the sky is blue");
    }

    //双指针 + 后往前
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int lastIndex = s.length() - 1;
        int firstIndex = s.length() - 1;
        while (firstIndex >= 0) {
            while (firstIndex >= 0 && s.charAt(firstIndex) != ' ') {
                firstIndex--;
            }
            sb.append(s.substring(firstIndex + 1, lastIndex + 1) + " ");
            while (firstIndex >= 0 && s.charAt(firstIndex) == ' ') {
                firstIndex--;
            }
            lastIndex = firstIndex;
        }
        return sb.toString().trim();
    }
}
