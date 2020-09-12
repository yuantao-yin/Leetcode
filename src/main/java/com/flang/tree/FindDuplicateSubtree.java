package com.flang.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
652. Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.
 */
public class FindDuplicateSubtree {

    Map<String, Integer> map;
    List<TreeNode> list;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // use map to store each 3 nodes as string and count the occurrence
        map = new HashMap();
        // for every 2 string that is same, save to the list
        list = new ArrayList<>();
        duplicate(root);
        return list;
    }

    private String duplicate(TreeNode node) {
        // base case
        if (node == null) {
            return "X";
        }
        String l = duplicate(node.left);
        String r = duplicate(node.right);
        String s = node.val + "," + l + "," + r; // 1,X,X
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            list.add(node);
        }
        return s;
    }

}






