package com.shuatmd.leetcodetraining.Medium;
//162. 寻找峰值
//峰值元素是指其值严格大于左右相邻值的元素。
//
//给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//
//你可以假设 nums[-1] = nums[n] = -∞ 。
//
//你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
public class FindApexElements162 {
    //官方解法2：二分法O(logn)
    public int findPeakElementOnBinary(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            //说明处于下降阶段,峰值肯定在左边
            //因为是递减,所以mid+1不可能为峰值
            //从mid开始向左移动

            if(nums[mid] > nums[mid + 1]){
                right = mid;
            }
            //如果处于递增趋势，则峰值一定在右边
            //又因为Nums[mid] < nums[mid+1] 所以mid不可能为峰值
            //从mid + 1开始
            else{
                left = mid +1;
            }
        }
        return left;
    }

    //官方解法1：O(n) 单次循环 比较大小
    public int findPeakElementOn(int[] nums) {
        int index = 0;
        //只要后一个数比当前数大,则记录当前数,不断更新
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[index]){
                index = i;
            }
        }
        return index;

    }


}
