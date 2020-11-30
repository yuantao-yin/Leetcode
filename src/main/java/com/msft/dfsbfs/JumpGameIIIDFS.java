package com.msft.dfsbfs;

public class JumpGameIIIDFS {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return travel(arr, start, visited);
    }
    // DFS
    private boolean travel(int[] arr, int index, boolean[] visited){
        if (index < 0 || index > arr.length - 1 || visited[index]) {
            return false;
        }
        visited[index] = true;
        if (arr[index] == 0) {
            return true;
        }
        int left = index + arr[index];
        int right = index - arr[index];
        return travel(arr, left, visited) || travel(arr, right, visited);
    }
}
