package com.flang.twopointer;

public class TrappingRainWater {

    public int trap(int[] height) {
        // find peak index
        int peak_idx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[peak_idx]) {
                peak_idx = i;
            }
        }
        int water = 0;
        int leftmax = 0;
        // loop from left to peak index, keep track left max index
        // if current index is less than leftmax, we calculate the water size
        for (int i = 0; i < peak_idx; i++) {
            if (height[i] > leftmax) {
                leftmax = height[i];
            } else {
                water = water + leftmax - height[i];
            }
        }
        int rightmax = 0;
        // same for right side
        for (int i = height.length - 1; i > peak_idx; i--) {
            if (height[i] > rightmax) {
                rightmax = height[i];
            } else {
                water = water + rightmax - height[i];
            }
        }
        return water;
    }
}
