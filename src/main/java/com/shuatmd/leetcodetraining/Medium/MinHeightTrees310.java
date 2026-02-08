package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//310. 最小高度树
//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，任何一个没有简单环路的连通图都是一棵树。
//
//给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
//
//可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
//
//请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
//
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
public class MinHeightTrees310 {
    //官方解法：bfs
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //先判断特殊情况
        if(n == 0 || n == 1){
            return new ArrayList<>();
        }
        int[] degree = new int[n];
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            //把两边的度都+1
            degree[edge[0]] ++;
            degree[edge[1]] ++;
            //统计两边的neighbor
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        //遍历,把所有度=1也就是叶子节点放入queue中
        for (int i = 0; i < n; i++) {
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                res.add(poll);
                List<Integer> neighbors = map.get(poll);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
