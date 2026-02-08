package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//128. 最长连续序列
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
public class LongestConsecutiveIntArray128 {
    //官方解法：HashSet
    public int longestConsecutiveOfficial(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            //如果没有num - 1 说明他可能是连续子数列的开头
            if(!set.contains(num - 1)){
                int currNum = num;
                int currentStreak = 1;
                while(set.contains(currNum + 1)){
                    currentStreak++;
                    currNum++;
                }
                res = Math.max(currentStreak,res);
            }
        }
        return res;

    }
    //手搓想法：sort，然后吧当前数字+1作为key 1作为value放入
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        //记得判断空以及只有1个数字的array的情况
        if(nums.length < 2){
            return nums.length;
        }
        int maxCnt = 1;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            if (!cntMap.containsKey(num)) {
                cntMap.put(num + 1, 1);
            }
            else{
                int currCnt = cntMap.get(num) + 1;
                cntMap.put(num + 1, currCnt);
                maxCnt = Math.max(maxCnt,currCnt);
            }

        }
        return maxCnt;
    }
}
