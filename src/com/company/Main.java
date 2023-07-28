package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//      System.out.println(isValid("[][][]"));
//      Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        String str = "23654";

        for (String s : str.split("")) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(sum(list, 5));

    }

    public static ArrayList<Integer> sum(ArrayList<Integer> list, Integer target){
        Map<Integer, Integer> set = new HashMap<Integer, Integer>();
        for (int i=0;i<list.size();i++){
            set.put(list.get(i), i);
        }
        for (Integer integer : list) {
            if (set.containsKey(target - integer)) {
                return new ArrayList<Integer>(Arrays.asList(set.get(integer), set.get(target - integer)));
            }
        }
        return new ArrayList<Integer>();
    }

    public static void sort(ArrayList<Integer> list, Integer left, Integer right) {
        int i = left;
        int j = right;
        int temp = list.get(left);
        while (i < j) {
            while (i < j && list.get(i) < temp) {
                i++;
            }
            while (i < j && list.get(j) > temp) {
                j--;
            }
            if (i < j) {
                int mid = list.get(i);
                list.set(i, list.get(j));
                list.set(j, mid);
            }
        }
        if (left < i) {
            sort(list, left, i - 1);
        }
        if (i < right) {
            sort(list, i + 1, right);
        }
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




