package cs146S19.Group.project3;

import java.util.Random;
import java.util.Stack;

/*
 * Maze class takes in the cells to construct the a random generated maze
 * 
 * @author Huynh & Nathan
 */
public class Maze {

	Cell[] cells;
	public int r;

	/*
	 * Constructor that creates the maze
	 * 
	 * @param r the size of the maze
	 */
	public Maze(int r) {
		this.r = r;
		cells = new Cell[r * r];
		createGrid();
		breakWalls();
	}

	/*
	 * Creates a fully constructed grid without any broken walls
	 */
	public void createGrid() {
		// Iterates throughout the list of cells and links them with their
		// left, right, top and bottom cell;
		for (int i = 0; i < cells.length; i++) {
			Cell newCell = new Cell(i);

			left(newCell);
			right(newCell);
			top(newCell);
			bottom(newCell);

			cells[i] = newCell;
		}

	}

	/*
	 * Uses simple maze generation algorithm that uses Depth First Search algorithm. 
	 * Breaks the walls from the grid to create the maze path
	 */
	public void breakWalls() {
		
		// Uses a stack to hold the list of cell location
		Stack<Cell> cellStack = new Stack<>();
		int totalCells = cells.length; // number of cells in a grid
		Cell currentCell = cells[0];
		int visitedCells = 1;
		while (visitedCells < totalCells) {
			boolean eligible = false;
			for (int i = 0; i < currentCell.walls.size(); i++) {
				if (!cells[currentCell.walls.get(i)].discovered)
					eligible = true;
			}
			if (currentCell.checkWalls() && eligible) {
				Cell randomCell = getRandomCell(currentCell);
				int count = 0;
				while (randomCell.discovered == true) {
					randomCell = getRandomCell(currentCell);
					count++;
				}
				deleteAndConnect(currentCell, randomCell); // knocks down wall between the two cells
				cellStack.push(currentCell);	// push current cell to the stack
				currentCell = randomCell;    // get new current cell
				visitedCells++;
			} else {
				currentCell = cellStack.pop(); // pop the most current cell from the stack
			}
		}
	}

	/*
	 * Helper method that retrieved a random cell from a the list of cells with
	 * walls intact
	 * 
	 * @param cell
	 */
	public Cell getRandomCell(Cell cell) {
		Random randomGenerator = new Random(2); //Currently seed 2
		// randomGenerator.setSeed(1);
		int index = randomGenerator.nextInt(cell.walls.size());
		Cell randomCell = cells[cell.walls.get(index)];
		return randomCell;
	}

	/*
	 * Deletes cell from the cell the list of walls and adds the cell 
	 * the list of edges
	 * @param cell1
	 * @param cell2
	 */
	public void deleteAndConnect(Cell cell1, Cell cell2) {
		cell1.dnc(cell2);
		cell2.dnc(cell1);
	}

	/*
	 * Checks if the the cell i can be positioned left
	 * @param i index
	 */
	private void left(Cell i) {
		if (i.index % r != 0)
			i.add(i.index - 1);
	}

	/*
	 * Checks if the the cell i can be positioned right
	 * @param i index
	 */
	private void right(Cell i) {
		if (!((i.index + 1) % r == 0))
			i.add(i.index + 1);
	}

	/*
	 * Checks if the the cell i can be positioned top
	 * @param i index
	 */
	private void top(Cell i) {
		if (i.index >= r)
			i.add(i.index - r);
	}

	/*
	 * Checks if the the cell i can be positioned bottom
	 * @param i index
	 */
	private void bottom(Cell i) {
		if (i.index + r < r * r)
			i.add(i.index + r);
	}
}
