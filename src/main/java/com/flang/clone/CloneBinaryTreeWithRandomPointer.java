package com.flang.clone;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTreeWithRandomPointer {

    Map<TreeNode, TreeNode> map=new HashMap<>();
    
    public TreeNode cloneTree(TreeNode root) {
        return deepCopy(root);
    }

    private TreeNode deepCopy(TreeNode root) {
        if (root == null) return null;
        if (map.get(root) != null) {
            return map.get(root);
        }
        TreeNode copy = new TreeNode(root.data);
        map.put(root, copy);
        copy.left = deepCopy(root.left);
        copy.right = deepCopy(root.right);
        copy.random = deepCopy(root.random);
        return copy;
    }
}
