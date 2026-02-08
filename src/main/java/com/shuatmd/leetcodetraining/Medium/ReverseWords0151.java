package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//151. 反转字符串中的单词
//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
//注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
public class ReverseWords0151 {
    public static void main(String[] args) {
        ReverseWords0151 test = new ReverseWords0151();
        test.reverseWords("the sky is blue");
    }

    //官方解法：双指针+直接倒序做
    public String reverseWordsOfiicial(String s) {
        s = s.trim();
        int length = s.length();
        StringBuilder res = new StringBuilder();
        int j = length - 1;
        int i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            res.append(s.substring(i + 1, j + 1));
            res.append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    //手搓解法：过于麻烦
    public String reverseWords(String s) {
        String trim = s.trim();
        int length = trim.length();
        if (length == 0) {
            return new String();
        }
        int start = 0;
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (trim.charAt(i) == ' ') {
                if (trim.charAt(i - 1) == ' ') {
                    start++;
                } else {
                    String currWord = trim.substring(start, i);
                    wordList.add(currWord);
                    start = i + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        wordList.add(trim.substring(start, length));
        for (int i = wordList.size() - 1; i >= 0; i--) {
            sb.append(wordList.get(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
