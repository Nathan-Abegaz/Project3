import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

	public int[] solve() {
	
		////each v will be v.color=WHITE 
		for (int i = 0; i < maze.cells.length; i++) {
			maze.cells[i].vis = WHITE;
		}
		// ENQUEUE(Q,s);
		queue.add(maze.cells[0].index);

		//  while (Q not empty) 
		while (!queue.isEmpty()) {
			
			// u = DEQUEUE(Q);
			int index = queue.remove();
			Cell u = maze.cells[index];

			// for each v ∈ G.adj[u]
			for (int i = 0; i < u.edges.size(); i++)
			{
				Cell v = maze.cells[u.edges.get(i)];
				if (v.vis == WHITE) 
				{
					// v.color = GREY;
					v.vis = GREY;
					
					// v.π = u; 
					// Adding predecessor to and answerList
					 //answerList.add(u.index);
					
					//Enqueue(Q, v); 
					queue.add(u.edges.get(i));
									
					
				}
			}
			//u.color = BLACK; 
			u.vis = BLACK;
			System.out.println(u.index + " Has been fully visited");
			answerList.add(u.index);
			if(u.index == (maze.r * maze.r) - 1)
			{
				int[] listArray = new int[answerList.size()];
				for(int i  = 0; i < listArray.length; i ++)
				{
					listArray [i] = answerList.get(i);				
				}
				return listArray;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze(3);
		MazePrinter mp = new MazePrinter(maze);
		BFS bfs = new BFS(maze);
		bfs.solve();
		mp.add(bfs);
		mp.printBFS();
		//System.out.print(bfs.answerList.toString());

	}


}
