package com.lc.recursion;
import java.util.*;

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> rst = new ArrayList<String[]>();
		if (n <= 0) {
			return rst;
		}
		search(n, new ArrayList<Integer>(), rst);
		return rst;
	}
	
	private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> rst) {
		if (cols.size() == n) {
			rst.add(drawChessboard(cols));
			return;
		}
		for (int col = 0; col < n; col++) {
			if (!isVaild(cols, col)) {
				continue;
			}
			cols.add(col);
			search(n, cols, rst);
			cols.remove(cols.size() - 1);
		}
	}
	
	private String[] drawChessboard(ArrayList<Integer> cols) {
		String[] chessboard = new String[cols.size()];
		for (int i = 0; i < cols.size(); i++) {
			chessboard[i] = "";
			for (int j = 0; j < cols.size(); j++) {
				if (j == cols.get(i)) {
					chessboard[i] += "Q";
				} else {
					chessboard[i] += ".";
				}
			}
		}
		return chessboard;
	}
	
	private boolean isVaild(ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for (int i = 0; i < row; i++) {
			// same column
			if (cols.get(i) == col) {
				return false;
			}
			//left-top to right-bottom
			if (i - cols.get(i) == row - col) {
				return false;
			}
			// right-top to left-bottom
			if (i + cols.get(i) == row + col) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens test = new NQueens();
		for (String[] ss : test.solveNQueens(5)) {
			System.out.println(Arrays.toString(ss));
		}
		
	}
	
}
