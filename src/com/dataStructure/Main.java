package com.dataStructure;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(5);
        stack.push(1);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}

