package com.dataStructure;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = null;
        for(int i=0;i<numbers.length;i++){
            hashMap.put(numbers[i], i);
        }
        for(int i=0;i<numbers.length;i++){
            int diff = target - numbers[i];
            if(hashMap.containsKey(diff) && (hashMap.get(diff) != i)) {
                result = new int[]{hashMap.get(diff), i};
            }
        }
        return result;
    }
    public static boolean isValidParentheses(String str) {
        HashMap<String, String> data = new HashMap<>();
        data.put("(", ")");
        data.put("[", "]");
        data.put("{", "}");
        data.put(")", "(");
        data.put("}", "{");
        data.put("]", "[");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            String value = String.valueOf(str.charAt(i));
            if(stack.empty()) {
                stack.push(value);
            } else {
                if(data.get(stack.peek()).equals(value)) {
                    stack.pop();
                } else {
                    stack.push(value);
                }
            }
        }
        return stack.empty();
    }
    public static HashMap count(String input) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<input.length();i++) {
            String value = String.valueOf(input.charAt(i));
            if(hashMap.containsKey(value)) {
                hashMap.put(value, hashMap.get(value) + 1);
            } else {
                hashMap.put(value, 1);
            }
        }
        return hashMap;
    }
}
