package com.dataStructure;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int t) {
        stack.push(t);
        if (min.isEmpty()) {
            min.push(t);
        } else if (min.peek() > t) {
            min.push(t);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int pop = stack.pop();
        if (pop == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
