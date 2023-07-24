package com.company;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {
        System.out.println("开始");
        int n = scanner.nextInt();
        if (n < 2 || n > 20) {
            System.out.println("输入的数字应该是2 与 20之间的正整数");
        } else {
            for (int i=1;i<=10;i++) {
                System.out.println(n + " X " + i + " = " + n * i);
            }
        }
        System.out.println("结束");
        scanner.close();
    }
}


