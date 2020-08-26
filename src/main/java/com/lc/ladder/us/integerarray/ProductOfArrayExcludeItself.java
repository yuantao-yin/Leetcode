package com.lc.ladder.us.integerarray;

import java.util.*;

public class ProductOfArrayExcludeItself {
    /**
     * Example: For A = [1, 2, 3], return [6, 3, 2]
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return res;
        }
        int product = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i == 0) {
                res.add(productRight(i+1, A));
            } else if (i > 0 && i < A.size()-1) {
               res.add(productLeft(i, A) * productRight(i+1, A)); 
            } else {
            res.add(productLeft(i, A));
            }
        }
        return res;
    }
    // calculate the product of left side of i
    private long productLeft(int y, ArrayList<Integer> A) {
        long prod = 1;
        for (int i = 0; i < y; i++) {
            prod *= A.get(i);
        }
        return prod;
    }
    // calculate the product of right side of i
    private long productRight(int y, ArrayList<Integer> A) {
        long prod = 1;
        for (int i = y; i < A.size(); i++) {
            prod *= A.get(i);
        }
        return prod;
    }
}
