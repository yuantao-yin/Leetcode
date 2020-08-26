package com.lc.ladder.us.bitmath;

public class UpdateBits {
	
    public int updateBits(int n, int m, int i, int j) {
        int mask;
        if (j < 31) {
            int ones = ~0;
            int left = ones << (j+1);
            int right = (1 << i) - 1;
            mask = left | right;
        } else {
            mask = (1 << i) - 1 ;
        }
        return (m << i) | (mask & n);
    }
}
