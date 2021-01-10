package com.lc.sort;

import java.util.Arrays;

/**
 * LC 976
 * Given an array A of positive lengths, return the largest perimeter of a triangle
 * with non-zero area, formed from 3 of these lengths.
 *
 * Input: [3,2,3,4]
 * Output: 10
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length - 1;
        for(int i = len; i >= 2; i--) {
            if ((A[i-1] + A[i-2]) > A[i]) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }
}
