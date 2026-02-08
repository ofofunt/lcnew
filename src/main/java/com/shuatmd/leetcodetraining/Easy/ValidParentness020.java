package com.shuatmd.leetcodetraining.Easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。
public class ValidParentness020 {
    //手搓解法：用栈判断
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        char[] words = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char word : words) {
            if (!map.keySet().contains(word)) {
                stack.push(word);
            } else {
                if (stack.isEmpty() || stack.peek() != map.get(word)) {
                    return false;
                }
                stack.pop();
            }
        }
        //最后判断需要判断stack是否为empty
        //不能直接返回true 因为有[[的情况
        return stack.isEmpty();
    }
}
