package com.shuatmd.leetcodetraining.Hard;

public class PickUpRaindrop042 {
    //dp:优先计算左边最高的高度 以及右边最高的高度
    //当前dp[i]可以蓄积的水量 = Math.min(leftMax,rightMax) - height[i]
    public int trap(int[] height) {
        int len = height.length;
        //计算左边的最高
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //同理计算右边的最高
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len-2; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(rightMax[i],leftMax[i]) - height[i];
        }
        return sum;
    }
}
