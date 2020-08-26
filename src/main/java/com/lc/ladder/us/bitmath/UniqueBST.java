package com.lc.ladder.us.bitmath;

public class UniqueBST {
    // We can find the number of BSTs recursively as :
    // Choose 1 as root, no element  on the left sub-tree. n-1 elements on the right sub-tree.
    // Choose 2 as root, 1 element  on the left sub-tree. n-2 elements on the right sub-tree.
    // Choose 3 as root, 2 element on the left sub-tree. n-3 elements on the right sub-tree.

    // Similarly, for i-th element as the root, i-1 elements on the left and n-i on the right.

    // These sub-trees are also BSTs so we can write :

    // C(n) = C(0)C(n-1) + C(1)C(n-2) + .....+ C(i-1)C(n-i)..... + C(n-1)C(0)

    // C(0) = 1, as there is exactly 1 way to make a BST with 0 nodes. C(1) = 1, as there is exactly 1 way to make a BST with 1 node.

    public int numTrees(int n) {
        int[] N = new int[n + 1];
        N[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                N[i] += N[j] * N[i - j - 1];
            }
        }
        return N[n];
    }
}
