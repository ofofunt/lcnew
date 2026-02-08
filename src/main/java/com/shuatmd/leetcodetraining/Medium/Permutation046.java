package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//46. 全排列
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
public class Permutation046 {
    public static void main(String[] args) {
        Permutation046 test = new Permutation046();
        test.permute(new int[]{1, 2, 3});
    }
    //手搓解法：回溯 + set判断去重
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        permutation(nums, curr, res, set);
        return res;
    }

    private void permutation(int[] nums, List<Integer> curr, List<List<Integer>> res, Set<Integer> set) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            curr.add(nums[i]);
            permutation(nums, curr, res, set);
            curr.remove(curr.size() - 1);
            set.remove(i);
        }
    }
}
