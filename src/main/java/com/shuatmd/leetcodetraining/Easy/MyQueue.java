package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    public MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();

    }

    public void push(int x) {
        inStack.push(x);

    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.pop();

    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();

    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
