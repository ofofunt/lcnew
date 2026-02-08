package com.shuatmd.leetcodetraining.Hard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//76. 最小覆盖子串
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
//注意：
//
//对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。
public class MinConveringSubstring076 {
    public static void main(String[] args) {
        MinConveringSubstring076 test = new MinConveringSubstring076();
        test.minWindow2("ADOBECODEBANC","ABC");
    }
    //手搓解法2：
    //尝试在扫描过程中滑动窗口 更类似于双指针？
    public String minWindow2(String s, String t) {
        int n = t.length();
        int length = s.length();
        if (length < n) {
            return new String();
        }
        //设置好基准map，需要用它来比较
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = -1;
        int minSize = Integer.MAX_VALUE;
        Map<Character, Integer> stringMap = new HashMap<>();
        int resLeft = -1;
        int resRight = -1;
        //从左到右扫描直到子串中的元素都符合
        while (right < length) {
            right++;
            if (right < length && wordMap.containsKey(s.charAt(right))) {
                stringMap.put(s.charAt(right), stringMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            //不能直接用.equals判断，因为可能出现s是ABBBA t是ABA的情况
            //判断成功，说明当前扫描到的子串已经包含了所有子串的字母，尝试从左边进行缩减
            while (left <= right && check(stringMap, wordMap)) {
                if (right - left + 1 < minSize) {
                    minSize = right - left + 1;
                    resLeft = left;
                    resRight = left + minSize;
                }
                if (wordMap.containsKey(s.charAt(left))) {
                    stringMap.put(s.charAt(left), stringMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return resLeft < 0 ? "" : s.substring(resLeft, resRight);

    }

    private boolean check(Map<Character, Integer> stringMap, Map<Character, Integer> wordMap) {
        Iterator<Map.Entry<Character, Integer>> iterator = wordMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer val = next.getValue();
            if (stringMap.getOrDefault(key,0) < val) {
                return false;
            }
        }
        return true;
    }


    //手搓解法：
    //从左扫描到右 然后逐步缩小window
    //因为存在唯一解 所以可能可以？
    //行不通 扫出来并不一定是最短解
    public String minWindow(String s, String t) {
        int n = t.length();
        int length = s.length();
        if (length < n) {
            return new String();
        }
        //设置好基准map，需要用它来比较
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }
        int right = 0;
        Map<Character, Integer> stringMap = new HashMap<>();
        //从左到右扫描直到子串中的元素都符合
        while (right < length) {
            char cur = s.charAt(right);
            if (wordMap.containsKey(cur)) {
                stringMap.put(cur, stringMap.getOrDefault(cur, 0) + 1);
            }
            if (wordMap.equals(stringMap)) {
                break;
            }
            right++;
        }
        int left = 0;
        while (left < length) {
            char cur = s.charAt(left);
            //if (wordMap.)
        }
        return "";
    }
}
