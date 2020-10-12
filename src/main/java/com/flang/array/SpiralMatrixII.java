package com.flang.array;

import java.util.Arrays;

public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int [][] rst = new int[n][n];
        int left = 0, top = 0;
        int right = n - 1, bottom = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                rst[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                rst[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                rst[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                rst[i][left] = num++;
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
