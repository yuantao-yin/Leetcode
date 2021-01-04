package com.lc.slidingwindow;

import java.util.*;

/**
 * LC 239
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> rst = new ArrayList();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // push the index from right of the queue
            dq.addLast(i);
            // think about when we would have to pop out from the frontal window
            if (dq.peekFirst() == (i - k)) {
                dq.pollFirst();
            }
            // k-1 is the position we start to have the maximum number in the window
            if (i >= k - 1) {
                rst.add(nums[dq.peekFirst()]);
            }
        }
        return rst.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] test = SlidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(Arrays.toString(test));
    }
}
