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

        private void helper(int v, boolean[] visited, Stack stack) {
            visited[v] = true;
            Integer i;
            // loop all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[v].iterator();
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
    }


}
