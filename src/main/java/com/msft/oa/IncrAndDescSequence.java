package com.msft.oa;

/**
 * Remove least amount of elements from an array to make a ascending first and then descending sequence
 * [2,3,15,5,7,6,4], we can remove either 15 or 5, so result is 1.
 */
public class IncrAndDescSequence {

    // if i-1 > i < i+1 or i-1 < i > i+1, then i should be removed from array
    public int buildArray(int[] a) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i > i + 1) {
                count++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
