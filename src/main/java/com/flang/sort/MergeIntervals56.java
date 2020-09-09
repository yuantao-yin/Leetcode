package main.java.com.flang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:
    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
*/
public class MergeIntervals56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        List<int[]> output_arr = new ArrayList();
        int[] cur_interval = intervals[0];
        output_arr.add(cur_interval);

        // [1,3], [2,6], [7,8]
        for (int[] interval : intervals) {
            int cur_begin = cur_interval[0];
            int cur_end = cur_interval[1];
            int next_begin = interval[0];
            int next_end = interval[1];

            if (cur_end >= next_begin) {
                cur_interval[1] = Math.max(cur_end, next_end);
            } else {
                cur_interval = interval;
                output_arr.add(cur_interval);
            }
        }

        return output_arr.toArray(new int[output_arr.size()][]);
    }
}
