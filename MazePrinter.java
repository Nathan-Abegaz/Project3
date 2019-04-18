
public class MazePrinter {

	Maze maze;
	String blank;
	int[] dfsSol;
	

	public static void main(String[] args) {
		Maze maze = new Maze(10);
		MazePrinter mp = new MazePrinter(maze);
		mp.print();
	}
	
	public void add(DFS dfs) {
		dfsSol = dfs.solve();
	}

	MazePrinter(Maze maze) {
		this.maze = maze;
		blank();
		print();
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

			for (int j = i * maze.r; j < (maze.r * (i+1)); j++) { // A Row

				blank += " ";

				if (maze.cells[j].walls.contains(j + 1) || (j+1)%maze.r==0) 
					blank += "|";
				else
					blank += " ";

			}
			blank += "\n";
			
			//Plus row
			blank += "+";
			if(i<maze.r-1)
			for (int j = i * maze.r; j < (maze.r * (i+1)); j++) { // A Row

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
		
		System.out.println(blank);
	}
}
