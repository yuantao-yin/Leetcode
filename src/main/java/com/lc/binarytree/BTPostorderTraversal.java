package com.lc.binarytree;

import java.util.*;


public class BTPostorderTraversal {
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> output = new Stack<TreeNode>();
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        s.push(root);
        while (!s.isEmpty()) {
        	output.push(s.pop());
        	if (root.left != null) {
        		s.push(root.left);
        	}
        	if (root.right != null) {
        		s.push(root.left);
        	}
        }
        while (!output.isEmpty()) {
        	rst.add(output.pop().val);
        }
        return rst;
    }
	
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        helper(rst, root); 
        return rst;
    }
    
    private ArrayList<Integer> helper(ArrayList<Integer> rst, TreeNode node) {
        if (node == null) {
            return rst;
        }
        helper(rst, node.left);
        helper(rst, node.right);
        rst.add(node.val);
        return rst;
    }
    
}
