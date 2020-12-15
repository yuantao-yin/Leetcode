package com.flang.topological;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    class Graph {
        private int V;
        private LinkedList<Integer> adj[]; // adjacency list

        public Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; i++) {
                adj[i] = new LinkedList();
            }

        }

        void addEdge(int v, int e) {
            adj[v].add(e);
        }

        void topologicalSort() {
            Stack stack = new Stack();
            // mark all vertics as not visited
            boolean visited[] = new boolean[V];
            Arrays.fill(visited, false);

            // call the recursive helper
            for (int i=0; i < V; i++) {
                if (visited[i] == false) {
                    helper(i, visited, stack);
                }
            }

            while(!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

        }

        /**
         * This method takes the vertex v and makes a recursive call to its unvisited neighboring vertices.
         * It chooses from one of the children nodes and then moves down and mark the children node of that vertex.
         * If it finds that a certain vertex has no neighbors or unvisited neighbors, it pushes this vertex into the
         * stack and traverses back to the last vertex. This process checks if the vertex it has other unvisited
         * children nodes. The same cycle then continues once all the nodes have been checked.
         * @param v
         * @param visited
         * @param stack
         */
        private void helper(int v, boolean[] visited, Stack stack) {
            visited[v] = true;
            Integer i;
            // loop all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].listIterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i]) {
                    helper(i, visited, stack);
                }
            }
            // push current vertex to stack
            stack.push(new Integer(v));
        }
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        Graph g = ts.new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();

        int [][] test = new int[][]{{1,2},{2,3},{4,5}};
        System.out.println(test.length);
        System.out.println(test[0].length);
    }


}
