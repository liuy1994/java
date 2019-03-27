package com.dataStructure;

import java.io.*;
import java.util.*;

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length()%2 == 1) {
            return "NO";
        }
        HashMap<String, String> data = new HashMap<>();
        data.put("(", ")");
        data.put("[", "]");
        data.put("{", "}");
        data.put(")", "(");
        data.put("}", "{");
        data.put("]", "[");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            String value = String.valueOf(s.charAt(i));
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
        return stack.empty() ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(System.getenv("OTHER") + "/Brackets.txt");
        File file = new File(System.getenv("OTHER"), "/Brackets.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
