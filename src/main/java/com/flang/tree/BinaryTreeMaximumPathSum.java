package com.flang.tree;

/*
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes
from some starting node to any node in the tree along the
parent-child connections. The path must contain at least one node
and does not need to go through the root.

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int rst = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return rst;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        rst = Math.max(rst, left + right + root.val);
        return root.val + Math.max(left, right);
    }

}
