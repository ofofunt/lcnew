package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//973. 最接近原点的 K 个点
//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，并且是一个整数 k ，返回离原点 (0,0) 最近的 k 个点。
//
//这里，平面上两点之间的距离是 欧几里德距离（ √(x1 - x2)2 + (y1 - y2)2 ）。
//
//你可以按 任何顺序 返回答案。除了点坐标的顺序之外，答案 确保 是 唯一 的
public class KClosetPoint973 {
    public static void main(String[] args) {
        KClosetPoint973 test = new KClosetPoint973();
        int[][] sample = new int[3][2];
        sample[0] = new int[]{-5, 4};
        sample[1] = new int[]{-6, -5};
        sample[2] = new int[]{4, 6};
        test.kClosest2(sample, 2);
    }

    public int[][] kClosest2(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> queue = new PriorityQueue<>
                ((a1, a2) -> a2[0] * a2[0] + a2[1] * a2[1] - a1[0] * a1[0] - a1[1] * a1[1]);
        for (int[] point : points) {
            if (queue.size() < k) {
                queue.offer(point);
            } else {
                int[] peek = queue.peek();
                if (point[0] * point[0] + point[1] * point[1] < peek[0] * peek[0] + peek[1] * peek[1]) {
                    queue.poll();
                    queue.offer(point);
                }
            }
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    //手搓解法：map+排序 然后返回
    //无法很好解决相同距离的点
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        Map<Integer, Integer> indexDistanceMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] curr = points[i];
            int distance = curr[0] * curr[0] + curr[1] * curr[1];
            indexDistanceMap.put(distance, i);
        }
        Set<Integer> integers = indexDistanceMap.keySet();
        List<Integer> sortedList = new ArrayList<>(integers);
        Collections.sort(sortedList);
        for (int i = 0; i < k; i++) {
            int index = indexDistanceMap.get(sortedList.get(i));
            res[i][0] = points[index][0];
            res[i][1] = points[index][1];
        }
        return res;

    }
}
