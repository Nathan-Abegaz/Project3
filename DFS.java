import java.util.Stack;

public class DFS {

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;
	
	private Maze maze;
	
	int distance = 0;
	
	Stack<Integer> stack;

	public static void main(String[] args) {
		
	}
	
	DFS(Maze maze) {
		this.maze = maze;
		for(int i=0; i<maze.cells.length; i++) {
			maze.cells[i].vis = WHITE;
		}
		distance = 0;
	//	for(int i=0; i<maze.cells.length; i++) {
	//		if(maze.cells[i].vis==WHITE)
				DFS_Visit(maze.cells[0]);
	//	}
		int[] ret = new int[stack.size()];
		for(int i = ret.length-1; i>=0; i--) {
			ret[i]=stack.pop();
		}
		
		System.out.println(ret.toString());
	}
	
	void DFS_Visit(Cell cell) {
		stack.push(cell.index);
		distance++;
		if(cell.index==maze.r*maze.r)
			System.out.println(distance);
		cell.vis = GREY;
		for(int i= 0; i<cell.edges.size(); i++) {
			if(maze.cells[cell.edges.get(i)].vis==WHITE) {
				DFS_Visit(maze.cells[cell.edges.get(i)]);
			}
		}
		distance--;
		stack.pop();
		cell.vis = BLACK;
		
	}

}
