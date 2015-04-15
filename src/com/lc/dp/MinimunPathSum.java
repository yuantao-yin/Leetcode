package com.lc.dp;

public class MinimunPathSum {
	/**
     * Top-bottom DP
     * State: f[x][y] is min path from 0,0 to x,y
     * Function: f[x][y] = min(f[x-1][y], f[x][y-1]) + A[x][y]
     * Initialize: f[0][0] = A[0][0]
     * 			   f[i][0] = sum(0,0 -> i,0)
     * 			   f[0][i] = sum(0,0 -> 0,i) 
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0]; 
        for (int i = 1; i < m; i++) {
            path[i][0] = path[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            path[0][i] = path[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
            }
        }
        return path[m-1][n-1];
    }
}
