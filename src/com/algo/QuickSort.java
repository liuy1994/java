package com.algo;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,4,9,5,8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void quickSort(int[] array, int head, int tail) {
        System.out.println(Arrays.toString(array));
        if (head >= tail || array == null || array.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = array[(head + tail)/2];
        while (i < j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (array[i] > array[j]) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        quickSort(array, head, j);
        quickSort(array, i, tail);
    }
}
