package com.amaz;

/**
 * LC 1010 Medium
 */
public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length < 2) {
            return 0;
        }
        int count = 0;
        int[] arr = new int[60];
        for (int t : time) {
            int reminder = t % 60;
            if (reminder == 0) {
                // special case, 0, 30
                count += arr[reminder];
            } else {
                count += arr[60 - reminder];
            }
            arr[reminder]++;
        }
        return count;
    }

}
