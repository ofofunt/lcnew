package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//78. 子集
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
public class AllSubsets078 {
    public static void main(String[] args) {
        AllSubsets078 test = new AllSubsets078();
        test.subsets(new int[]{1, 2, 3});
    }

    List<List<Integer>> resSet;

    //手搓解法：尝试用回溯做
    public List<List<Integer>> subsets(int[] nums) {
        this.resSet = new ArrayList<>();
        int n = nums.length;
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, currList, n, 0);
        return resSet;
    }

    private void backtrack(int[] nums, List<Integer> currList, int n, int start) {
        if (currList.size() <= n) {
            resSet.add(new ArrayList<>(currList));
        }
        if (currList.size() == n) {
            return;
        }
        for (int i = start; i < n; i++) {

            int cur = nums[i];
            currList.add(cur);
            backtrack(nums, currList, n, i + 1);
            currList.remove(currList.size() - 1);
        }
    }
}
