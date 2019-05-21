package com.dataStructure;

import java.util.*;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Node> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<n;i++){
            int type = scanner.nextInt();
            if(type == 1){
                int num = scanner.nextInt();
                max = Math.max(num, max);
                stack.add(new Node(num, max));
            }else if(type == 2) {
                if(!stack.empty()){
                    stack.pop();
                }
                if(stack.empty()){
                    max = 0;
                } else {
                    max = stack.peek().max;
                }
            }else if(type == 3) {
                System.out.println(stack.peek().max);
            }
        }
    }
}
class Node{
    private int num;
    int max;
    Node(int num, int max){
        this.num = num;
        this.max = max;
    }
}
