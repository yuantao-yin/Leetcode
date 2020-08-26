package com.lc.ladder.us.bitmath;

public class FlipBits {
	
    public int bitSwapRequired(int a, int b) {
        if (a == b) {
            return 0;
        }
        int bit = a ^ b;
        int count = 0;
        int num = 32;
        
        while (num > 0) {
            count += bit & 1;
            bit = bit >> 1;
            num--;
        }
        return count;
    }
}
