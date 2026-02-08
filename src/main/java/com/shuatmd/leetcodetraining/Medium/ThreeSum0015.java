package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//15. 三数之和
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
public class ThreeSum0015 {
    public static void main(String[] args) {
        ThreeSum0015 test = new ThreeSum0015();
        test.threeSum(new int[]{-100,-70,-60,110,120,130,160});
    }
    //排序后 + 双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right = nums.length - 1;
            if(i > 0 && nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j]==nums[j-1]){
                    continue;
                }

                while (right > j && nums[i] + nums[j] + nums[right] > 0) {
                    right--;
                }
                if(right == j){
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
}
