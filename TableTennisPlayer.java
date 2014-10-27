
import java.lang.Math;

/**
 * This class calculates the rating adjustments for different matches of a 
 * table tennis tournament. This class specifically handles the information
 * of each table tennis player, from the player's name and rating before the 
 * tournament to the rating of the player after the tournament. 
 * 
 * @author narishareddy
 */
public class TableTennisPlayer
{

   private String name;   
   private int rating;    
   private int adjustmentForTournament;

/**
 * Constructor for TableTennisPlayer class
 * 
 * @param PlayerName name of the player
 * @param PlayerRating rating of the player
 */
   public TableTennisPlayer(String PlayerName, int PlayerRating)
   {
      adjustmentForTournament = 0;
      name = PlayerName;
      rating = PlayerRating;
   }

   /**
    * Gets and returns the rating of the player.
    *
    * @return player rating
    */
   public int getPlayerRating()
   {
      return rating;
   }

   /**
    * Gets and returns the player name
    *
    * @return player name
    */
   public String getPlayerName()
   {
      return name;
   }

   /**
    * Updates the Adjustment for the tournament.
    *
    * @param adjustValue - adjusted value for tournament
    */
   public void updateAdjustment(int adjustValue)
   {
      adjustmentForTournament += adjustValue;
   }

   /**
    * Updates the rating using adjustmentForTournament
    */
   public void updateRating()
   {
      rating += adjustmentForTournament;
   }

   /**
    * Returns a string value of the player name and rating.
    *
    * @return - name followed by colon followed by space followed by rating
    */
   public String toString()
   {
      return name + ": " + rating;
   }

   /**
    * Adjusts the rating of the loser and winner each game.
    *
    * @param loserRating - rating of the loser of the game
    * @return the unexpected value if the lower rated player wins and the
    *         expected value if the higher rated player wins.
    */
   public int ratingAdjustment(int loserRating)
   {
      final int NUMBER_OF_LEVELS = 11;
      final int level[]= {12, 37, 62, 87, 112, 137, 162, 187, 212, 237, 3000};
      final int expected[] = {8, 7, 6, 5, 4, 3, 2, 2, 1, 1, 0};
      final int unexpected[] = {8, 10, 13, 16, 20, 25, 30, 35, 40, 45, 50};
      
      int diff = Math.abs(loserRating - rating);
      boolean found = false;
      int count = 0;
      
      while (count < NUMBER_OF_LEVELS && !found)
      {
         if (diff <= level[count])
            found = true;
         else
            count ++;
      }
      
      if (loserRating > rating)
         return unexpected[count];
      else
         return expected[count];
   }

}
