package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//169. 多数元素
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素
//https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150
public class MajorityElements169 {

    //官方解法：摩尔投票
    //原理类似与相消算法
    //不同的两个数两两相消 剩下的一定是众数
    public int majorityElementOfficial(int[] nums) {
        int count = 0;
        int candiate = -1;
        for (int num : nums) {
            if(count == 0){
                candiate = num;
            }
            count += candiate == num? 1:-1;
        }
        return candiate;
    }
    //手搓简单做法1： 因为出现次数一定大于 n/2 则sort之后他的位置一定在中间
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
