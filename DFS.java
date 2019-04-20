package cs146S19.Group.project3;
import java.util.Stack;
import java.util.Vector;

public class DFS {

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	private Maze maze;

	int distance = 0;

	Stack<Integer> stack;
	Stack<Integer> answerStack;

	DFS(Maze maze) {
		this.maze = maze;
		this.stack = new Stack<Integer>();
		this.answerStack = new Stack<Integer>();

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
		int[] ret = new int[answerStack.size()];
		for (int i = ret.length - 1; i >= 0; i--) {
			ret[i] = answerStack.pop();
		}
		return ret;
	}

	Stack<Integer> DFS_Visit(Cell cell) {
		stack.push(cell.index);
		distance++;
		if (cell.index == (maze.r * maze.r) - 1) {
			// System.out.println(distance);
			answerStack = (Stack<Integer>) stack.clone();
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

	public int[] solveNum() {
		int[] ret = new int[answerStack.size()];
		for (int i = ret.length - 1; i >= 0; i--) {
			ret[i] = answerStack.pop();
		}
		return ret;
	}

}
