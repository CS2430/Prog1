
import java.io.*;
import java.util.Scanner;

/**
 * This class will read and store a list of Table Tennis Players. Then, it
 * will process each match and print the player ratings before and after the
 * matches.
 *
 * @author narishareddy
 *
 */
public class TableTennisPlayerDatabase
{

   // Array of table tennis players.
   // This must be allocated exactly the right size at run-time.
   // After that, just use list.length to get at the number of elements.
   private TableTennisPlayer list[];

   Scanner stdin;  // read from stdin

   /**
    * The main method of the class. Runs the program and calls necessary
    * methods.
    */
   public void run()
   {
      stdin = new Scanner(System.in);
   /**
      try
      {
         stdin = new Scanner(new File("P1Test.in"));
      }
      catch (IOException e)
      {
         System.out.println(e.toString());
      }
   **/
      list = new TableTennisPlayer[stdin.nextInt()];

      readPlayerInfo();
      System.out.println("Current List");
      printPlayerInfo();
      boolean done = false;
      int playerNum = 0;
      System.out.println("Processing Player's Matches for a Tournament");
      while (!done)
      {
         done = processOneNameMatch(++playerNum);
      }
      updatePlayerInfo();
      System.out.println("Updated List");
      printPlayerInfo();

      System.out.println("Normal Termination of Program 1");
   }

   /**
    * Reads in the TableTennisPlayer information
    */
   private void readPlayerInfo()
   {
      int rating;
      String name;
      for (int i = 0; i < list.length; i++)
      {
         rating = stdin.nextInt();
         name = stdin.next();
         list[i] = new TableTennisPlayer(name, rating);
      }
   }

   /**
    * Prints TableTennisPlayer information
    */
   private void printPlayerInfo()
   {
      System.out.println("The Table Tennis Players with their ratings are:");
      for (TableTennisPlayer list1 : list)
      {
         System.out.println(list1.toString());
      }
   }

   /**
    * Processes one match in the tournament
    *
    * @param playerNumber rating number of the player in the match
    * @return true if the
    */
   private boolean processOneNameMatch(int playerNumber)
   {
      String playerName = stdin.next();
      int rating = 0, num = playerNumber;

      if (playerName.equals("FINISHED!"))
         return true;
      if (find(playerName) == -1)
      {
         System.out.println("Player Number " + num + " ---> " + playerName
               + " is not in list! No results processed.");
         stdin.nextLine();
      }
      else
      {
         rating = stdin.nextInt();
         System.out.println("Player Number " + num + " ---> " + playerName);
         while (rating != 0)
         {
            int index = find(playerName);
            int adjValue = 0;
            if (rating < 0)
            {
               TableTennisPlayer b = new TableTennisPlayer("bogus", -rating);
               adjValue = -b.ratingAdjustment(list[index].getPlayerRating());
             }
            else
            {
               adjValue = list[index].ratingAdjustment(rating);
            }
            list[index].updateAdjustment(adjValue);
            printProcessingMatch(num, playerName, adjValue, rating);
            rating = stdin.nextInt();
         }
      }

      return false;
   }

   /**
    * Updates TableTennisPlayer information
    */
   private void updatePlayerInfo()
   {
      for (TableTennisPlayer t : list)
      {
         t.updateRating();
      }
   }

   /**
    * Finds a player in list[], given the player name.
    *
    * @param playerName name of the player
    * @return player index in list[], else return -1 if not found.
    */
   private int find(String playerName)
   {
      for (int i = 0; i < list.length; i++)
      {
         if (playerName.equals(list[i].getPlayerName()))
         {
            return i;
         }
      }
      return -1;
   }

   /**
    * Prints the One-Name-Match.
    *
    * @param number - Player output number
    * @param name - Player name
    * @param adjValue - adjustment value
    * @param rating - player rating
    * @param error - error output if the player is not found in the list
    */
   private void printProcessingMatch(int number, String name, int adjValue,
         int rating)
   {
      if (adjValue == 0)
      {
         System.out.println("No adjustment necessary for " + name
               + " as ratings differential is too large.");
      }
      else if (adjValue > 0)
      {
         System.out.println("Adjusting ratings upward by " + adjValue
               + " for " + name + ";" 
               + " he/she has beaten a player of rating " + Math.abs(rating) 
               + ".");
      }
      else if (adjValue < 0)
      {
         System.out.println("Adjusting ratings downward by " 
               + Math.abs(adjValue) + " for " + name + ";" 
               + " he/she has lost to a player of rating " + Math.abs(rating) 
               + ".");
      }
      else
      {
         System.out.println("Player Number " + number + " ---> " + name
               + " is not in list! No results processed.");
      }
   }
}
