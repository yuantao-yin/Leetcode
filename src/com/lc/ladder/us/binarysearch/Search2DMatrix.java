package com.lc.ladder.us.binarysearch;

public class Search2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0;
        int r = row * col - 1;
        while (l <= r) {
            int mid = (l+r)/2;
            // position: 0   1   2   3   4   5   6   7   8   9   10   11
            // row = position/columns
            // col = position%columns
            int midVal = matrix[mid/col][mid%col];
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
