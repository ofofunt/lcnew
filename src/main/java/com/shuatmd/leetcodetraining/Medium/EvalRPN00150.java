package com.shuatmd.leetcodetraining.Medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
//
//请你计算该表达式。返回一个表示表达式值的整数。
//有效的算符为 '+'、'-'、'*' 和 '/' 。
//每个操作数（运算对象）都可以是一个整数或者另一个表达式。
//两个整数之间的除法总是 向零截断 。
//表达式中不含除零运算。
//输入是一个根据逆波兰表示法表示的算术表达式。
//答案及所有中间计算结果可以用 32 位 整数表示。
public class EvalRPN00150 {
    public static void main(String[] args) {
        EvalRPN00150 test = new EvalRPN00150();
        test.evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }

    //用栈来实现计算
    //改进方案 可以直接用一个Integer Stack避免互转
    //最后直接返回stack.pop()防止只有数字没有符号的情况
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        Set<String> signs = new HashSet<>();
        signs.add("-");
        signs.add("+");
        signs.add("*");
        signs.add("/");
        int curRes = 0;
        for (String token : tokens) {
            if (signs.contains(token)) {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    curRes = num1 + num2;
                } else if (token.equals("-")) {
                    curRes = num1 - num2;
                } else if (token.equals("*")) {
                    curRes = num1 * num2;
                } else if (token.equals("/")) {
                    curRes = num1 / num2;
                }
                stack.push(curRes);
            } else {
                stack.push(Integer.valueOf(token));
            }

        }
        return stack.pop();
    }
}
