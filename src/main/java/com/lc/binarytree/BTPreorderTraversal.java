package com.lc.binarytree;

import java.util.*;


public class BTPreorderTraversal {

	/**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	rst.add(node.val);
        	if (node.right != null) {
        		stack.push(node.right);
        	}
        	if (node.left != null) {
        		stack.push(node.left);
        	}
        }
        
        return rst;
    }
    
}
