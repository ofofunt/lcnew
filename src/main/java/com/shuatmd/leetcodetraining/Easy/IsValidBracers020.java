package com.shuatmd.leetcodetraining.Easy;
//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValidBracers020 {
    public static void main(String[] args) {
        IsValidBracers020 test = new IsValidBracers020();
        test.isValidOfficial("(]");
    }

    //官方解法：用栈解决
    //碰到右括号 则检查是否与栈顶相等 不等则return false
    //一直遍历完 如果全部相等则为true
    public boolean isValidOfficial(String s) {
        int length = s.length();
        if (length < 2 || length % 2 > 0) {
            return false;
        }
        //用map来表示映射关系
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            //如果map中存在当前char 则表明当前char为反括号
            if (map.containsKey(c)) {
                //如果当前为反括号 需要检查栈顶是否为空 以及栈顶元素和他是否为正反括号
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                //如果没问题,则把栈顶移除
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        //最后任然需要检查stack是否为空
        return stack.isEmpty();
    }


    //手搓解法：双指针 一左一右 确保当前点一致
    //考虑不全 可能存在{}()[]的情况
    //需要map来做对应关系 不能直接==
    public boolean isValid(String s) {
        int length = s.length();
        if (length < 2 || length % 2 > 0) {
            return false;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
