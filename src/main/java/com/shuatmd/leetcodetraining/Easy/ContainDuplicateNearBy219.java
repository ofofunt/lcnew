package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.Map;

//219. 存在重复元素 II
//给你一个整数数组 nums 和一个整数 k ，
// 判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
public class ContainDuplicateNearBy219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], i);
            }
            else{
                //判断之后还要更新i的index，这样就不会出现1011 只记录第一位的情况
                int diff = i - indexMap.get(nums[i]);
                indexMap.put(nums[i], i);
                if(diff <= k){
                    return true;
                }
            }
        }
        return false;
    }

}
