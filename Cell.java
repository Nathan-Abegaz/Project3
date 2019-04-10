import java.util.ArrayList;

public class Cell {
	
	ArrayList<Cell> walls;
	ArrayList<Cell> edges;
	
	/*
	 * Adds cell to the list of cells with walls
	 */
	public void add(Cell cell)
	{
		walls.add(cell);
	}
	
	
	/*
	 * Checks if the cell has neighboring walls
	 * @return true/false 
	 */
	public boolean checkWalls()
	{
		if(walls.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Delete cell from list of of walls and 
	 * add it to the list of connections
	 * 
	 */
	
	public void dnc(Cell newCell)
	{
		walls.remove(walls.indexOf(newCell));
		edges.add(newCell);
	}

}
