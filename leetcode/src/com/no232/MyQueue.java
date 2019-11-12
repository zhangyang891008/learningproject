package com.no232;

import java.util.Stack;

/**
 * 232。用栈实现队列
 */
public class MyQueue {

    Stack<Integer> data = new Stack();
    Stack<Integer> temp = new Stack();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        data.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!temp.isEmpty())
            return temp.pop().intValue();
        while(!data.isEmpty()){
            temp.push(data.pop());
        }
        return temp.pop().intValue();
    }

    /** Get the front element. */
    public int peek() {
        if(!temp.isEmpty())
            return temp.peek().intValue();
        while(!data.isEmpty()){
            temp.push(data.pop());
        }
        return temp.peek().intValue();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return data.empty() && temp.empty();
    }
}