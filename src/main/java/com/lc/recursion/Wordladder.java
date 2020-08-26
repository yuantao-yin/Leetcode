package com.lc.recursion;
import java.util.*;

public class Wordladder {

	// Native approach
	public static int ladderLength(String start, String end, HashSet<String> dict) {
		int len = 0;
		for (int i = 0; i < start.length(); i++ ) {
			char[] startArr = start.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == startArr[i]) {
					continue;
				}
				startArr[i] = c;
				String tmp = new String(startArr);
				if (dict.contains(tmp)) {
					len++;
					start = tmp;
					if (tmp.equals(end)) {
						return len;
					}
				}
			}
		}
		return len;
	}
	
	// BFS
	public static int ladderLength2(String start, String end, HashSet<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int len = 1;
        while (!queue.isEmpty()) {
        	int count = queue.size();
        	for (int i = 0; i < count; i++) {
        		String current = queue.poll();
        		char[] curArr = current.toCharArray();
        		for (char c = 'a'; c <= 'z'; c++) {
        			for (int j = 0; j < current.length(); j++) {
        				if (c == current.charAt(j)) {
        					continue;
        				}
        				curArr[j] = c;
        				String tmp = new String(curArr);
        				if (tmp.equals(end)) {
        					return len + 1;
        				}
        				if (dict.contains(tmp)) {
        					queue.offer(tmp);
        					dict.remove(tmp);
        				}
        				
        			}
        		}
        	}
        	len++;
        }
        return 0;
	}
	
	
	public static void main(String[] args) {
		HashSet<String> set= new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(ladderLength("a", "c", set));
		System.out.println(ladderLength2("a", "c", set));

	}

}
