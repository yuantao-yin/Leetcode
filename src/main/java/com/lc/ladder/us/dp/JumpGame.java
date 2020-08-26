package com.lc.ladder.us.dp;

public class JumpGame {
	/*
	 * One way dyanmic programming.
	 * can[i] =  if can reach index i from start
	 */
    public boolean canJump(int[] A) {
        if (A.length <= 1) {
            return true;
        }
        boolean[] can = new boolean[A.length];
        can[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && (j + A[j]) >= i) {
                    can[i] = true;
                    break;	
                }
            }
        }
        return can[A.length-1];
    }
}
