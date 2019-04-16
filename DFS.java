import java.util.Stack;

public class DFS {

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	private Maze maze;

	int distance = 0;

	Stack<Integer> stack;

	public static void main(String[] args) {
		Maze maze = new Maze(3);
		DFS dfs = new DFS(maze);

		int[] dfsSolved = dfs.solve();
		for (int j : dfsSolved) {
			System.out.println(" " + j);
		}

	}

	DFS(Maze maze) {
		this.maze = maze;
		this.stack = new Stack<Integer>();

	}

	int[] solve() {
		for (int i = 0; i < maze.cells.length; i++) {
			maze.cells[i].vis = WHITE;
		}
		distance = 0;
		// for(int i=0; i<maze.cells.length; i++) {
		// if(maze.cells[i].vis==WHITE)
		DFS_Visit(maze.cells[0]);
		// }
			int[] ret = new int[stack.size()];
			for (int i = ret.length-1; i >= 0; i--) {
				ret[i] = stack.pop();
			}
			return ret;
	}

	Stack<Integer> DFS_Visit(Cell cell) {
		stack.push(cell.index);
		distance++;
		if (cell.index == (maze.r * maze.r) - 1) {
			System.out.println(distance);
		//WE NEED TO COPY OVER THE SOLUTION	 stack;//SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
			// need to break
		}
		cell.vis = GREY;
		for (int i = 0; i < cell.edges.size(); i++) {
			if (maze.cells[cell.edges.get(i)].vis == WHITE) {
				DFS_Visit(maze.cells[cell.edges.get(i)]);
			}
		}
		distance--;
		cell.vis = BLACK;
		stack.pop();
		return null;

	}

}
