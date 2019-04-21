package cs146S19.Group.project3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class MazeTester
{

   @Test
   /**
    * 
    * @throws IOException
    */
   void threeXthreeTest() throws IOException
   {

      Maze maze = new Maze(3);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      // mp.fullPrint();
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze3.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are
                                                                                           // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }

   @Test
   /*
    * @throws IOException
    */
   void twoXtwoTest() throws IOException
   {

      Maze maze = new Maze(2);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      // mp.fullPrint();
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze2.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are
                                                                                           // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }

   
   @Test
   /*
    * @throws IOException
    */
   void oneXoneTest() throws IOException
   {

      Maze maze = new Maze(1);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      // mp.fullPrint();
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze1.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are
                                                                                           // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }
}
