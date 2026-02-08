package com.shuatmd.leetcodetraining.Hard;

//76. 最小覆盖子串
//给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
//
//测试用例保证答案唯一。
public class MiniumCovertingSubstring076 {
    public String minWindow(String s, String t) {
        int length = s.length();
        int targetLen = t.length();
        int[] cnt = new int[128];
        int totalCnt = targetLen;
        for (char c : t.toCharArray()) {
            cnt[c - 'a']++;
        }
        int minLength = length + 1;
        int left = 0;
        int start = 0;
        for (int right = 0; right < length; right++) {
            if (cnt[s.charAt(right) - 'A'] > 0) {
                totalCnt--;
            }
            cnt[s.charAt(right) - 'A']--;
            while (totalCnt == 0) {
                int tmp = right - left;
                if (tmp < minLength) {
                    start = left;
                    minLength = right - left;
                }
                cnt[s.charAt(left) - 'A']++;
                if (cnt[s.charAt(left) - 'A'] > 0) {
                    totalCnt++;
                }
                left++;
            }

        }
        return minLength == length + 1 ? "" : s.substring(start, start + minLength + 1);
    }
}
