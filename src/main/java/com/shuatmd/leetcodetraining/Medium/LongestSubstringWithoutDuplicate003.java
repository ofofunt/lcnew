package com.shuatmd.leetcodetraining.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutDuplicate003 {
    public static void main(String[] args) {
        LongestSubstringWithoutDuplicate003 test = new LongestSubstringWithoutDuplicate003();
        test.lengthOfLongestSubstring("abcabcbb");
    }

    //官方解法：
    //滑动窗口 + hashset判断
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        Set<Character> checkSet = new HashSet<>();
        checkSet.add(chars[0]);
        int count = 0;
        while (start < n) {
            while (end < n && checkSet.add(chars[end])) {
                end++;
            }
            count = Math.max(count, end - start);
            checkSet.remove(chars[start]);
            start++;
        }
        return count;
    }
}
