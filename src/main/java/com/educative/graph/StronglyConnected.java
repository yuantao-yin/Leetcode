package com.educative.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class StronglyConnected {
    public static void utilityFunction(Graph g, int v, boolean visited[]) {
        visited[v] = true;
        LinkedList<Integer> adj[] = g.getAdj();
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()) {
            int temp = i.next();
            if (!visited[temp]) {
                utilityFunction(g, temp, visited);
            }
        }
    }


    public static Object isStronglyConnected(Graph g) {
        int v = g.getVertices();
        boolean visited[] = new boolean[v];
        utilityFunction(g, 0, visited);
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        // reset visited[]
        for (int i  = 0; i < v; i++) {
            visited[i] = false;
        }
        Graph tg = g.getTranspose();
        utilityFunction(tg, 0, visited);
        for (boolean visit : visited) {
            if (!visit) return false;
        }
        return true;
    }

}
