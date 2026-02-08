package com.shuatmd.leetcodetraining.Medium;
//77. 组合
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//你可以按 任何顺序 返回答案。

import java.util.ArrayList;
import java.util.List;

public class Combination77 {
    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Combination77 test = new Combination77();
        test.combine(4, 2);
    }

    //官方解法：回溯 但是更优雅
    public List<List<Integer>> combineOfficial(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    private void getCombine(int n, int k, int start, List<Integer> currList) {
        if (k == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            currList.add(i);
            getCombine(n, k - 1, i + 1, currList);
            currList.remove(currList.size() - 1);
        }
    }


    //手搓解法：回溯
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recur(res, 1, 1, n, k, new ArrayList<Integer>());
        return res;
    }

    private void recur(List<List<Integer>> res, int index, int curr, int n, int k, List<Integer> currList) {
        if (index == k + 1) {
            //防止currList数据发生改动 直接添加一个新的备份
            res.add(new ArrayList<>(currList));
        }
        for (int i = curr; i <= n; i++) {
            currList.add(i);
            recur(res, index + 1, i + 1, n, k, currList);
            currList.remove(index - 1);
        }

    }
}
