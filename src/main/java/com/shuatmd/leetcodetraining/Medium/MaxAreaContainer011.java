package com.shuatmd.leetcodetraining.Medium;

//11. 盛最多水的容器
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
public class MaxAreaContainer011 {
    //官方解法：双指针
    //双指针l,r分别指向左右两端
    //将l,r中较短的一方往内部移动 直到L=r
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            if(leftVal < rightVal){
                maxArea = Math.max(maxArea,leftVal * (right - left));
                left++;
            }
            else{
                maxArea = Math.max(maxArea,rightVal *(right - left));
                right --;
            }

        }
        return maxArea;
    }
}
