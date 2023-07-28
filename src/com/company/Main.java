package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
      System.out.println(isValid("[][][]"));
    }

    public static Boolean isValid(String str) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        Stack<String> stack = new Stack<String>();

        for (String s : str.split("")) {
            if (map.containsKey(s)) {
                if (!stack.empty() && map.get(s).equals(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s);
                }
            } else {
                stack.push(s);
            }
        }

        return stack.empty();
    }
}




