package com.shuatmd.leetcodetraining.Easy;
//383. 赎金信

import java.util.HashMap;
import java.util.Map;

//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
public class CanConstructRansomNote383 {
    public static void main(String[] args) {
        CanConstructRansomNote383 test = new CanConstructRansomNote383();
        test.canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj");
    }

    //官方解法1： 字符统计 但是用array
    public boolean canConstructOfficial(String ransomNote, String magazine) {
        int[] wordCount = new int[26];
        for (char c : magazine.toCharArray()) {
            wordCount[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (wordCount[c - 'a'] <= 0) {
                return false;
            }
            wordCount[c - 'a']--;
        }
        return true;
    }

    //手搓解法：两个for有点过于复杂
    //HashMap太慢 应该用Array
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> wordCountMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            wordCountMap.put(c, wordCountMap.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!wordCountMap.containsKey(c) || wordCountMap.get(c) < 1) {
                return false;
            }
            wordCountMap.put(c, wordCountMap.get(c) - 1);
        }
        return true;
    }
}
