package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//22. 括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class GenerateParenthesis022 {
    private List<String> res;
    private List<String> parenthesis;

    char[] arr;
    int n;

    public static void main(String[] args) {
        GenerateParenthesis022 test = new GenerateParenthesis022();
        test.generateParenthesisAdvanced(3);
    }

    //官方解法2：高端回溯
    public List<String> generateParenthesisAdvanced(int n) {
        arr = new char[n*2];
        this.res = new ArrayList<>();
        this.n = n;
        backTracking(0,0);
        return res;
    }
    //运用array的特性，在会回溯中不断地修改以及覆盖array
    private void backTracking(int left , int right){
        if(left== right && right + left == n*2){
            res.add(new String(arr));
            return;
        }
        if(left < n){
            arr[left + right] = '(';
            backTracking(left+1, right);
        }
        if(right < left){
            arr[left + right] = ')';
            backTracking(left, right+1);
        }
    }


    //官方解法1： 回溯 + 剪枝
    public List<String> generateParenthesisOfficial(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> res) {
        if (pos == current.length) {
            if (valid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, res);
            current[pos] = ')';
            generateAll(current, pos + 1, res);
        }
    }


    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    //手搓解法1：回溯 + 记录左右括号之差 + 记录左右括号之和
    //可以有更简便的剪枝
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<String>();
        this.parenthesis = new ArrayList<>();
        parenthesis.add("(");
        parenthesis.add(")");
        recur(n, 0, 0, 0, new StringBuilder());
        return res;

    }

    private void recur(int n, int count, int leftCount, int diff, StringBuilder curr) {
        if (count > n * 2 || leftCount < 0) {
            return;
        }
        if (count == n * 2 && diff == 0) {
            res.add(curr.toString());
        }
        for (int i = 0; i < 2; i++) {
            if (leftCount < 0) {
                continue;
            }
            curr.append(parenthesis.get(i));
            if (i == 0) {
                recur(n, count + 1, leftCount + 1, diff + 1, curr);
            } else {
                recur(n, count + 1, leftCount - 1, diff - 1, curr);
            }
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
