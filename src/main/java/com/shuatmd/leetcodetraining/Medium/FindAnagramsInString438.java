package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//438. 找到字符串中所有字母异位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
public class FindAnagramsInString438 {
    public static void main(String[] args) {
        FindAnagramsInString438 test = new FindAnagramsInString438();
        test.findAnagrams("abab","ab");
    }
    //手搓尝试：因为p是固定长度 可以考虑用定长滑动窗口来做
    public List<Integer> findAnagrams(String s, String p) {
        int lenP = p.length();
        int lenS = s.length();
        if (lenP == 0 || lenS == 0 || lenS < lenP) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] wordCount = new int[128];
        int[] currCount = new int[128];
        //记录p的每个单词出现次数
        for (char c : p.toCharArray()) {
            wordCount[c - 'a']++;
        }
        for (int i = 0; i < lenP; i++) {
            currCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(wordCount, currCount)) {
            res.add(0);
        }
        for (int i = 1; i < lenS - lenP + 1; i++) {
            currCount[s.charAt(i - 1) - 'a']--;
            currCount[s.charAt(lenP - 1 + i) - 'a']++;
            if (Arrays.equals(wordCount, currCount)) {
                res.add(i);
            }
        }
        return res;
    }
}
