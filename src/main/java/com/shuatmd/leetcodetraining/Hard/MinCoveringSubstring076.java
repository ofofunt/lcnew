package com.shuatmd.leetcodetraining.Hard;

//76. 最小覆盖子串
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
public class MinCoveringSubstring076 {
    public static void main(String[] args) {
        MinCoveringSubstring076 test = new MinCoveringSubstring076();
        test.minWindow("ADOBECODEBANC", "ABC");
    }

    //手搓尝试：双指针 左右移动来达成最小的覆盖子串
    //通过int[] 和int count来记录当前是否满足覆盖子字符串t
    public String minWindow(String s, String t) {
        int len = s.length();
        int lenTarget = t.length();
        //排除极端情况
        if (len == 0 || len < lenTarget) {
            return "";
        }
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c - 'A']++;
        }
        //记录需要完成匹配的单词个数
        int needCount = lenTarget;
        int left = 0;
        int right = 0;
        int minLen = len + 1;
        //记录最小子串的起始index
        int start = 0;
        while (right < len) {
            char c = s.charAt(right);
            //如果count[c - 'a'] > 0 说明当前指向的char是target中的char
            //需要完成的count--
            if (count[c - 'A'] > 0) {
                needCount--;
            }
            count[c - 'A']--;
            right++;
            while (needCount == 0) {
                int temp = right - left;
                if (temp < minLen) {
                    minLen = temp;
                    start = left;
                }
                count[s.charAt(left) - 'A']++;
                //如果count[s.charAt(left) - 'a']++之后大于0
                //说明删除的是target中的字母,需要吧needCount++
                if (count[s.charAt(left) - 'A'] > 0) {
                    needCount++;
                }
                left++;
            }
        }
        return minLen == len + 1 ? "" : s.substring(start, start + minLen);

    }

}
