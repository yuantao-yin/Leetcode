package com.flang.clone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // use the value of original node as key, map to the new copy node
        Map<Integer, Node> map = new HashMap();
        return copyGraph(node, map);
    }

    private Node copyGraph(Node node, Map<Integer, Node> map) {
        if (map.get(node.val) != null) return map.get(node.val);
        // if we don't find the key in map, that tells us we don't have the copy node of that value in the map,
        // so we need create one
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            // we have the copy node, so we need make sure we have the same connection and have access to our
            // neighbors using copy.neighbors, and we have to add in the recursive call of copyGrpah because
            // copyGrpah always return clone graph
            copy.neighbors.add(copyGraph(neighbor, map));
        }
        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
