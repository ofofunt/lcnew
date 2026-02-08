package com.shuatmd.leetcodetraining.Medium;
//209. 长度最小的子数组
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

import java.util.Arrays;

public class MinSubarrayWIthTargetSum209 {
    public static void main(String[] args) {
        MinSubarrayWIthTargetSum209 test = new MinSubarrayWIthTargetSum209();
        test.minSubArrayLenRollingWindow(4, new int[]{1, 4, 4});
    }

    //手搓解法：滑动窗口
    public int minSubArrayLenRollingWindow(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //设定初始形态
        int left = 0;
        int sum = nums[0];
        int ans = Integer.MAX_VALUE;
        int right = left;
        while (left < n) {
            //当和不超过target的时候 指针一直向右移动
            //直到和超过target,或者到达最尾端
            while (sum < target && right + 1 < n) {
                right++;
                sum += nums[right];
            }
            //如果结束状态的和大于target，储存当前所需要的个数
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
            }
            //将指针左移,当前的和只需要减去左指针位置的数即可
            sum -= nums[left];
            left++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //手搓解法：暴力法 轮流查找
    public int minSubArrayLenBrute(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    //手搓解法：尝试前缀和
    //结论 不太行 无法判断
    public int minSubArrayLen(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) {
            return 0;
        }
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = sum;
        for (int i = 1; i < prefixSum.length; i++) {
            sum -= nums[i - 1];
            prefixSum[i] = sum;
        }
        int left = 0;
        int right = prefixSum.length - 1;

        return 1;
    }


}
