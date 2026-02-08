package com.shuatmd.leetcodetraining.Easy;

//409. 最长回文串
//给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的 回文串 的长度。
//
//在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        int[] wordCount = new int[128];
        for (char c : s.toCharArray()) {
            wordCount[c]++;
        }
        int res = 0;
        boolean hasEven = false;
        int evenDigit = 0;
        for (int i = 0; i < wordCount.length; i++) {
            //偶数全部可以计入结果中
            if (wordCount[i] % 2 == 0) {
                res += wordCount[i];
            }
            //奇数可以计入-1个到结果中
            else {
                res += wordCount[i]  - 1;
                hasEven = true;
            }
        }
        return  hasEven?res + 1 : res;

    }
}
