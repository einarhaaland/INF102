import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Problem2{
    
    private static ArrayList<ArrayList<Integer>> graph;
    private static Stack<Integer> stack = new Stack<Integer>(); //temporary stack to hold path where cycle was found
    private static int cycleStart; //first discovered vertice part of cycle
    
	public static ArrayList<Integer> detectCycle (ArrayList<ArrayList<Integer>> edges){
	    graph = edges;
	    int vCount = edges.size();
	    boolean[] markedVertices = new boolean[vCount];
	    //call dfs for every non-visited vertice
	    for (int i = 0; i < vCount; i++) {
	        if (!markedVertices[i]) {
	            if (dfs(i, -1, markedVertices)) {
	                ArrayList<Integer> cycle = new ArrayList<Integer>();
	                stack.add(i); // add first vertex of path containing cycle
	                
	                //reverse and isolate vertices part of cycle
	                while(stack.peek() != cycleStart) stack.pop(); //pop vertices not part of cycle
	                while (!stack.isEmpty()) cycle.add(stack.pop()); //add vertices part of cycle
	                return cycle;
	            }
	        }
	    }
	    return null;
	}
	
	/**
	 * 
	 * @param vert current vertice
	 * @param parent parent of current vertice
	 * @param markedVertices array of boolean visited vertices
	 * @return bool is part of path containing cycle
	 */
	private static boolean dfs(int vert, int parent, boolean[] markedVertices) {
	    markedVertices[vert] = true;
	    
	    //loop through every adjacent vertex
	    for (Iterator<Integer> it = graph.get(vert).iterator(); it.hasNext();) {
	        int i = it.next();
	        if (!markedVertices[i]) {
	            if (dfs(i, vert, markedVertices)) { //found cycle deeper in this path
	                stack.add(i);
	                return true;
	            }
	        }
	        else if (i != parent) {
	            cycleStart = i;
	            return true; //found cycle
	        }
	    }
	    return false;
	}
}
