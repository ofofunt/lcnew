package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
public class SumOfThree0015 {
    public static void main(String[] args) {
        SumOfThree0015 test = new SumOfThree0015();
        test.threeSum(new int[]{1, 2, -2, -1});
    }

    public List<List<Integer>> threeSumOfficial(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int right;
        for (int i = 0; i < nums.length; i++) {
            right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                while (right > j && nums[i] + nums[j] + nums[right] > 0) {
                    right--;
                }
                if (right == j) {
                    break;
                }
                if (right != j && nums[i] + nums[j] + nums[right] == 0) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[right]);
                    res.add(curr);
                }
            }
        }
        return res;
    }

    //手搓解法1：sort之后左右移动指针来进行匹配
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int right = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            right = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (j > i + 1 && j < nums.length - 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (right <= j) {
                    break;
                }
                while (nums[i] + nums[j] + nums[right] > 0 && right > j + 1) {
                    right--;
                }
                if (nums[i] + nums[j] + nums[right] == 0) {
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(nums[j]);
                    curRes.add(nums[right]);
                    res.add(curRes);
                }
            }
        }
        return res;
    }
}
