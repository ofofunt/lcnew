package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//3. 无重复字符的最长子串
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
public class LongestSubStringWODuplicate003 {
    public static void main(String[] args) {
        LongestSubStringWODuplicate003 test = new LongestSubStringWODuplicate003();
        test.lengthOfLongestSubstring("tmmzuxt");
    }
    //官方解法：滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        int right = -1;
        int res = 0;
        Set<Character> wordSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(i!= 0){
                wordSet.remove(s.charAt(i - 1));
            }
            while(right +1 < s.length() && !wordSet.contains(s.charAt(right + 1))){
                wordSet.add(s.charAt(right + 1));
                right++;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }
    //手搓解法1： 出现除非则从重复之后的字符开始重新计算
    //会超时
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> wordMap = new HashMap<>();
        if (s.length() < 2) {
            return s.length();
        }
        //初始化部分
        int res = 0;
        wordMap.put(s.charAt(0), 0);
        int currCount = 1;
        for (int i = 1; i < s.toCharArray().length; i++) {
            //当没有相同单词时,自增currCount
            if (!wordMap.containsKey(s.charAt(i))) {
                currCount++;
                wordMap.put(s.charAt(i), i);
            } else {
                int index = wordMap.get(s.charAt(i));
                i = index;
                currCount = 0;
                wordMap = new HashMap<>();
            }
            res = Math.max(res, currCount);
        }
        return res;
    }
}
