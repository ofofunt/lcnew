package com.shuatmd.leetcodetraining.Hard;
//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class RainDropPickUp042 {
    //官方解法1：dp
    //核心思路：
    //假设当前点的index为i
    //dp[i]代表i这个点能收集到的雨水
    //此时i能收集到的雨水是左边最高位,以及右边最高的两者中较小的一位 - 当前自身的高度
    public int trap(int[] height) {
        //首先初始化求左边方向的最高值 以及 右边方向的最高值
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum+= Math.min(leftMax[i],rightMax[i]) - height[i];

        }
        return sum;
    }
}
