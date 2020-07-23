/*
/ Reads a graph from standard input, and queries Problem2.detectCycle
/ to deterine if the graph contains a cycle. If there is a cycle,
/ prints out the vertices of cycle, otherwise, prints out "no cycle detected".
/ See graph.in for example for the expected format, first 2 numbers n and m,
/ the number of vertices of the graph and the number of edges of the graph respectively.
/ Then m lines with two numbers u and v, indicating that there is an edge between u and v.
/ Run in console as 'java Mazedriver < graph.in'
*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DetectCycleDriver{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tokens[] = br.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for (int i = 0; i <  n; i++) edges.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			tokens = br.readLine().split(" ");
			int u = Integer.parseInt(tokens[0]);
			int v = Integer.parseInt(tokens[1]);
			edges.get(u).add(v);
			edges.get(v).add(u);
		}
		
		ArrayList<Integer> cycle = Problem2.detectCycle(edges);
		if (cycle == null){
			System.out.println("no cycle detected");
			System.exit(42);
		}
		for (int u: cycle) System.out.printf("%d ", u);
		System.out.println(cycle.get(0));
	}
}
