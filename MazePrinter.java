import java.util.ArrayList;
import java.util.Arrays;

public class MazePrinter {

	Maze maze;
	String blank;
	String dfs;
	ArrayList<Integer> dfsSol;

	public static void main(String[] args) {
		Maze maze = new Maze(3);
		MazePrinter mp = new MazePrinter(maze);
		mp.printDFS();
	}

	void printDFS() {
		System.out.println(dfs);
		
	}

	public void add(DFS dfs) {
		this.dfs = "";
		dfsSol = new ArrayList<>();
		int[] dfsA = dfs.solve();

		for (int tile : dfsA) {
			dfsSol.add(tile);
		}
		
		this.dfs = addSol(dfsSol);

	}
	
/*	public void add(BFS bfs) {
		this.bfs = "";
		bfsSol = new ArrayList<>();
		int[] bfsA = bfs.solve();

		for (int tile : bfsA) {
			bfsSol.add(tile);
		}
		
		this.bfs = addSol(bfsSol);

	}*/
	
	public String addSol(ArrayList solution) {

		String mazeString = blank;

		StringBuilder sb = new StringBuilder(mazeString);
		int index = (maze.r * 2) + 3;

		int tile = 0;

		for (int i = 0; i < maze.r; i++) {
			for (int j = 0; j < maze.r; j++) {
				if (dfsSol.contains(tile)) {
/*					if(maze.r<4)
					sb.setCharAt(index, tile);
					else*/
						sb.setCharAt(index, '#');
				}
				index+=2;
				tile++;
			}
			index+= (maze.r*2)+4;
		}
		
		return sb.toString();
	}

	MazePrinter(Maze maze) {
		this.maze = maze;
		blank();
	}

	
	
	void print() {
		System.out.println(blank);
	}

	void blank() {
		blank = "";

		// Top Border
		blank += "+ +";
		for (int i = 0; i < maze.r - 1; i++) {
			blank += "-+";
		}

		// Inner Lines
		for (int i = 0; i < maze.r; i++) { // All Rows
			blank += "\n";
			blank += "|";

			for (int j = i * maze.r; j < (maze.r * (i + 1)); j++) { // A Row

				blank += " ";

				if (maze.cells[j].walls.contains(j + 1) || (j + 1) % maze.r == 0)
					blank += "|";
				else
					blank += " ";

			}
			blank += "\n";

			// Plus row
			blank += "+";
			if (i < maze.r - 1)
				for (int j = i * maze.r; j < (maze.r * (i + 1)); j++) { // A Row

					if (maze.cells[j].walls.contains(j + maze.r))
						blank += "-";
					else
						blank += " ";

					blank += "+";
				}

//			blank += "\n";

		}

		// Bot Border
		for (int i = 0; i < maze.r - 1; i++) {
			blank += "-+";
		}
		blank += " +";
	}
}
