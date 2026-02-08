package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> minStack;
    Deque<Integer> stack;

    public MinStack() {
        this.minStack = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);

    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}
