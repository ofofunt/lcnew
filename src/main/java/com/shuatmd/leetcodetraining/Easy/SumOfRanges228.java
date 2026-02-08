package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

//228. 汇总区间
//给定一个  无重复元素 的 有序 整数数组 nums 。
//
//区间 [a,b] 是从 a 到 b（包含）的所有整数的集合。
//
//返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个区间但不属于 nums 的数字 x 。
//
//列表中的每个区间范围 [a,b] 应该按如下格式输出：
public class SumOfRanges228 {
    public static void main(String[] args) {

    }

    //官方题解：直接while做 没考虑到
    public List<String> summaryRangesOfficial(int[] nums) {
        List<String> resList = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if(low < high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            resList.add(temp.toString());
        }
        return resList;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> resList = new ArrayList<>();
        int size = 0;
        if (nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            resList.add(nums[0] + "");
            return resList;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                size++;
            } else {
                if (size == 0) {
                    resList.add(nums[i - 1] + "");
                } else {
                    resList.add(nums[i - 1] - size + "->" + nums[i - 1]);
                }
                size = 0;
            }
        }
        if (size == 0) {
            resList.add(nums[nums.length - 1] + "");
        } else {
            resList.add(nums[nums.length - 1] - size + "->" + nums[nums.length - 1]);
        }
        return resList;
    }

    //可行但是太慢了
    public List<String> summaryRanges(int[] nums) {
        List<String> resList = new ArrayList<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            resList.add(nums[0] + "");
            return resList;

        }
        int left = 0;
        int right = 1;
        int size = 0;

        while (left < nums.length && right < nums.length) {
            if (nums[left] + 1 == nums[right] || right != nums.length - 1) {
                left++;
                size++;
            } else {
                if (size > 0) {
                    resList.add((nums[right - size - 1]) + "->" + (nums[right - 1]));
                } else {
                    resList.add(String.valueOf(nums[right - size - 1]));
                }
                left = right;
                size = 0;
            }
            right++;
        }
        if (size > 0) {
            resList.add((nums[right - size - 1]) + "->" + (nums[right - 1]));
        } else {
            resList.add(String.valueOf(nums[right - size - 1]));
        }
        return resList;
    }
}
