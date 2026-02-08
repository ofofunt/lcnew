package com.shuatmd.leetcodetraining.Medium;
//153. 寻找旋转排序数组中的最小值
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
//若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
//若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//
//给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
public class FindMinInRotatingArray153 {
    //因为要logn 所以必须用二分法来做
    //官方题解1： 二分查找

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            //当前数小于右半区的数,则说明目前处于递增,最小值一定在左半区
            if(nums[mid] < nums[right]){
                right = mid;
            }
            //省略的是nums[mid] >nums[right]
            //说明min一定在右半部分
            else{
                left = mid + 1;
            }

        }
        return nums[left];
    }
}
