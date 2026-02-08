package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//438. 找到字符串中所有字母异位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
public class FindAnagrams438 {
    public static void main(String[] args) {
        FindAnagrams438 test = new FindAnagrams438();
        test.findAnagramsOfficial("baa","aa");
    }
    //官方题解：
    //双指针 + 数组对比
    //写法更优雅
    public List<Integer> findAnagramsOfficial(String s, String p){
        int n = p.length();
        if(s.length() < n){
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        //因为只需要记26个字母 所以用数组就乐意
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCount,pCount)){
            resList.add(0);
        }
        for (int i = 0; i < s.length() - n; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + n) - 'a']++;
            if(Arrays.equals(sCount,pCount)){
                resList.add(i + 1);
            }
        }
        return resList;
    }
    public List<Integer> findAnagramsAdvanced(String s, String p) {
        //设置滑动窗口大小
        int n = p.length();
        List<Integer> resList = new ArrayList<>();
        if (s.length() < n) {
            return resList;
        }
        int start = 0;
        int end = n - 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> curMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            curMap.put(s.charAt(i), curMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        while (start < s.length() && end < s.length()) {
            curMap.put(s.charAt(end),curMap.getOrDefault(s.charAt(end),0) + 1);
            if (curMap.equals(map)) {
                resList.add(start);
            }
            //需要注意，移动指针的时候删除记录
            //如果左指针指向的字母只出现一次，需要完全删除
            //如果出现多次则删除一次
            if(curMap.get(s.charAt(start)) > 1){
                curMap.put(s.charAt(start),curMap.get(s.charAt(start)) - 1);
            }
            else{
                curMap.remove(s.charAt(start));
            }
            start++;
            end++;
        }
        return resList;
    }
    //手搓解法：滑动窗口
    //超时：在构建map的时候可以优化
    public List<Integer> findAnagrams(String s, String p) {
        //设置滑动窗口大小
        int n = p.length();
        List<Integer> resList = new ArrayList<>();
        if (s.length() < n) {
            return resList;
        }
        int start = 0;
        int end =  n - 1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while (start < s.length() && end < s.length()) {
            Map<Character, Integer> curMap = new HashMap<>();
            for (int i = start; i <= end; i++) {
                curMap.put(s.charAt(i), curMap.getOrDefault(s.charAt(i), 0) + 1);
            }
            if(curMap.equals(map)){
                resList.add(start);
            }
            start++;
            end++;
        }
        return resList;
    }
}
