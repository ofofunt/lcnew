package com.shuatmd.leetcodetraining.Easy;
//704. 二分查找
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
//
//你必须编写一个具有 O(log n) 时间复杂度的算法
public class Search704 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if(nums == null || length == 0){
            return -1;
        }
        int left = 0;
        int right = length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;
    }
}
