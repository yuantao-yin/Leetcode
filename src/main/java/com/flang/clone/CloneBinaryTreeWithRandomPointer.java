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
        // if the node is already being copied, return the copied node
        if (map.get(root) != null) {
            return map.get(root);
        }
        TreeNode copy = new TreeNode(root.data);
        map.put(root, copy);
        // dfs left node
        copy.left = deepCopy(root.left);
        // dfs right node
        copy.right = deepCopy(root.right);
        copy.random = deepCopy(root.random);
        // return copy node
        return copy;
    }
}
