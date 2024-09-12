package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
public class GetLeastNumbers40 {
    //本题思路其实是考察排序方法,排序之后取前k位元素即可
    //1.解法一 最简单的排序 复杂度nlogn
    public int[] getLeastNumbersUsingSort(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //2.用堆来做处理,维护一个长度为k的堆,当有比k堆顶的数小的数出现时,弹出堆顶的数,并且offer当前数
    //遍历完整个int[] 最后的堆就是结果
    public static int[] getLeastNumbersUsingHeap(int[] arr, int k) {
        int[] res = new int[k];
        //判断如果当前array为空 则直接返回
        //主要需要同事判断k的边际
        if (arr.length == 0 || k == 0) {
            return res;
        }
        //New一个新的priorityQueue 并且实现从小到大排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        //注意i = k 从第k+1个元素开始
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    //解法3：复杂解法,用快排+递归的思路来做,完整快排整个array,然后返回前k个数据
    public int[] getLeastNumbersUsingQuickSortFull(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[r]) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4};
        GetLeastNumbers40.getLeastNumbersUsingHeap(arr, 2);
    }
}
