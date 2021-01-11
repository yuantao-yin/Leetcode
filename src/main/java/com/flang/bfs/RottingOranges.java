package com.flang.bfs;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
LC 994
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*/
public class RottingOranges {

    /**
     * 1. check corner case, set minutes = 0
     * 2. loop grid to get rotten and fresh oranges count
     * 3. push all rotten oranges to the queue
     * 4. helper int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}
     * 5. while (freshOranges > 0 and queue is not empty)
     *      n = queue size
     *      minutes++;
     *      loop n
     *        int[] cur = queue.poll()
     *        for (dir[] : dirs)
     *          get new x, y coordinate
     *          if (x or y is not out of bound)
     *            if (grid[x][y] == 1)  // if fresh, change it to rotten
     *              freshOranges--
     *              grid[x][y] == 2
     *              queue.push(grid[x][y])  // push the coordinate to the queue
     *
     * 6. if freshOranges > 0, return -1, otherwise return minutes
     *
     */
    public int orangesRottingBFS(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh += 1;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : minutes;
    }

    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add("" + i + j);
                }
                if (grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }
        int minutes = 0;
        int[][] directions = {{0,1}, {1,0},{-1,0},{0,-1}};
        while(fresh.size() > 0) {
            Set<String> infected = new HashSet<>();
            // loop every rotten oranges
            for (String r : rotten) {
                // easy way to convert character to integer
                int i = r.charAt(0) - '0';
                int j = r.charAt(1) - '0';
                // check surround orange that can be infected
                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (fresh.contains("" + nextI + nextJ)) {
                        infected.add("" + nextI + nextJ);
                        fresh.remove("" + nextI + nextJ);
                    }
                }
            }
            // we have fresh orange that we can't reach, exit
            if (infected.size() == 0) {
                return -1;
            }
            // continue bfs the infected oranges
            rotten = infected;
            // increase minutes
            minutes++;
        }
        return minutes;
    }
}
