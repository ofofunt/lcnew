package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//137. 只出现一次的数字 II
//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
//你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
public class SingleNumberApearanceII137 {
    //官方解法1：通过位运算确认二进制的每一位
    //二进制上的每一位一定是总和除以3的余数
    public int singleNumberOfficial(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum+= (num >> i) & 1;
            }
            if(sum%3!=0){
                res |= (1<<i);
            }
        }
        return res;
    }
    //手搓解法：哈希表
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> storeMap = new HashMap<>();
        for (int num : nums) {
            storeMap.put(num,storeMap.getOrDefault(num,0) + 1);
        }
        for (int num : nums) {
            if(storeMap.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
