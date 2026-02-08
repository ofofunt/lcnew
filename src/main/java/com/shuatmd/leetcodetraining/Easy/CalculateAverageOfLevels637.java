package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

//637. 二叉树的层平均值
//给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
public class CalculateAverageOfLevels637 {
    //官方解法： 优化了计算count的步骤 同时也不需要额外开空间农currNode
    public List<Double> averageOfLevelsOfficial(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }

    //尝试之前的写法 两个while
    public List<Double> averageOfLevelsDFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<Double> res = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            Queue<TreeNode> currQueue = new LinkedList<>();
            Double sum = 0.0;
            int count = 0;
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                sum += Double.valueOf(node.val);
                count++;
                if (node.left != null) {
                    currQueue.add(node.left);
                }
                if (node.right != null) {
                    currQueue.add(node.right);
                }
            }
            Double mean = sum / Double.valueOf(count);
            res.add(mean);
            nodeQueue = currQueue;
        }
        return res;
    }

    //手搓解法1：层级遍历
    //感觉过于复杂了 试试之前那种两个while的写法
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int max_depth = -1;
        Map<Integer, Double> sumMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();
            max_depth = Math.max(max_depth, depth);
            sumMap.put(depth, Double.valueOf(sumMap.getOrDefault(depth, 0.0) + node.val));
            countMap.put(depth, countMap.getOrDefault(depth, 0) + 1);
            if (node.left != null) {
                nodeQueue.offer(node.left);
                depthQueue.offer(depth + 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
            }
        }
        List<Double> res = new ArrayList<>();
        for (int i = 0; i <= max_depth; i++) {
            Double mean = Double.valueOf(sumMap.get(i)) / Double.valueOf(countMap.get(i));
            res.add(mean);
        }
        return res;
    }
}
