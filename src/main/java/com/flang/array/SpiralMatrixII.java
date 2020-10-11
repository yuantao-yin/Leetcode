package com.flang.array;

import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int [][] rst = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, bottom = n - 1;
        int size = n * n;
        int count = 0;
        int num = 1;
        while (count < size) {
            for (int i = left; i <= right && count < size; i++) {
                rst[top][i] = num++;
                count++;
            }
            top++;
            for (int i = top; i <= bottom && count < size; i++) {
                rst[i][right] = num++;
                count++;
            }
            right--;
            for (int i = right; i >= left && count < size; i--) {
                rst[bottom][i] = num++;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top && count < size; i--) {
                rst[i][left] = num++;
                count++;
            }
            left++;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] test = generateMatrix(3);
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
    }
}
