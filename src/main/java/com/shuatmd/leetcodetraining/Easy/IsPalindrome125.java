package com.shuatmd.leetcodetraining.Easy;

//125. 验证回文串
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
//字母和数字都属于字母数字字符。
//
//给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
public class IsPalindrome125 {
    public static void main(String[] args) {
        IsPalindrome125 palindrome = new IsPalindrome125();
        palindrome.isPalindrome("A man, a plan, a canal: Panama");

    }

    //官方解法：
    //放弃使用正则,直接用while来判断
    public boolean isPalindromeOfficial(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    //手搓解法：通过正则+toLower将整个字符串标准化
    //然后双指针对比
    public boolean isPalindrome(String s) {
        String raw = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = raw.length() - 1;
        while (left < right) {
            if (raw.charAt(left) != raw.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
