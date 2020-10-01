package com.flang.topological;

import java.util.HashMap;
import java.util.Map;
/*
1. Time Complexity
If the longest length of the word is N, the height of Trie will be N + 1.
Therefore, the time complexity of all insert, search and startsWith methods will be O(N)

The time complexity to search in hash table is typically O(1), but will be O(logN) in the
 worst time if there are too many collisions and we solve collisions using height-balanced BST.

2. Space Complexity
If we have M words to insert in total and the length of words is at most N, there will be at most M*N nodes in the worst case (any two words don't have a common prefix).

Let's assume that there are maximum K different characters (K is equal to 26 in this problem, but might differs in different cases). So each node will maintain a map whose size is at most K.

Therefore, the space complexity will be O(M*N*K)



 */
class Trie {

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> childrenMap = new HashMap();
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.childrenMap.get(ch) == null) {
                cur.childrenMap.put(ch, new TrieNode());
            }
            cur = cur.childrenMap.get(ch);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.childrenMap.get(ch) == null) {
                return false;
            }
            cur = cur.childrenMap.get(ch);
        }
        // note: use isWord flag here
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
