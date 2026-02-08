package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//242. 有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
public class IsAnagram0242 {
    public boolean isAnagram(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if(lengthS!=lengthT){
            return false;
        }
        int[] wordCountS = new int[128];
        int[] wordCountT = new int[128];
        for (int i = 0; i < lengthS; i++) {
            wordCountS[s.charAt(i) - 'a']++;
            wordCountT[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(wordCountS,wordCountT);

    }
}
