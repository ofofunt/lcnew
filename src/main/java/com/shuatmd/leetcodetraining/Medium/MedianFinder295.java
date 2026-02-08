package com.shuatmd.leetcodetraining.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

//295.数据流的中位数
//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
//
//例如 arr = [2,3,4] 的中位数是 3 。
//例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
//实现 MedianFinder 类:
//
//MedianFinder() 初始化 MedianFinder 对象。
//
//void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
//
//double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受
public class MedianFinder295 {
    private Queue<Integer> smallQueue;
    private Queue<Integer> largeQueue;

    //官方题解1： 运用大小堆来做
    public MedianFinder295() {
        //smallQueue为小顶堆,存放较大的一半数
        this.smallQueue = new PriorityQueue<>();
        //largeQueue为大顶堆,存放较小的一半数
        this.largeQueue = new PriorityQueue<>((a, b) -> b - a);

    }

    //添加的时候通过大小堆来保证插入顺序
    public void addNum(int num) {
        //当size不同时,优先往smallQueue中插入
        if (smallQueue.size() != largeQueue.size()) {
            smallQueue.add(num);
            //smallQueue插入新元素之后,将栈顶最小的元素放入b中
            largeQueue.add(smallQueue.poll());
        } else {
            //同理当size相同时,先往largeQueue中插入元素,然后吧largeQueue中最大的元素推给smallQueue
            largeQueue.add(num);
            smallQueue.add(largeQueue.poll());
        }


    }

    public double findMedian() {
        //当两个queue的size不相等时,中位数位于smallQueue的顶
        //如果size一样 则取两个顶部数值的平均数
        return smallQueue.size() == largeQueue.size() ? (smallQueue.peek() + largeQueue.peek()) / 2 : smallQueue.peek();

    }
}
