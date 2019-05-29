package com.dataStructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class CastleOnTheGrid {
    class Point {
        int x, y;
        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        Queue list = new Queue();
        int[][] origin = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;i<n;i++){
                if (grid[i].charAt(j) == '.') {
                    origin[i][j] = 1;
                } else {
                    origin[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(origin));
        return 222;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("other/output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        bufferedWriter.write(String.valueOf(n));
        bufferedWriter.newLine();
        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
            bufferedWriter.write(String.valueOf(gridItem));
            bufferedWriter.newLine();
        }
//
        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
