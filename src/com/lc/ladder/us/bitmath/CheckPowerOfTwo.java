package com.lc.ladder.us.bitmath;

public class CheckPowerOfTwo {
	
    public boolean checkPowerOf2(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
