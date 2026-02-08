package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//242. 有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
public class IsAnagram242 {
    //官方邪道解法：直接排序
    public boolean isAnagramOfficial(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    //因为都是大小写字母所以直接用array
    //手搓解法 array记录
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] cnt = new int[128];
        if (sLen != tLen) {
            return false;
        }
        for (int i = 0; i < sLen; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < sLen; i++) {
            if (cnt[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            cnt[t.charAt(i) - 'a']--;
        }
        return true;

    }
}
