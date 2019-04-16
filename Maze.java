import java.util.Random;
import java.util.Stack;

public class Maze {
	
	Cell[] cells;
	public int r;
	
	public Maze(int r)
	{
		this.r = r;
		cells = new Cell[r*r];
		createGrid();
		breakWalls();
	}

	public void createGrid()
	{
		for(int i = 0; i<cells.length; i++) {
			Cell newCell = new Cell(i);
			
			left(newCell);
			right(newCell);
			top(newCell);
			bottom(newCell);
			
			System.out.println(newCell.index + " " + newCell.walls.toString());
			cells[i] = newCell;
			
		}
		
	}
	
	public void breakWalls()
	{
		Stack<Cell> cellStack = new Stack<>();
		int totalCells = cells.length;
		Cell currentCell =  cells[0];
		int visitedCells = 1;
		while(visitedCells < totalCells)
		{
			System.out.println("focus: " + currentCell.index);
			boolean eligible = false;
			for(int i = 0; i<currentCell.walls.size(); i++) {
				if(!cells[currentCell.walls.get(i)].discovered)
					eligible = true;
			}
			if(currentCell.checkWalls() && eligible)
			{
				Cell randomCell = getRandomCell(currentCell);
				System.out.println("Random is : " +randomCell.index);
				int count = 0;
				while(randomCell.discovered==true) {
					randomCell = getRandomCell(currentCell);
					System.out.println("Random is : " +randomCell.index);
					count++;
				}
				deleteAndConnect(currentCell, randomCell);
				System.out.println("Wall broken between " + currentCell.index + " and " + randomCell.index);
				System.out.println(currentCell.index); // push
				cellStack.push(currentCell);
				currentCell = randomCell;
				visitedCells++;	
			}
			else
			{
				currentCell = cellStack.pop();
				System.out.println("- " +currentCell.index); //pop
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
		Cell randomCell = cells[cell.walls.get(index)];
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
	
	private void left(Cell i) {
		if(i.index%r!=0)
			i.add(i.index-1);
	}
	
	private void right(Cell i) {
		if(!((i.index+1)%r==0))
			i.add(i.index+1);
	}
	
	private void top(Cell i) {
		if(i.index>=r)
			i.add(i.index-r);
	}
	
	private void bottom(Cell i) {
		if(i.index+r<r*r)
			i.add(i.index+r);
	}
}
