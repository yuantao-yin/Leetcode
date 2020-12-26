package com.amaz;

/**
 * LC 1381 Medium
 */
public class CustomStackWithIncrement {

    int[] stack;
    int top;
    public CustomStackWithIncrement(int maxSize) {
        stack = new int[maxSize];
        top = 0;
    }

    public void push(int x) {
        if(top == stack.length) {
            return;
        }
        stack[top++] = x;
    }

    public int pop() {
        if (top == 0) return -1;
        return stack[--top];
    }

    public void increment(int k, int val) {
        int r = Math.min(k, top);                                                                                       for (int i=0; i < r; i++) {
            stack[i] += val;
        }
    }

}
