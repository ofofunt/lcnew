package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

//215. 数组中的第K个最大元素
//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
public class FindKthLargest215 {
    public static void main(String[] args) {
        FindKthLargest215 test = new FindKthLargest215();
        test.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    //官方解法1： 分治+递归
    //随机选出当前数列中的一个数作为基准k
    //将当前array根据与基准k对比的大小分为 大于k 小于k 等于k三个数组
    //然后根据情况进行递归
    public int findKthLargest(int[] nums, int k) {
        List<Integer> currList = new ArrayList<>();
        for (int num : nums) {
            currList.add(num);
        }
        return quickSelect(currList, k);

    }

    private int quickSelect(List<Integer> currList, int k) {
        Random ran = new Random();
        //取一个随机数作为当前基准
        int benchmark = currList.get(ran.nextInt(currList.size()));
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        //对每个数进行分类 添加到对应的数组
        for (Integer curr : currList) {
            if (curr > benchmark) {
                big.add(curr);
            } else if (curr < benchmark) {
                small.add(curr);
            } else {
                equal.add(curr);
            }
        }
        //如果k在big数组中,则对big数组再次排序
        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        //如果k 大于数组size - 小于k部分数组的size 说明k目前位于小于数组中
        if (k > currList.size() - small.size()) {
            //需要减去大于的部分
            return quickSelect(small, k - currList.size() + small.size());
        }
        //如果找的k元素在equal中 则直接返回
        return benchmark;

    }
    //官方解法2： 用prorityQueue内置
    public int findKthLargestQueue(int[] nums, int k) {
        //默认为最小堆
        //堆末尾为最大值
        //堆顶为第x大的值
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
