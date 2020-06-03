package com.code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
    public int vertexNum;
    public Neighbor next;
    public Neighbor(int vnum, Neighbor nbr) {
            this.vertexNum = vnum;
            next = nbr;
    }
}

class Vertex {
    String name;
    Neighbor adjList;
    Vertex(String name, Neighbor neighbors) {
            this.name = name;
            this.adjList = neighbors;
    }
}

public class Graph {
	Vertex[] adjLists;
	
	boolean undirected=true;
	
	public Graph(String file) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(file));
		
		String graphType = sc.next();
		if (graphType.equals("directed")) {
			undirected=false;
		}
		
		adjLists = new Vertex[sc.nextInt()];

		// read vertices
		for (int v=0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}

		// read edges
		while (sc.hasNext()) {
			
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			// add v2 to front of v1's adjacency list and
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			if (undirected) {
				// add v1 to front of v2's adjacency list
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
			}
		}
		
		sc.close();
	}
	
	int indexForName(String name) {
		for (int v=0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}	
	
	public void print() {
		System.out.println();
		for (int v=0; v < adjLists.length; v++) {
			System.out.print(adjLists[v].name);
			for (Neighbor nbr=adjLists[v].adjList; nbr != null;nbr=nbr.next) {
				System.out.print(" --> " + adjLists[nbr.vertexNum].name);
			}
			System.out.println("\n");
		}
	}
	
	public void dfs() {
		 boolean[] visited = new boolean[adjLists.length];
		 for (int v=0; v < visited.length; v++) {
			 visited[v] = false;
		 }
		 for (int v=0; v < visited.length; v++) {
			 if (!visited[v]) {
				 System.out.println("\nSTARTING AT " + adjLists[v].name + "\n");
				 dfs(v, visited);
			 }
		 }
	 }
	
	// recursive dfs
	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("\tvisiting " + adjLists[v].name);
		for (Neighbor e=adjLists[v].adjList; e != null; e=e.next) {
			if (!visited[e.vertexNum]) {
				System.out.println("\t" + adjLists[v].name + "--" + adjLists[e.vertexNum].name);
				dfs(e.vertexNum, visited);
			}
		}
	}
	
	public String[] topologicalSort() {
		boolean[] visited = new boolean[adjLists.length];
		String[] topnums = new String[adjLists.length];
		
		int n = adjLists.length-1;
		 for (int v=0; v < visited.length; v++) {
			 if (!visited[v]) {
				 n = topsort(v, visited, topnums, n);
			 }
		 }
		 return topnums;
	}
	
	private int topsort(int v, boolean[] visited, String[] topnums, int n) {
		visited[v] = true;
		for (Neighbor e=adjLists[v].adjList; e != null; e=e.next) {
			if (!visited[e.vertexNum]) {
				n = topsort(e.vertexNum, visited, topnums, n);
			}
		}
		// finished looking at all neighbors
		topnums[n] = adjLists[v].name;
		return n-1;
	}
	
	public static void main(String[] args) 
			throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		sc.close();
		graph.print();

		System.out.println("Doing DFS...");
		graph.dfs();
		
		if (file.equals("website2.txt")) {
			System.out.println("\n\nDoing DFS topsort...");
			String[] topseq = graph.topologicalSort();
			for (int i=0; i < topseq.length; i++) {
				System.out.println(topseq[i]);
			}		 
		}
		
	}

}
