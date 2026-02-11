package com.shuatmd.leetcodetraining.Medium;

import cn.hutool.core.lang.Pair;

import java.util.HashMap;
import java.util.Map;

//454. 四数相加 II
//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
public class FourSumCount454 {
    //官方解法：两两分组 先记录第一组的所有结果,第二组在遍历时进行查漏补缺
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int res = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currSum = nums1[i] + nums2[j];
                sumMap.put(currSum,sumMap.getOrDefault(currSum,0) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currSum = nums3[i] + nums4[j];
                if(sumMap.containsKey(0 - currSum)){
                    res+=sumMap.get(0 - currSum);
                }
            }
        }
        return res;

    }
}
