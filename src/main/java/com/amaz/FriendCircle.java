package com.amaz;

import java.util.Arrays;

/**
 * LC 547 Medium
 */
public class FriendCircle {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        Arrays.fill(visited, false);
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i]) continue;
            dfs(M, visited, i);
            count++;
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, visited, j);
            }
        }
    }
}
