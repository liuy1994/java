package com.dataStructure;
import java.util.*;

public class Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i = 0; i < lines; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                stack1.push(scanner.nextInt());
            } else if (type == 2) {

                if (stack2.isEmpty()){
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else if (type == 3) {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    System.out.println(stack2.peek());
                }
            }
        }
        scanner.close();
    }
}


