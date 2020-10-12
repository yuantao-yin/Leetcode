package com.flang.bfs;

import java.util.HashSet;
import java.util.Set;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 */
public class RottingOranges {
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
