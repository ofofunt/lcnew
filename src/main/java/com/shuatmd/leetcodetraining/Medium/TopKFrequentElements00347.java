package com.shuatmd.leetcodetraining.Medium;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//347. 前 K 个高频元素
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
public class TopKFrequentElements00347 {

    //手搓解法: 小根堆记录k个最大的value 之后遍历反查
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (Integer value : countMap.values()) {
            if (queue.size() == k) {
                if (value > queue.peek()) {
                    queue.poll();
                    queue.offer(value);
                }
            } else {
                queue.offer(value);
            }
        }
        int index = 0;
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) >= queue.peek()) {
                res[index] = key;
                index++;
            }
        }
        return res;
    }
}
