package com.shuatmd.leetcodetraining.Easy;

//125.验证回文串
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
//字母和数字都属于字母数字字符。
//
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
public class IsPalindromeString125 {
    //手搓解法：先处理string
    public boolean isPalindrome(String s) {
        String trim = s.trim().toLowerCase();
        int length = trim.length();
        if (trim.length() == 0) {
            return true;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            while (!Character.isLetterOrDigit(trim.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(trim.charAt(right)) && left < right) {
                right--;
            }
            if (left < right) {
                if (trim.charAt(left) != trim.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
