package com.msft.mianjin;

public class GameOfLife {

    static final int[][] dirs = new int[][] {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1},
            {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public void gameOfLife(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] rst = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveCounts = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < r && y >= 0 && y < c && board[x][y] == 1) {
                        liveCounts++;
                    }
                }

                if (board[i][j] == 0 && liveCounts == 3) {
                    rst[i][j] = 1;
                } else if (board[i][j] == 1 && (liveCounts == 2 || liveCounts == 3)) {
                    rst[i][j] = 1;
                }

            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = rst[i][j];
            }
        }
    }

    public void gameOfLifeInPlace(int[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int liveCounts = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < r && y >= 0 && y < c && Math.abs(board[x][y]) == 1) {
                        liveCounts++;
                    }
                }

                if (board[i][j] == 0 && liveCounts == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (liveCounts < 2 || liveCounts > 3)) {
                    board[i][j] = -1;
                }

            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }

}
