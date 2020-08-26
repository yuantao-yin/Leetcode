package com.lc.ladder.us.string;

import java.util.*;

public class GroupOfAnagrams {
    /**
     * Given an array of strings, return all groups of strings that are anagrams.
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        ArrayList<String> list = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        
        for (String str : strs) {
            int count[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            int hashcode = getHash(count);
            
            if (!map.containsKey(hashcode)) {
                map.put(hashcode, new ArrayList<String>());
            }

            map.get(hashcode).add(str);
        }
        for (ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                list.addAll(tmp);
            }
        }
        return list;
    }
    
    private int getHash(int[] count) {
        int factor = 37;
        int hash = 0;
        for (int num : count) {
            hash = hash*factor + num;
        }
        return hash;
    }
}
