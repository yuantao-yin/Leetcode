package com.flang.bfs;

import java.util.*;

/**
 * LC hard 127
 *      1. Put wordlist into Hashset to clean duplicate word
 *      2. Use BFS，create Queue and HashSet for visited word
 *      3. Ladder includes beginWord，step initial to 1
 *      4. Loop queue
 *      5. Modify each character in the word to get nextWord, if nextWord is in the wordlist and equals  to the endword, return step+1.
 *      6. If nextWord is in the wordlist and but is not visited, add it to the queue and mark it as visited
 *      7. Reset the word to origin after each word’s looping
 *      8. Increase step on each BFS layer
 *      9. Return 0 if not find the endword
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        int step = 1;
        Set<String> wordSet = new HashSet(wordList);
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                int len = word.length();
                char[] charArray = word.toCharArray();
                for (int j = 0; j < len; j++) {
                    char origin = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == charArray[j]) continue;
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(nextWord)) {
                                queue.offer(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }
                    charArray[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }
}
