package cs146S19.Group.project3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class MazeTester
{
   
   @Test
   void SimpleTest() throws IOException{
      
      Maze maze = new Maze(3);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      mp.fullPrint();
   
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/mazeText.txt"));
      String expectedLine = null;
     /* while ((expectedLine = key.readLine()) != null) //every line for both are read here
      {
         String actualLine = 
         assertEquals(expectedLine, actualLine); //and then they are checked
      }*/
   }
   

}
