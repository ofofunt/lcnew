package com.shuatmd.leetcodetraining.Hard;

import java.util.Deque;
import java.util.LinkedList;

//32. 最长有效括号
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。
//
//左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
public class LongestValidParenthesesCount032 {
    public static void main(String[] args) {
        LongestValidParenthesesCount032 test = new LongestValidParenthesesCount032();
        test.longestValidParenthesesMimic("(()");
    }
    //官方解法1：模拟
    //首先stack遍历 记录下能构成封闭括号的节点
    //记录下封闭部分的index 标记为1
    //统计整个array中连续1的部分
    public int longestValidParenthesesMimic(String s) {
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int[] arr = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if('(' == chars[i]){
                stack.push(i);
            }
            else if(')' == chars[i] && !stack.isEmpty()){
                arr[stack.pop()] = 1;
                arr[i] = 1;
            }
        }
        int curCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(1 == arr[i]){
                curCount++;
                res = Math.max(res,curCount);
            }
            else{
                curCount = 0;
            }
        }
        return res;
    }
    //手搓尝试1：stack遍历
    //尝试失败：无法记录失败的情况 比如()(()
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (')' == chars[i]) {
                if (stack.size() == 0) {
                    res = Math.max(res, cur);
                    cur = 0;
                } else if ('(' == stack.peek()) {
                    cur++;
                    stack.pop();
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return res*2;
    }

}
