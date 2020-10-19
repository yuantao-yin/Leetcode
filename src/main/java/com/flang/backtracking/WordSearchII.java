package com.flang.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> rst = new HashSet();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, i, j, word, 0)) {
                            rst.add(word);
                        }
                    }
                }
            }
        }

        return new ArrayList<String>(rst);
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = dfs(board, i+1, j, word, index+1)
                || dfs(board, i, j+1, word, index+1)
                || dfs(board, i-1, j, word, index+1)
                || dfs(board, i, j-1, word, index+1);
        board[i][j] = temp;
        return found;
    }

}
