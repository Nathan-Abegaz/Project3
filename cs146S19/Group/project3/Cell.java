package cs146S19.Group.project3;

/*
 * The cell class would be use to create the maze
 * Each cell would have a list of all walls and edges
 * with each cell would keep track whether the cell was discovered
 * and the index.
 * 
 * @author Huynh & Nathan
 */
import java.util.ArrayList;

public class Cell {

	ArrayList<Integer> walls = new ArrayList();
	ArrayList<Integer> edges = new ArrayList();
	public boolean discovered = false;
	public int index;
	public int vis;

	public Cell(int index) {
		this.index = index;
	}

	/*
	 * Adds cell to the list of cells with walls
	 * 
	 * @param i,adding index of cell to the list of walls
	 */
	public void add(int i) {
		walls.add(i);
	}

	/*
	 * Checks if the cell has neighboring walls
	 * 
	 * @return true/false
	 */
	public boolean checkWalls() {
		if (walls.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Delete cell from list of walls and add it to the list of
	 * edges/connections
	 * 
	 * @param newCell
	 */

	public void dnc(Cell newCell) {
		walls.remove(walls.indexOf(newCell.index));
		edges.add(newCell.index);
		discovered = true;
	}

}
