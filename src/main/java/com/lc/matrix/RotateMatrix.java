package com.lc.matrix;

public class RotateMatrix {


    /*
     * Time O(n²), Space O(n²)
     */
    public static void rotateRight90(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n)
            return;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];
            }
        print(result);
    }

    public static void rotateLeft90(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m != n)
            return;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                result[n-1-j][i] = matrix[i][j];
            }
        print(result);
    }

    static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        rotateRight90(arr);
        rotateLeft90(arr);
    }
}
