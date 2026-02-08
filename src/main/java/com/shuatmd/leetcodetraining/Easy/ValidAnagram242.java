package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//242. 有效的字母异位词
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
public class ValidAnagram242 {
    //手搓解法2：尝试array来做
    public boolean isAnagramArray(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] wordCountS = new int[26];
        int[] wordCountT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            wordCountS[s.charAt(i) - 'a'] ++;
            wordCountT[t.charAt(i) - 'a'] ++;
        }
        return Arrays.equals(wordCountS,wordCountT);

    }
    //手搓解法：hashMap存字母出现次数判断？
    //有点慢了 尝试下别的写法
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> wordCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            wordCount.put(c,wordCount.getOrDefault(c,0) + 1);
        }
        for (char c : t.toCharArray()) {
            if(!wordCount.containsKey(c) || wordCount.get(c) == 0){
                return false;
            }
            wordCount.put(c,wordCount.get(c) - 1);
        }
        Set<Character> keySet = wordCount.keySet();
        for (Character character : keySet) {
            if(wordCount.get(character)!=0){
                return false;
            }
        }
        return true;
    }
}
