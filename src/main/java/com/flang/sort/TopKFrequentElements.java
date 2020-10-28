package com.flang.sort;

import java.util.*;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        // (1,3)
        // (2,2)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a).compareTo(map.get(b));
            }
        });
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] rst = new int[k];
        int index = k-1;
        while(!queue.isEmpty()) {
            rst[index--] = queue.poll();
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] t = topKFrequent(new int[]{1,1,1,2,2,5,5,5,5,9,9,9,9,9,9,9,3,3,3,3,3,7,7}, 2);
        System.out.println(Arrays.toString(t));
    }

}
