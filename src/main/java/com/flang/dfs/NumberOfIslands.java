package com.flang.dfs;

import java.util.ArrayDeque;

/**
 * LC 200
 */
public class NumberOfIslands {

    final static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    /**
     * BFS
     */
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numOfIslands = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    bfs(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }

    private void bfs(char[][] grid, int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];
                if (nX < 0 || nX >= grid.length || nY < 0 || nY >= grid[0].length) continue;
                if (grid[nX][nY] == '1') {
                    grid[nX][nY] = '0';
                    queue.push(new int[]{nX, nY});
                }
            }
        }
    }

    /**
     * DFS
     */
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
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            dfs(grid, nextX, nextY, rows, cols);
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
        //int count = numberOfIslands.numIslands(grids);
        int count = numberOfIslands.numIslandsBFS(grids);
        System.out.println(count);
    }
}
