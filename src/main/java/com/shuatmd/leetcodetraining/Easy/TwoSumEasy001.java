package com.shuatmd.leetcodetraining.Easy;
//1. 两数之和
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
//
//你可以按任意顺序返回答案。

import java.util.HashMap;
import java.util.Map;

public class TwoSumEasy001 {
    public static void main(String[] args) {
        TwoSumEasy001 test = new TwoSumEasy001();
        test.twoSum(new int[]{2,7,11,15},9);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> resMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(resMap.containsKey(nums[i])){
                return new int[]{resMap.get(nums[i]),i};
            }
            resMap.put(target - nums[i], i);
        }

        return new int[]{-1,-1};
    }
}
