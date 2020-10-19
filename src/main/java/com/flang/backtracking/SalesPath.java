package com.flang.backtracking;

public class SalesPath {

    static class Node {

        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }

    static int getCheapestCost(Node rootNode) {
        // your code goes here
        if (rootNode.children == null || rootNode.children.length == 0) return rootNode.cost;
        int len = rootNode.children.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int cur = getCheapestCost(rootNode.children[i]);
            if (cur < min) {
                min = cur;
            }
        }
        return min + rootNode.cost;
    }

    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(4);
        Node node5 = new Node(2);
        Node node6 = new Node(0);
        Node node7 = new Node(1);
        Node node8 = new Node(5);
        Node node9 = new Node(1);
        Node node10 = new Node(10);
        node0.children = new Node[3];
        node0.children[0] = node1;
        node0.children[1] = node2;
        node0.children[2] = node3;

        node1.children = new Node[1];
        node1.children[0] = node4;

        node2.children = new Node[2];
        node2.children[0] = node5;
        node2.children[1] = node6;

        node3.children = new Node[2];
        node3.children[0] = node7;
        node3.children[1] = node8;
        node5.children = new Node[1];
        node5.children[0] = node9;
        node6.children = new Node[1];
        node6.children[0] = node10;

        System.out.println(SalesPath.getCheapestCost(node0));
    }
}