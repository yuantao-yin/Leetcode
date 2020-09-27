package com.flang.graph;

/*
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int
findCelebrity(n), your function should minimize the number of calls to knows.
 */
public class FindCelebrity {

    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        if (n < 0) return -1;
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // by each time calling knows(a,b), we must know one people is
            // guaranteed not to be celebrity
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (candidate != i) {
                if (knows(candidate, i) || !knows(i, candidate)) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    // dummy method
    private boolean knows(int candidate, int i) {
        return false;
    }


}
