package com.no155;

import java.util.Stack;

public class MinStack {
    Stack<Integer> data = new Stack();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        min.push((!min.isEmpty() && min.peek()<x)? min.peek():x);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek().intValue();
    }

    public int getMin() {
        return min.peek().intValue();
    }
    /*
        ["MinStack","push","push","push","getMin","pop","top","getMin"]
        [[],[-2],[0],[-3],[],[],[],[]]

     */
    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(-2);
        minstack.push(0);
        minstack.push(-3);
        System.out.println(minstack.getMin());
        minstack.pop();
        System.out.println(minstack.top());
        System.out.println(minstack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */