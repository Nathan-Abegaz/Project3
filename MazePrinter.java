package cs146S19.Group.project3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * MazePrinter is an object built around turning the maze and sorting algorithms
 * into printable Strings
 * 
 * @author Huynh & Nathan
 *
 */
public class MazePrinter
{

   Maze   maze;  // the maze object to be printed and/or solved
   String blank; // the string of the unsolved maze
   String dfs;   // the string of the maze solved by dfs with hashtags
   String dfsNum;// the string of the maze solved by dfs with numbers
   String bfs;   // the string of the maze solved by bfs with hashtags
   String bfsNum;// the string of the maze solved by bfs with numbers

   /**
    * fullPrint is the amalgamation of all the sort strings appended by beautiful
    * Strings, spacing, and an embellished tail
    */
   void fullPrint()
   {
      System.out.println("Graph Size: " + maze.r + '\n' + "MAZE: ");
      print();
      System.out.println("BFS: ");
      printBFS();
      printBFSNum();
      System.out.println("DFS: ");
      printDFS();
      printDFSNum();
      System.out.println("======================\n  Program Completed!\n======================");
   }

   /**
    * prints the string of the unsolved maze
    */
   void print()
   {
      System.out.println(blank + '\n');
   }

   /**
    * prints the string of the DFS # maze
    */
   void printDFS()
   {
      System.out.println(dfs + '\n');
   }

   /**
    * prints the string of the DFS number maze
    */
   public void printDFSNum()
   {
      System.out.println(dfsNum + '\n');
   }

   /**
    * prints the string of the BFS # maze
    */
   public void printBFS()
   {
      System.out.println(bfs + '\n');
   }

   /**
    * prints the string of the BFS number maze
    */
   public void printBFSNum()
   {
      System.out.println(bfsNum + '\n');
   }

   /**
    * This method pulls in the DFS object and solves the maze, then pulls the two
    * DFS strings out of it This method is overloaded with DFS or BFS
    * 
    * @param dfs
    *           is the dfs object to solve the maze
    */
   public void add(DFS dfs)
   {
      this.dfs = "";
      ArrayList<Integer> dfsSol = new ArrayList<>(); // ArrayList so that .contains can be used
      int[] dfsA = dfs.solve(); // solve for the dfs solution and put into array

      for (int tile : dfsA)
      { // copy array to ArrayList
         dfsSol.add(tile);
      }

      this.dfs = addSol(dfsSol); // Set the dfs string to the maze with the # solution
      this.dfsNum = addNumSol(dfsSol); // Set the dfs number string to the maze with the numbers in the solution
   }

   /**
    * This method pulls in the BFS object and solves the maze, then pulls the two
    * BFS strings out of it This method is overloaded with DFS or BFS
    * 
    * @param bfs
    *           is the bfs object to solve the maze
    */
   public void add(BFS bfs)
   {
      this.bfs = "";
      ArrayList<Integer> bfsSol = new ArrayList<>(); // ArrayList so that .contains can be used
      int[] bfsA = bfs.solve(); // solve for the bfs solution and put into array

      for (int tile : bfsA)
      { // copy array to ArrayList
         bfsSol.add(tile);
      }

      this.bfs = addSol(bfsSol); // Set the bfs string to the maze with the # solution
      this.bfsNum = addNumSol(bfsSol); // Set the bfs number string to the maze with the numbers
   }

   /**
    * This is the method that takes in the ArrayList of the solution, in a certain
    * order, and adds it to the blank maze Accepts both DFS and BFS solutions
    * 
    * @param solution
    *           is the solution ArrayList
    * @return the String of the maze with the solution added in #s
    */
   public String addSol(ArrayList<Integer> solution)
   {

      String mazeString = blank; // Get the empty maze as a string

      StringBuilder sb = new StringBuilder(mazeString); // Stringbuilder is used so that .setCharAt can be utilized
      int index = (maze.r * 2) + 3; // The index has to be calculated using the dimensions of the maze.
      // Maze*2 + 3 means that the first row, \n, and first wall is skipped

      int tile = 0; // initialize the tiles stepped on starting from 0

      for (int i = 0; i < maze.r; i++)
      { // Loop through each row
         for (int j = 0; j < maze.r; j++)
         { // And every tile in that row
            if (solution.contains(tile))
            { // If the solution contains the tile being stepped on
               sb.setCharAt(index, '#'); // Set the space, previously blank, to a # to show that it is part of the path
            }
            index += 2; // Iterate index so that it skips a wall and goes to the next space
            tile++; // Iterate tile as steps are taken
         }
         index += (maze.r * 2) + 4; // index has to skip a horizontal wall and then go to the first space in the
                                    // next row
      }

      return sb.toString(); // return the String of the maze with the # solution drawn
   }

   /**
    * This is the method that takes in the ArrayList of the solution, in a certain
    * order, and adds it to the blank maze with iterations of 0-9 Accepts both DFS
    * and BFS solutions
    * 
    * @param solution
    *           is the solution ArrayList
    * @return the String of the maze with the solution added as numbers
    */
   public String addNumSol(ArrayList<Integer> solution)
   {

      String mazeString = blank; // Gets the empty maze as a string

      StringBuilder sb = new StringBuilder(mazeString); // Stringbuilder is used so that .setCharAt can be utilized
      int index = (maze.r * 2) + 3; // The index has to be calculated using the dimensions of the maze.
      // Maze*2 + 3 means that the first row, \n, and first wall is skipped

      int tile = 0; // initialize the tiles stepped on starting from 0

      for (int i = 0; i < maze.r; i++)
      { // Loop through each row
         for (int j = 0; j < maze.r; j++)
         { // And every tile in that row
            if (solution.contains(tile))
            { // If the solution contains the tile being stepped on
               sb.setCharAt(index, (char) ('0' + solution.indexOf(tile) % 10)); // Here the tile will be the remainder
                                                                                // once divided by 10 so that it cycles
                                                                                // 0-9
            }
            index += 2; // Iterate index so that it skips a wall and goes to the next space
            tile++; // Iterate tile as steps are taken
         }
         index += (maze.r * 2) + 4; // index has to skip a horizontal wall and then go to the first space in the
                                    // next row
      }

      return sb.toString(); // return the String of the maze with the number solution drawn
   }

   /**
    * Constructor that takes in a maze and generates the blank maze as a string
    * 
    * @param maze
    *           is the maze used for printing
    */
   MazePrinter(Maze maze)
   {
      this.maze = maze;
      blank(); // calls the method that creates the blank maze as a string
   }

   /**
    * This method creates the blank maze string from the maze object
    */
   void blank()
   {
      blank = "";

      // Top Border: this will loop through the top row and draw the appropriate
      // symbols
      blank += "+ +";
      for (int i = 0; i < maze.r - 1; i++)
      {
         blank += "-+";
      }

      // Inner Lines:
      for (int i = 0; i < maze.r; i++)
      { // All Rows will be iterated through
         blank += "\n"; // go to next line
         blank += "|"; // add the left border wall

         for (int j = i * maze.r; j < (maze.r * (i + 1)); j++)
         { // Through every row of vertical walls

            blank += " "; // every blank square in the maze

            if (maze.cells[j].walls.contains(j + 1) || (j + 1) % maze.r == 0) // If the space shares a wall with the
                                                                              // space to the right OR is on the
                                                                              // rightmost spot
               blank += "|"; // Add a wall
            else
               blank += " "; // or add a blank space

         }
         blank += "\n"; // go to the next row, which will always be the +-+ kind of row

         // Plus row
         blank += "+"; // leftmost border
         if (i < maze.r - 1) // If the last row isn't reached
            for (int j = i * maze.r; j < (maze.r * (i + 1)); j++)
            { // Iterate through the row

               if (maze.cells[j].walls.contains(j + maze.r)) // If the space shares a wall with the space under it
                  blank += "-"; // Draw a wall
               else
                  blank += " "; // otherwise it is a space

               blank += "+"; // finish the line
            }

      }

      // Bot Border: This is the drawing of the bottom row with the appropriate
      // symbols
      for (int i = 0; i < maze.r - 1; i++)
      {
         blank += "-+";
      }
      blank += " +"; // Finish with the exit
   }
}
