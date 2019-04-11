import java.util.ArrayList;

public class Cell {
	
	ArrayList<Integer> walls;
	ArrayList<Integer> edges;
	public int index;
	public int vis;
	
	public Cell(int index) {
		this.index=index;
	}
	
	/*
	 * Adds cell to the list of cells with walls
	 */
	public void add(int i)
	{
		walls.add(i);
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
	 * add it to the list of edges/connections
	 * @param newCell
	 */
	
	public void dnc(Cell newCell)
	{
		walls.remove(walls.indexOf(newCell));
		edges.add(newCell.index);
	}

}
