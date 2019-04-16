
public class MazePrinter {

	Maze maze;

	public static void main(String[] args) {
		Maze maze = new Maze(3);
		MazePrinter mp = new MazePrinter(maze);
		mp.print();
	}

	MazePrinter(Maze maze) {
		this.maze = maze;
	}

	void print() {
		String ret = "";

		// Top Border
		ret += "+ +";
		for (int i = 0; i < maze.r - 1; i++) {
			ret += "-+";
		}
		

		// Inner Lines
		for (int i = 0; i < maze.r; i++) { // All Rows
			ret += "\n";
			ret += "|";

			for (int j = i * maze.r; j < (maze.r * (i+1)); j++) { // A Row

				ret += " ";

				if (maze.cells[j].walls.contains(j + 1) || (j+1)%maze.r==0) 
					ret += "|";
				else
					ret += " ";

			}
			ret += "\n";
			
			//Plus row
			ret += "+";

			for (int j = i * maze.r; j < maze.r; j++) { // A Row

				if (maze.cells[j].walls.contains(j + maze.r))
					ret += "-";
				else
					ret += " ";
				
				ret += "+";
			}
			
//			ret += "\n";
			
		}
		
		// Bot Border
		for (int i = 0; i < maze.r - 1; i++) {
			ret += "-+";
		}
		ret += " +";
		
		System.out.println(ret);
	}
}
