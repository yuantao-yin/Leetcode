package com.flang.sort;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if (count1 == count2) {
                    return o2.compareTo(o1);
                }
                return count1 - count2;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> rst = new ArrayList<>();
        while(!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        Collections.reverse(rst);
        return rst;
    }
}
