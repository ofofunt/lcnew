package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//151. 反转字符串中的单词
//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//
//返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//
//注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
public class ReverseWords151 {
    public static void main(String[] args) {
        ReverseWords151 reverseWords = new ReverseWords151();
        reverseWords.reverseWordsTwoPointer("a good   example");
        reverseWords.reverseWords("  hello world  ");
    }

    //民间解法：
    //双指针记录每个单词 然后倒序拼接
    public String reverseWordsTwoPointer(String s) {
        //用s.trim()可以节约很多步骤 但是这边先考虑不让用trim的情况
        int m = s.length() - 1;
        StringBuffer sb = new StringBuffer();
        //首先去掉右边多余的0
        while (' ' == s.charAt(m) && m > 0) {
            m--;
        }
        int n = m;
        //然后进行遍历
        while (m >= 0) {
            //先遍历找单词
            while (m >= 0 && s.charAt(m) != ' ') {
                m--;
            }
            sb.append(s.substring(m + 1, n + 1));
            sb.append(" ");
            //用while去掉左边的空格
            while (m >= 0 && s.charAt(m) == ' ') {
                m--;
            }
            if(m < 0){
                break;
            }
            n = m;
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);

    }

    //官方解法：
    //先spilt 然后 reverse 然后join
    public String reverseWordsOfficial(String s) {
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }

    //手搓解法： 先spilt成数组，然后倒序组装
    //缺点：可以直接用reverse然后join其实
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() > 0) {
                sb.append(s1[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

}
