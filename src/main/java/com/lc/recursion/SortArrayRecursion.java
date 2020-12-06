package com.lc.recursion;

import java.util.Arrays;

public class SortArrayRecursion {
    public static void sortArray(int[] array, int n) {
        // Write your code here
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        sortArray(array, n - 1);
        //System.out.print("Sorted Array:");
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,4,5,3,9};
        sortArray(a, 5);
        System.out.println(Arrays.toString(a));
    }
}
