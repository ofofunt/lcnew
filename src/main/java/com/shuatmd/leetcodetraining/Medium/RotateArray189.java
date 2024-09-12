package com.shuatmd.leetcodetraining.Medium;

//189. 轮转数组
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
public class RotateArray189 {
    //官方最优解： 先reverse 然后部分reverse
    //比如 1 2 3 4 5 6 7   k = 3 右移三位的情况下
    //现将整个数组翻转 变成 7 6 5 4 3 2 1
    //再将前三位翻转 变为 5 6 7 4 3 2 1
    //然后将后四位翻转 变成 5 6 7 1 2 3 4
    public void rotateOfficial2(int[] nums, int k) {
        int n = nums.length;
        int t = k % n;
        reverse(nums,0,n - 1);
        reverse(nums,0,t - 1);
        reverse(nums,t, n - 1);
    }

    private void reverse(int[] nums, int i, int n) {
        while(i < n){
            int tmp = nums[i];
            nums[i] = nums[n];
            nums[n] = tmp;
            i++;
            n--;
        }
    }

    //官方解法1：
    //运用额外数组存储
    public void rotateOfficial(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length];
        //第k位置对应nums第0位 用这种表达可以快速进行数组的
        for (int i = 0; i < length; i++) {
            res[(i + k) % length] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, length);
    }

    //手搓解法1： 最朴素的解法
    //new一个新的数组 然后从头组装
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        //存在k超过长度的情况 需要一直剪到k小于n
        if (n < k) {
            k = k % n;
        }
        for (int i = n - k; i < n; i++) {
            res[i - (n - k)] = nums[i];
        }
        int index = k;
        for (int i = 0; i < n - k; i++) {
            res[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
