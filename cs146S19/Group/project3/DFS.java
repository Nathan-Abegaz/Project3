package cs146S19.Group.project3;
import java.util.Stack;

/**
 * This is the DFS object that will take in a maze and solve it
 * @author Huynh & Nathan
 *
 */
public class DFS {

	private static final int WHITE = 0;   //Define white
	private static final int GREY = 1;    //Define grey
	private static final int BLACK = 2;   //Define black

	private Maze maze;  //the maze being solved

	int distance = 0;   //The distance of what DFS has traveled

	Stack<Integer> stack;        //Will be the stack to track what is discovered or not
	Stack<Integer> answerStack;  //Will be the stack of the quickest solution

	/**
	 * This constructor is the creation of the DFS object using the maze
	 * @param maze is the maze being solved
	 */
	DFS(Maze maze) {
		this.maze = maze;
		this.stack = new Stack<Integer>();
		this.answerStack = new Stack<Integer>();

	}

	/**
	 * This method will solve using DFS
	 * It is the wrapper for the recursive element
	 * @return the int array of the solution
	 */
	int[] solve() {
		for (int i = 0; i < maze.cells.length; i++) { //First,
			maze.cells[i].vis = WHITE;                 //Initialize the cells as being WHITE, or undiscovered
		}
		distance = 0;   //distance is 0 as nothing is traversed

		DFS_Visit(maze.cells[0]);   //The only starting point will be the entrance space. DFS_Visit is the start of the recursion. In it, stack AND answerStack will be finalized

		int[] ret = new int[answerStack.size()];   //The int array of the solution is initialized to the length of the quickest solution
		for (int i = ret.length - 1; i >= 0; i--) {//Copy stack to the solution array
			ret[i] = answerStack.pop();
		}
		return ret;  //return solution
	}

	/**
	 * This is the recursive DFS method
	 * @param cell is the cell being visited currently
	 */
	void DFS_Visit(Cell cell) {
		stack.push(cell.index);  //Push the cell being traversed onto the stack
		distance++;  //The stack has grown by 1
		if (cell.index == (maze.r * maze.r) - 1) { //If the DFS has reached the exit of the maze
			// System.out.println(distance);
			answerStack = (Stack<Integer>) stack.clone();   //Copy the current stack onto the answer stack
		}
		cell.vis = GREY;      //Set the current cell to "in progress", or GREY
		for (int i = 0; i < cell.edges.size(); i++) { //For all spaces connected to this cell
			if (maze.cells[cell.edges.get(i)].vis == WHITE) {  //If they are undiscovered
				DFS_Visit(maze.cells[cell.edges.get(i)]);   //Traverse through them and recurse
			}
		}
		
		//Once all further paths are found without the exit being found, the cell is no longer useful
		distance--;        //The stack lessens by 1
		cell.vis = BLACK;  //Because it is discovered, BLACK
		stack.pop();       //And has been popped from the stack as DFS goes backwards to find a new path

	}
}