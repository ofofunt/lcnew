package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.Map;

//205. 同构字符串
//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
//如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
//每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身
public class IsIsomorphic205 {
    public static void main(String[] args) {
        IsIsomorphic205 test = new IsIsomorphic205();
        test.isIsomorphicHashMap("badc", "baba");
    }

    //官方解法：直接逐位判断
    public boolean isIsomorphicHashMapOfficial(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if ((sMap.containsKey(x) && sMap.get(x) != y) || (tMap.containsKey(y) && tMap.get(y) != x)) {
                return false;
            }
            sMap.put(x, y);
            tMap.put(y, x);
        }
        return true;
    }

    //手搓解法3：可行但是太太慢了
    public boolean isIsomorphicHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sNumeric = 0;
        int tNumeric = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            sNumeric += sMap.getOrDefault(s.charAt(i), i + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), i) + 1);
            sNumeric *= 10;
            tNumeric += tMap.getOrDefault(t.charAt(i), i + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), i) + 1);
            tNumeric *= 10;
        }
        return sNumeric == tNumeric;
    }

    //因为输入为所有的ASCII字符 不是只有大小写字母 所以最好换hashMap
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int sNumeric = 0;
        int tNumeric = 0;
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (cntS[s.charAt(i) - 'a'] == 0) {
                cntS[s.charAt(i) - 'a'] = i + 1;
                sNumeric += i + 1;
            } else {
                sNumeric += cntS[s.charAt(i) - 'a'];
            }
            sNumeric *= 10;
            if (cntT[t.charAt(i) - 'a'] == 0) {
                cntT[t.charAt(i) - 'a'] = i + 1;
                tNumeric += i + 1;
            } else {
                tNumeric += cntT[t.charAt(i) - 'a'];
            }
            tNumeric *= 10;
        }
        return sNumeric == tNumeric;
    }

    //手搓解法1：
    //尝试用记录次数来反向表达string
    //会出错，因为会出现同样次数的例子 如"bbbaaaba" "aaabbbba"
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charS = new int[26];
        int[] charT = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            charS[s.charAt(i) - 'a']++;
            charT[t.charAt(i) - 'a']++;
        }
        StringBuffer ssb = new StringBuffer();
        StringBuffer tsb = new StringBuffer();
        for (int i = 0; i < s.toCharArray().length; i++) {
            ssb.append(charS[s.charAt(i) - 'a']);
            tsb.append(charT[t.charAt(i) - 'a']);
        }
        return ssb.toString().equals(tsb.toString());
    }
}
