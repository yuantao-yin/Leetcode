package com.amaz;

import java.util.*;

public class FetchItemDisplay {

    public static List<String> fetchItemsToDisplay(int numOfItems, Map<String, PairInt> items,
                                                   int sortParameter, int sortOrder, int itemsPerPage,
                                                   int pageNumber) {
        LinkedHashMap<String, PairInt> sortedMap = new LinkedHashMap<>();
        items.entrySet()
            .stream()
            .sorted((e1, e2) -> {
                if (sortParameter == 1) {
                    return e1.getValue().getRelevance() - e2.getValue().getRelevance();
                } else if (sortParameter == 2) {
                    return e1.getValue().getPrice() - e2.getValue().getPrice();
                }
                return 0;
            })
            .forEachOrdered( x -> sortedMap.put(x.getKey(), x.getValue()));
        //sortedMap.forEach((k,v) -> System.out.println("k: " + k + " v: " + v.getRelevance() + " " + v.getPrice()));

        int idx = 0;
        // required page start index and end index
        int start = pageNumber * itemsPerPage;
        int end = (pageNumber + 1) * itemsPerPage;
        List<String> rst = new ArrayList<>();
        for (Map.Entry<String, PairInt> map : sortedMap.entrySet()) {
            if (idx >= start && idx <= numOfItems && idx < end) {
                rst.add(map.getKey());
            }
            idx++;
        }
        return rst;
    }

    public static void main(String[] args) {
        Map<String, PairInt> map = new HashMap<>();
        map.put("item1", new PairInt(10,15));
        map.put("item2", new PairInt(3,4));
        map.put("item3", new PairInt(17,8));
        Map<String, PairInt> sortMap = new TreeMap<>(map);
        List<String> list = FetchItemDisplay.fetchItemsToDisplay(map.size(), map, 1, 0, 2, 1);
        list.forEach(System.out::println);
    }


}
