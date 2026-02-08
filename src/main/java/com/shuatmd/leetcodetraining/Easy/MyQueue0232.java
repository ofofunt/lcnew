package com.shuatmd.leetcodetraining.Easy;

import java.util.Deque;
import java.util.LinkedList;

//232. 用栈实现队列
//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
//
//实现 MyQueue 类：
//
//void push(int x) 将元素 x 推到队列的末尾
//int pop() 从队列的开头移除并返回元素
//int peek() 返回队列开头的元素
//boolean empty() 如果队列为空，返回 true ；否则，返回 false
public class MyQueue0232 {
    public static void main(String[] args) {
        MyQueue0232 test = new MyQueue0232();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.pop();
        test.push(5);
        test.pop();
        test.pop();
        test.pop();
        test.pop();
    }

    private Deque<Integer> stack;
    private Deque<Integer> reversed;

    public MyQueue0232() {
        this.stack = new LinkedList<>();
        this.reversed = new LinkedList<>();
    }

    public void push(int x) {
        if (reversed.isEmpty()) {
            reversed.push(x);
        } else {
            stack.push(x);
        }
    }

    public int pop() {
        int pop = reversed.pop();
        if (reversed.isEmpty()) {
            while (!stack.isEmpty()) {
                reversed.push(stack.pop());
            }
        }
        return pop;
    }

    public int peek() {
        return reversed.peek();
    }

    public boolean empty() {
        return reversed.isEmpty();
    }
}
