package main.java.com.flang.tree;

/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
 */
public class RemoveNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // if the key to be deleted is smaller than the root key, then
        // it lies in the left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // key == root.val
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // both left and right is not null for current node
            TreeNode minNode = root.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // copy the smallest value under root.right to root's value
            root.val = minNode.val;
            // delete the minNode
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }
}
