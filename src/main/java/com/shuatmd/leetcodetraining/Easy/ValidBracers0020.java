package com.shuatmd.leetcodetraining.Easy;

import java.util.*;

//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。
public class ValidBracers0020 {
    public static void main(String[] args) {
        ValidBracers0020 test = new ValidBracers0020();
        test.isValid("([])");
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Set<Character> keySet = map.keySet();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (keySet.contains(c)) {
                if (stack.isEmpty() || stack.pop() != map.getOrDefault(c, ' ')) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
