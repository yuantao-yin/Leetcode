package com.msft.mianjin;

import java.util.*;

public class TopKFrequentElements {
    public static List<Integer> topKFrequentBucketSort(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // (1,3)
        // (2,2)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Use frequency as List array index, append number element to array if multiple numbers get same frequency
        List[] bucket = new List[nums.length+1];
        for (int key: map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if(bucket[i] == null) continue;
            res.addAll(bucket[i]);
        }
        // res.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray()
        return res;
    }

}
