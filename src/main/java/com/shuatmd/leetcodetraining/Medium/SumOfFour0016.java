package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18. 四数之和
//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
public class SumOfFour0016 {
    //和三数之和差不多的做法
    //排序+双指针
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            long x = nums[a];
            //因为不能出现重复解 所以忽略一样的部分
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            //去掉冗余的部分
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            //当前x+最大的三个数都小于target的话 直接右移a
            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int b = a + 1; b < n - 2; b++) {
                long y = nums[b];
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                if (x + y + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if (x + y + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int c = b + 1;
                int d = n - 1;
                while (c < d) {
                    long s = x + y + nums[c] + nums[d];
                    if (s > target) {
                        d--;
                    } else if (s < target) {
                        c++;
                    } else {
                        List<Integer> curr = new ArrayList<>();
                        curr.add((int) x);
                        curr.add((int) y);
                        curr.add(nums[c]);
                        curr.add(nums[d]);
                        ans.add(curr);
                        for (c++; c < d && nums[c] == nums[c - 1]; c++) ;
                        for (d--; c < d && nums[d] == nums[d + 1]; d--) ;

                    }
                }
            }
        }
        return ans;
    }


}
