package com.flang.dfs;

public class NumberOfIslands {

    final static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, int rows, int cols) {
        //base case: the current point is out of bounds or is '0'
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
            return;
        }
        // recursive rule
        grid[x][y] = '0';
        for (int[] dir : dirs) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(grid, neiX, neiY, rows, cols);
        }
    }

    public static void main(String[] args) {
        char[][] grids = {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'}};
        System.out.println("row len: " + grids.length);
        System.out.println("col len: " + grids[0].length);
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int count = numberOfIslands.numIslands(grids);
        System.out.println(count);
    }
}
