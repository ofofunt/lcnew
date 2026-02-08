package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//209. 长度最小的子数组
//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
public class MinSubarrayLenWithSum209 {
    //官方解法1：滑动窗口
    public int minSubArrayLenSlidingWindow(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = n + 1;
        int curr = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            curr += nums[right];
            while (curr >= target) {
                res = Math.min(right - left + 1, res);
                curr -= nums[left];
                left++;
            }
        }
        return res == n + 1 ? 0 : res;
    }

    //官方解法2：前缀和+二分查找
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[n + 1];
        //求出前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int currTar = target + sum[i - 1];
            int bound = Arrays.binarySearch(sum, currTar);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
