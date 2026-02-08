package com.shuatmd.leetcodetraining.Easy;

import java.util.*;

//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
public class IntersectionTwoNumber0349 {
    //简便写法：快速构建int[]
    public int[] intersectionSimple(int[] nums1, int[] nums2) {
        int []hash = new int[1001];
        int []res = new int[1001];
        for(int num : nums1){
            hash[num] ++;
        }
        int index = 0;
        for(int num : nums2){
            if(hash[num] > 0){
                res[index++] = num;
                hash[num] = 0;
            }
        }
        return Arrays.copyOf(res, index);
    }
    //感觉复杂了
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> intCount1 = new HashMap<>();
        Map<Integer,Integer> intCount2 = new HashMap<>();
        for (int i : nums1) {
            intCount1.put(i,intCount1.getOrDefault(i,0) + 1);
        }
        for (int i : nums2) {
            intCount2.put(i,intCount1.getOrDefault(i,0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> smallerSet = intCount1.keySet().size()>intCount2.keySet().size()? intCount2.keySet():intCount1.keySet();
        for (int x : smallerSet) {
            if(intCount1.getOrDefault(x,0) > 0 && intCount2.getOrDefault(x,0) > 0){
                res.add(x);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }
}
