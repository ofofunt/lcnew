package com.shuatmd.leetcodetraining.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

//84. 柱状图中最大的矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
public class FindMaxArea084 {
    //官方解法1：单调栈
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            //为最后一轮手动加一个0 方便扫完整体
            int currHeight = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int topIndex = stack.pop();
                int height = heights[topIndex];
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                int area = height * width;
                maxArea = Math.max(area,maxArea);
            }
            stack.push(i);
        }
        return maxArea;

    }
}
