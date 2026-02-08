package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1002. 查找共用字符
//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
public class CommonChars1002 {
    public List<String> commonChars(String[] words) {
        int len = words.length;
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; i++) {
                freq[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(freq[i], minFreq[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
