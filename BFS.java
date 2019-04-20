package cs146S19.Group.project3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * BFS class implements the Breadth-First Search Algorithm.
 * The class keep tracks of all the vertices by first initializing all vertices to 
 * white. Afterwards the algorithm searches through the cells by discovering all of the 
 * cell's edges before moving on to the next cell. Once a cell has been discovered 
 * the cell turns grey. After all of the cell's edges have been discovered, the cell turns 
 * black. The algorithm utilizes a queue to store all 
 * the discovered cells. The time complexity of this algorithm is O(V + E)
 * 
 * @author Huynh & Nathan
 */
public class BFS {

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	private Maze maze;

	int distance = 0;

	Queue<Integer> queue;
	ArrayList<Integer> answerList = new ArrayList<Integer>();

	BFS(Maze maze) {
		this.maze = maze;
		this.queue = new LinkedList<Integer>();
	}

	/*
	 * This method solves the maze by utilizing the BFS algorithm
	 */
	public int[] solve() {

		//// each v will be v.color=WHITE
		for (int i = 0; i < maze.cells.length; i++) {
			maze.cells[i].vis = WHITE;
		}
		// ENQUEUE(Q,s);
		queue.add(maze.cells[0].index);

		// while (Q not empty)
		while (!queue.isEmpty()) {

			// u = DEQUEUE(Q);
			int index = queue.remove();
			Cell u = maze.cells[index];

			// for each v ∈ G.adj[u]
			for (int i = 0; i < u.edges.size(); i++) {
				Cell v = maze.cells[u.edges.get(i)];
				if (v.vis == WHITE) {
					// v.color = GREY;
					v.vis = GREY;

					// Enqueue(Q, v);
					queue.add(u.edges.get(i));

				}
			}
			// u.color = BLACK;
			u.vis = BLACK;
			answerList.add(u.index);
			if (u.index == (maze.r * maze.r) - 1) {
				int[] listArray = new int[answerList.size()];
				for (int i = 0; i < listArray.length; i++) {
					listArray[i] = answerList.get(i);
				}
				return listArray;
			}
		}
		return null;
	}

}
