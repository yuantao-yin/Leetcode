package com.lc.binarytree;

import java.util.*;

public class BTInorderTraversal {

	/**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
        	if (node != null) {
        		stack.push(node);
        		node = node.left;
        	} else {
        		node = stack.pop();
        		rst.add(node.val);
        		node = node.right;
        	}
        }
        
        return rst;
    }
}
