import java.util.Random;
import java.util.Stack;

public class Maze {
	
	Cell[] cells;
	
	public Maze()
	{
		createGrid();
		breakWalls();
	}

	public void createGrid()
	{
		
	}
	
	public void breakWalls()
	{
		Stack<Cell> cellStack = new Stack<>();
		int totalCells = cells.length;
		Cell currentCell =  cells[0];
		int visitedCells = 0;
		while(visitedCells < totalCells)
		{
			if(currentCell.checkWalls())
			{
				Cell randomCell = getRandomCell(currentCell);
				deleteAndConnect(currentCell, randomCell);
				cellStack.push(currentCell);
				currentCell = randomCell;
				visitedCells++;	
			}
			else
			{
				currentCell = cellStack.pop();
			}
		}
	}
	
	/*
	 * Helper method that retrieved a random cell 
	 * from a the list of cells with walls intact
	 * @param cell
	 */
	public Cell getRandomCell(Cell cell)
	{
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(cell.walls.size());
		Cell randomCell = cell.walls.get(index);
		return randomCell;
	}
	
	/*
	 * 
	 */
	public void deleteAndConnect(Cell cell1, Cell cell2)
	{
		cell1.dnc(cell2);
		cell2.dnc(cell1);
	}
}
