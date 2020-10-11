package com.flang.dp;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner
of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 */
public class UniquePath {
    /* The general idea here is that we want to know how many unique paths are from the
    top left corner to the bottom right corner of a grid and this grid is M by n
    and what this problem really boils down to is how many different ways can we
    reach each of these different cells
    */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            // from start point there is only one way to left bottom corner
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            // from start point there is only one way to right top corner
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
