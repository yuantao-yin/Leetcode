package com.educative.graph;

import java.util.*;

class Graph {
    private int vertices; //number of vertices
    private LinkedList < Integer > adjacencyList[]; //Adjacency Lists
    @SuppressWarnings("unchecked")
        // Constructor
    Graph(int vert) {
        this.vertices = vert;
        this.adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < this.vertices; ++i)
            this.adjacencyList[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public int getVertices() {
        return this.vertices;
    }

    public LinkedList < Integer > [] getAdj() {
        return this.adjacencyList;
    }

    public Graph getTranspose() {
        Graph g = new Graph(vertices);
        for (int j = 0; j < vertices; j++) {
            Iterator < Integer > i = adjacencyList[j].listIterator();
            while (i.hasNext())
                g.adjacencyList[i.next()].add(j);
        }
        return g;
    }
};
