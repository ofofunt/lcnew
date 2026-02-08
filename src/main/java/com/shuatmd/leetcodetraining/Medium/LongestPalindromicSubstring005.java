package com.shuatmd.leetcodetraining.Medium;
//5. 最长回文子串
//给你一个字符串 s，找到 s 中最长的 回文 子串。
public class LongestPalindromicSubstring005 {
    //官方解法：dp求解
    //用dp[i][j] 表示s.substring(i,j)是否为一个回文串
    //假设i == j 则分类讨论
    //如果j - i > 3 需要进一步判断dp[i+1][j-1]
    //否则则直接为true
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        //初始化dp部分
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        //开始递推
        for (int left = 2; left <= len; left++) {
            for (int i = 0; i < len; i++) {
                int j = left + i - 1;
                if(j >= len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }
                else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && j - i > maxLength){
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }
}
