import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem3{
	public static ArrayList<Pos> findPath(Pos start, Pos end, boolean maze[][]){
	    Queue<Pos> q = new LinkedList<Pos>();
	    boolean marked[][] = new boolean[maze.length][maze[0].length];
	    ArrayList<Pos> shortestPath = new ArrayList<Pos>();
	    
	    marked[start.x][start.y] = true;
	    q.add(new Pos(start.x, start.y));
	    
	    while(!q.isEmpty()) {
	        Pos v = q.remove();
	        if (v.compareTo(end) == 0) {
	            Stack<Pos> s = new Stack<Pos>();
	            //backtrack through parents and add to stack
	            while(v != null) {
	                s.add(v);
	                v = v.parent;
	            }
	            while (!s.isEmpty()) shortestPath.add(s.pop());
	            return shortestPath;
	        } 
	        for (Pos p : getAdj(v, maze)) {
	            if (!marked[p.x][p.y]) {
	                marked[p.x][p.y] = true;
	                p.parent = v;
	                q.add(p);
	            }
	        }
	    }
	    return null;
	}
	
	/**
	 * 
	 * @param pos current position
	 * @param parent parent position
	 * @param maze the maze to check for adj in
	 * @return an Arraylist<Pos> containing all valid adj pos
	 */
	private static ArrayList<Pos> getAdj(Pos pos, boolean maze[][]) {
	    int xBoundery = maze.length;
	    int yBoundery = maze[0].length;
	    ArrayList<Pos> adj = new ArrayList<Pos>();
	    
	    //check if each adj pos is within boundaries of maze and not wall
	    if (pos.x+1 < xBoundery && maze[pos.x+1][pos.y]) adj.add(new Pos(pos.x+1, pos.y)); //right adj
	    if (pos.x-1 >= 0 && maze[pos.x-1][pos.y])        adj.add(new Pos(pos.x-1, pos.y)); //left adj
	    if (pos.y+1 < yBoundery && maze[pos.x][pos.y+1]) adj.add(new Pos(pos.x, pos.y+1)); //down adj
	    if (pos.y-1 >= 0 && maze[pos.x][pos.y-1])        adj.add(new Pos(pos.x, pos.y-1)); //up adj
	    return adj;
	}
}
