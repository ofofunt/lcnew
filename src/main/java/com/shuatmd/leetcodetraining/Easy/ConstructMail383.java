package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//383. 赎金信
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
public class ConstructMail383 {
    public static void main(String[] args) {
        ConstructMail383 test = new ConstructMail383();
        test.canConstruct2("aa","aab");
    }
    //官方解法：数组统计字符出现次数 + 判断
    //再第二个for循环做了优化 提前跳出
    public boolean canConstructOfficial(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }

    //手搓解法2：太慢了
    public boolean canConstruct2(String ransomNote, String magazine) {
        int cnt = ransomNote.length();
        char[] chars = ransomNote.toCharArray();
        for (char c : magazine.toCharArray()) {
            if(ransomNote.indexOf(c) >= 0){
                chars[ransomNote.indexOf(c)] = 'A';
                cnt --;
                ransomNote = String.copyValueOf(chars);
            }
        }
        return cnt <= 0;
    }
    //手搓解法1：数组统计字数然后求和看看是否为0
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if(cnt[c - 'a'] > 0){
                cnt[c - 'a']--;
            }
        }
        return Arrays.stream(cnt).sum() == 0? true:false;

    }
}
