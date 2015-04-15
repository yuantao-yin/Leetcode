package com.lc.graph_search;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
 
public class DFS_Graph
{
    private Stack<Integer> stack;
 
    public DFS_Graph() 
    {
        stack = new Stack<Integer>();
    }
 
    public void findAllGraph(int adjacency_matrix[][], int size) {
    	int count = 0;
    	Set<Integer> set = new HashSet<Integer>();
    	for (int i = 1; i <= size; i++) {
    		if (set.contains(i)) {
    			continue;
    		} else {
    			set = dfs(adjacency_matrix, i);
    			count++;
    		}
    		
    	}
    	System.out.print(count);
    }
    public Set<Integer> dfs(int adjacency_matrix[][], int source)
    {
    	Set<Integer> set = new HashSet<Integer>();
    	
        int number_of_nodes = adjacency_matrix[source].length - 1;
        int visited[] = new int[number_of_nodes + 1];		
        int element = source;		
        int i = source;		
        System.out.print(element + "\t");
        set.add(element);
        visited[source] = 1;		
        stack.push(source);
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = element;	
	    while (i <= number_of_nodes)
	    {
     	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)
	        {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    System.out.print(element + "\t");
                    set.add(element);
	            continue;
                }
                i++;
	    }
            stack.pop();	
        }
        System.out.println();
        return set;
    }
 
    public static void main(String...arg)
    {
        int number_of_nodes, source;
        Scanner scanner = null;
 	try
        {
	    //System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
 
	    int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];
	    //System.out.println("Enter the adjacency matrix");
	    String row = "";
	    for (int i = 1; i <= number_of_nodes; i++) {
	    	row = scanner.next();
	    	char[] charList = row.toCharArray(); 
	    	for (int j = 1; j <= number_of_nodes; j++) {
	    		int number = charList[j-1] == 'Y' ? 1 : 0;
	    		adjacency_matrix[i][j] = number;
	    	}
                
	    }

//	    System.out.println("Enter the source for the graph");
//            source = scanner.nextInt(); 
 
            //System.out.println("The DFS Traversal for the graph is given by ");
            DFS_Graph dfs = new DFS_Graph();
            dfs.findAllGraph(adjacency_matrix, number_of_nodes);					
        }catch(InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }	
        scanner.close();	
    }	
}
