package cs146S19.Group.project3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeTester
{

   @org.junit.Test
   /**
    * 3x3 maze test
    * 
    * @throws IOException
    */
   public void threeXthreeTest() throws IOException
   {

      Maze maze = new Maze(3);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze3.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                              // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }

   @org.junit.Test
   /*
    * 2x2 maze test
    * 
    * @throws IOException
    */
   public void twoXtwoTest() throws IOException
   {

      Maze maze = new Maze(2);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze2.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                                      // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }

   
   @org.junit.Test
   /*
    * 1x1 maze test
    * 
    * @throws IOException
    */
  public void oneXoneTest() throws IOException
   {

      Maze maze = new Maze(1);
      MazePrinter mp = new MazePrinter(maze);
      DFS dfs = new DFS(maze);
      BFS bfs = new BFS(maze);
      mp.add(dfs);
      mp.add(bfs);
      System.out.println(mp.fullReport());
      String report = mp.fullReport();
      String[] testee = report.split("\n");
      String expectedLine = null;
      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze1.txt"));
      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                                      // read here
      {
         String actualLine = testee[i];
         assertEquals(expectedLine, actualLine); // and then they are checked
      }
   }
   
   @org.junit.Test
   /*
    * 8x8 maze test
    * 
    * @throws IOException
    */
   
   public void eightXeightTest() throws IOException
   {
	   	Maze maze = new Maze(8);
	      MazePrinter mp = new MazePrinter(maze);
	      DFS dfs = new DFS(maze);
	      BFS bfs = new BFS(maze);
	      mp.add(dfs);
	      mp.add(bfs);
	      System.out.println(mp.fullReport());
	      String report = mp.fullReport();
	      String[] testee = report.split("\n");
	      String expectedLine = null;
	      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze8.txt"));
	      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                              // read here
	      {
	         String actualLine = testee[i];
	         assertEquals(expectedLine, actualLine); // and then they are checked
	      }
   }
   
   @org.junit.Test
   /*
    * 10x10 maze test
    * @throws IOException
    */
   
   public void tenXtenTest() throws IOException
   {
	   	Maze maze = new Maze(10);
	      MazePrinter mp = new MazePrinter(maze);
	      DFS dfs = new DFS(maze);
	      BFS bfs = new BFS(maze);
	      mp.add(dfs);
	      mp.add(bfs);
	      System.out.println(mp.fullReport());
	      String report = mp.fullReport();
	      String[] testee = report.split("\n");
	      String expectedLine = null;
	      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze10.txt"));
	      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                               // read here
	      {
	         String actualLine = testee[i];
	         assertEquals(expectedLine, actualLine); // and then they are checked
	      }
   }
   
   @org.junit.Test
   /*
    * 20x20 maze test
    * 
    * @throws IOException
    */
   
   public void twentyXtwenty() throws IOException
   {
	   	Maze maze = new Maze(20);
	      MazePrinter mp = new MazePrinter(maze);
	      DFS dfs = new DFS(maze);
	      BFS bfs = new BFS(maze);
	      mp.add(dfs);
	      mp.add(bfs);
	      System.out.println(mp.fullReport());
	      String report = mp.fullReport();
	      String[] testee = report.split("\n");
	      String expectedLine = null;
	      BufferedReader key = new BufferedReader(new FileReader("src/cs146S19/Group/project3/maze20.txt"));
	      for (int i = 0; i < testee.length && ((expectedLine = key.readLine()) != null); i++) // every line for both are                                                                         // read here
	      {
	         String actualLine = testee[i];
	         assertEquals(expectedLine, actualLine); // and then they are checked
	      }
   }
   
}