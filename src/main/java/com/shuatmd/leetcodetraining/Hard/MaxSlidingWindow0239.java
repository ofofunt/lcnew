package com.shuatmd.leetcodetraining.Hard;

import java.util.Deque;
import java.util.LinkedList;

//239. 滑动窗口最大值
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//返回 滑动窗口中的最大值
public class MaxSlidingWindow0239 {
    //双端队列 维持一个递减数列的index
    public int[] maxSlidingWindow(int[] nums, int k) {
        //先从第一个窗口开始
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        //queue用来存最大值的index 并且已经把index放在最左边
        for (int i = 0; i < k; i++) {
            //当queue中存的数没有当前数大时  则排出
            while(!queue.isEmpty()&&nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        //此时窗口的最大值为queue最左侧的index所代表的数字
        ans[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while(!queue.isEmpty()&&nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            //同时还要移除超过边界的值
            while(queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            ans[i - k + 1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
