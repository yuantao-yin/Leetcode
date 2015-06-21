class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length==0 || board[0].length == 0){
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        
        // check rows
        for(int i=0; i < rows; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j=0; j < cols; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        for(int i=0; i < rows; i++) {
            HashSet<Character> set = new HashSet<Character>();
            for (int j=0; j < cols; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        return true;
    }
    
}
