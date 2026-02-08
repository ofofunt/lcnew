package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//015.ThreeSum
public class SumOfThree015 {
    //思路： 排序 + 两层循环
    //第一层循环 从i=0开始 当前数字为a
    //第二层循环从j = i + 1开始 当前数字为b
    //在第二层的基础上加上一个右指针third 指向第三个数为c
    //如果b + c > target - a 则右指针往左不断移动
    //因为已经排序过得关系,所以j移动之后 third只需要不动或者往左移动
    //如果 j == third 则说明当前循环已经找完
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            //跳过相同的部分
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int third = length - 1;
            int rem = -nums[i];
            //开始第二层循环
            for (int j = i + 1; j < length; j++) {
                //跳过相同的数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < third && nums[j] + nums[third] > rem) {
                    third--;
                }
                if(j == third){
                    break;
                }
                if(nums[j] + nums[third] == rem){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[third]);
                    ans.add(res);
                }
            }
        }
        return ans;

    }
}
