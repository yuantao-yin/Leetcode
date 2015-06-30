package com.lc.ladder.us.integerarray;

public class FirstMissingPositive {
    /**Thought:
     * 1 - most sorting algorithms take time at least O(nlogn).
     * 2 - Linear sorting algorithm bucket sort requires O(n) space
     * 3 - HashTable also take O(n) space
     * @param A: an array of integers
     * @return: an integer
     */
    public int findFirstMissingPositive(int[] A) {
        if (A == null) {
            return 0;
        }
        
        for (int i = 0; i < A.length; i++) {
            // 1: A[i] is in the range
            // 2: A[i] > 0
            // 3: The target is different
            while (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                swap(i, A[i] - 1, A);
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
    
    private void swap (int i, int j, int[] A) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
