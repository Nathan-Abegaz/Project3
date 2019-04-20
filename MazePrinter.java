package cs146S19.Group.project3;
import java.util.ArrayList;
import java.util.Arrays;

public class MazePrinter {

	Maze maze;
	String blank;
	String dfs;
	String dfsNum;
	String bfs;
	String bfsNum;
	
	void fullPrint() {
		System.out.println("Graph Size: " + maze.r + '\n' + "MAZE: ");
		print();
		System.out.println("BFS: ");
		printBFS();
		printBFSNum();
		System.out.println("DFS: ");
		printDFS();
		printDFSNum();
		System.out.println("======================\n  Program Completed!\n======================");
	}
	
	void print() {
		System.out.println(blank + '\n');
	}
	
	void printDFS() {
		System.out.println(dfs + '\n');
	}
	
	public void printDFSNum() {
		System.out.println(dfsNum + '\n');
	}
	
	public void printBFS() {
		System.out.println(bfs + '\n');
	}
	
	public void printBFSNum() {
		System.out.println(bfsNum + '\n');
	}
	public void add(DFS dfs) {
		this.dfs = "";
		ArrayList<Integer> dfsSol = new ArrayList<>();
		int[] dfsA = dfs.solve();

		for (int tile : dfsA) {
			dfsSol.add(tile);
		}
		
		this.dfs = addSol(dfsSol);
		this.dfsNum = addNumSol(dfsSol);
	}
	
	public void add(BFS bfs) {
		this.bfs = "";
		ArrayList<Integer> bfsSol = new ArrayList<>();
		int[] bfsA = bfs.solve();

		for (int tile : bfsA) {
			bfsSol.add(tile);
		}
		
		this.bfs = addSol(bfsSol);
		this.bfsNum = addNumSol(bfsSol);
	}
	
	public String addSol(ArrayList<Integer> solution) {

		String mazeString = blank;

		StringBuilder sb = new StringBuilder(mazeString);
		int index = (maze.r * 2) + 3;

		int tile = 0;

		for (int i = 0; i < maze.r; i++) {
			for (int j = 0; j < maze.r; j++) {
				if (solution.contains(tile)) {
						sb.setCharAt(index, '#');
				}
				index+=2;
				tile++;
			}
			index+= (maze.r*2)+4;
		}
		
		return sb.toString();
	}
	
	public String addNumSol(ArrayList<Integer> solution) {

		String mazeString = blank;

		StringBuilder sb = new StringBuilder(mazeString);
		int index = (maze.r * 2) + 3;

		int tile = 0;

		for (int i = 0; i < maze.r; i++) {
			for (int j = 0; j < maze.r; j++) {
				if (solution.contains(tile)) {
						sb.setCharAt(index, (char) ('0'+solution.indexOf(tile)%10));
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
