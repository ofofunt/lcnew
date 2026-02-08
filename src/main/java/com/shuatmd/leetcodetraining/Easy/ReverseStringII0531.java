package com.shuatmd.leetcodetraining.Easy;
//541. 反转字符串 II
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//如果剩余字符少于 k 个，则将剩余字符全部反转。
//如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
public class ReverseStringII0531 {
    public static void main(String[] args) {
        ReverseStringII0531 test = new ReverseStringII0531();
        test.reverseStr("abcdefg",2);
    }
    //间隔2k次循环一次双指针
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int n = a.length;
        for (int i = 0; i < n; i += 2 * k) {
            int l = i, r = Math.min(i + k - 1, n - 1);
            while (l < r) {
                char t = a[l]; a[l] = a[r]; a[r] = t;
                l++; r--;
            }
        }
        return new String(a);
    }

}
