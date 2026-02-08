package com.shuatmd.leetcodetraining.Easy;

import java.util.Deque;
import java.util.LinkedList;

//225. 用队列实现栈
//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
//
//实现 MyStack 类：
//
//void push(int x) 将元素 x 压入栈顶。
//int pop() 移除并返回栈顶元素。
//int top() 返回栈顶元素。
//boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
public class MyStack0225 {
    private Deque<Integer> peak;
    private Deque<Integer> queue;
    public MyStack0225() {
        this.peak = new LinkedList<>();
        this.queue = new LinkedList<>();

    }

    public void push(int x) {
        peak.offer(x);
    }

    public int pop() {
        if(peak.isEmpty()){
            while(!queue.isEmpty()){
                peak.offer(queue.poll());
            }
        }
        while(peak.size()>1){
            queue.offer(peak.poll());
        }
        return peak.poll();
    }

    public int top() {
        if(peak.isEmpty()){
            while(!queue.isEmpty()){
                peak.offer(queue.poll());
            }
        }
        while(peak.size()>1){
            queue.offer(peak.poll());
        }
        return peak.peek();
    }

    public boolean empty() {
        return peak.isEmpty() && queue.isEmpty();
    }
}
