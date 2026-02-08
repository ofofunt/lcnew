package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class EvalCalculation150 {
    public static void main(String[] args) {
        EvalCalculation150 test = new EvalCalculation150();
        test.evalRPN(new String[]{"4","13","5","/","+"});
    }
    //手搓解法：辅助栈
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> signSet = new HashSet<>();
        signSet.add("+");
        signSet.add("-");
        signSet.add("*");
        signSet.add("/");
        int length = tokens.length;
        for (int i = 0; i < length; i++) {
            String curr = tokens[i];
            if (signSet.contains(curr)) {
                int a = stack.poll();
                int b = stack.poll();
                int result = 0;
                switch (curr) {
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(curr));
            }

        }
        return stack.poll();
    }
}
