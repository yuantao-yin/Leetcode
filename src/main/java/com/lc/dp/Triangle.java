package com.lc.dp;

import java.util.ArrayList;

public class Triangle {

	/**
     * Bottom-up DP: set f[i][j] as start point and get min path from f[i][j] to f[0][0]
     * State: f[x][y] is min path from x,y to 0,0
     * Function: f[x][y] = min(f[x+1][y], f[x+1][y+1]) + A[x][y]
     * Initialize: f[A.size-1][i] = A[A.size-1][i]
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // 
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int path[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            path[n-1][i] = triangle.get(n-1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                path[i][j] = Math.min(path[i+1][j], path[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return path[0][0];
        
    }
}
