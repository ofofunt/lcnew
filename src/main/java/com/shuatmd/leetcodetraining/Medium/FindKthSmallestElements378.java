package com.shuatmd.leetcodetraining.Medium;

import java.util.PriorityQueue;

//378. 有序矩阵中第 K 小的元素
//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
//
//你必须找到一个内存复杂度优于 O(n2) 的解决方案。
public class FindKthSmallestElements378 {
    //官方解法2：二分查找 更高效更快
    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right){
            int mid = left + (right - left) /2;
            if(check(matrix,mid,k,n)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    //用于矩阵中所有小于mid的数的数量

    private boolean check(int[][] matrix, int mid, int k, int n) {
        //从左下角开始算,如果遇到大于mid则上移一格
        int i = n - 1;
        int j = 0;
        int num = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] < mid){
                //所有列+1 所以是+=i + 1
                num += i + i;
                j++;
            }
            else{
                i--;
            }
        }
        return num >= k;
    }

    //手搓解法1： 优先队列
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        for (int[] ints : matrix) {
            for (int cur : ints) {
                queue.offer(cur);
                if(queue.size() > k){
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
