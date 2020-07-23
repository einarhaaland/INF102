/*
/ Reads a maze from standard input, and uses Problem3.findPath(start, end, maze), to find a path if one exists.
/ If a path is found, prints the cells of the path, otherwise, prints "There is no path". See
/ maze.in for example of format, first two numbers R and C, the number of rows and columns respectively,
/ then R lines of C chars each where the characters can be, '.' indicating an empty space, '#' indicating
/ a wall, 'A' indicating the starting point, and 'B' indicating the ending point. Input should contain exactly
/ one 'A' and one 'B'. Run in console as 'java MazeDriver < maze.in'.
*/

import java.util.ArrayList;
import java.io.*;

public class MazeDriver{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String token = br.readLine();
		int R = Integer.parseInt(token.split(" ")[0]);
		int C = Integer.parseInt(token.split(" ")[1]);
		boolean maze[][] = new boolean[R][C];
		Pos start = null;
		Pos end = null;
		for (int i = 0; i < R; i++){
			token = br.readLine();
			for (int j = 0; j < C; j++){
				if (token.charAt(j) == '.') maze[i][j] = true;
				else if (token.charAt(j) == '#') maze[i][j] = false;
				else if (token.charAt(j) == 'A') {
					maze[i][j] = true;
					start = new Pos(i, j);
				}
				else if (token.charAt(j) == 'B'){
					maze[i][j] = true;
					end = new Pos(i,j);
				}
				else {
					System.out.println("Illegal input format");
					System.exit(42);
				}
			}
		}
		ArrayList<Pos> path = Problem3.findPath(start, end, maze);
		if (path == null){
			System.out.println("There is no path");
			System.exit(42);
		}
		for (Pos p: path) System.out.printf("[%d,%d]\n", p.x, p.y);
	}
}
