CS 2430 - Object Oriented Programming and Data Structures I   F14

Program:     1 - Java Intro & CS 1430 review
Due Date:    September 22, 10:00 p.m.
Grace Date:  September 24, 10:00 p.m. (0 points for submitting after)
Points:      20

You are going to write a computer program that calculates rating 
adjustments for different matches of a table tennis tournament.
The program is to input information on a private database of table
tennis players that you are maintaining.  This database is listed
first in the input.  It consists of the number of players in 
the database followed by a certain number of records.  Each record
consists of an integer rating (given by USATT) and a name.

Following the database, there are an unknown number of lines of input, 
with each line containing 1 person's name and list of unknown number of
integers, terminated with a zero (0).  The list of lines is terminated with
a line that says "FINISHED!".

If the integer is positive (e.g. 1678), 
it means that the person on this line won over a person with that 
rating (1678).  If the integer is negative, (e.g. -1802), it means
that the person on this line lost to that person with that 
rating (1802).  For all the ratings listed on that line the 
player's rating is to be adjusted according to the following table.

The players' ratings are to be adjusted according to the USATT rules given
below.  

          if higher rated                         if lower rated
           player wins                             player wins
Higher         |    Lower                    Higher    |    Lower
rated          |    rated                    rated     |    rated
player         |    player                   player    |    player
gains          |    loses                    loses     |    gains
RATING DIFFERENCE
0-12           8                                        8
13-37          7                                       10
38-62          6                                       13
63-87          5                                       16
88-112         4                                       20
113-137        3                                       25
138-162        2                                       30
163-187        2                                       35
188-212        1                                       40
213-237        1                                       45
238&up         0                                       50

Make a Prog1 folder on your J drive, copy Prog1.java and
P1.in from the class web site into that folder, and proceed as in Program 0
to set up a project.  

Next, you will be making two more new files.  
You must comment them appropriately.  Follow the programming ground 
rules which are given on the CS 2430 web site.
Make sure you remove any of my comments that tell you how to proceed. You
will lose 1 point each time I see my "how-to-proceed" comments that 
are NOT removed.


The first is a TableTennisPlayer.java file.  It can only 
import java.lang.Math. It can't read or write anything.
I am restricting you to what is described below to force you to use
some concepts covered in class.  You will LOSE significant points if you
do NOT follow the restrictions given.


import java.lang.Math;

// Put your comment block here

public class TableTennisPlayer
{
   private String name;   // name of the Table Tennis Player
   private int rating;    // rating of Table Tennis Player
   private int adjustmentForTournament;  // value indicates how much
                                         // to adjust the rating
                                         // once the tournament is over.
                                         // This is adjusted for each match.

   // No other object data are allowed! [-3 for any other object data]
   // You are not allowed to do any reading or printing in this class!
   // Remove these 3 "how-to-proceed" comment lines.


   // Don't forget comment block here too!
   public TableTennisPlayer ( String TableTennisPlayerName, int TTrating  )
   {
      // This constructor should be simple to write!
      // Don't forget to set adjustmentForTournament to 0

   }

   // Don't forget comment block here too - I am finished reminding!!
   public int getRating()
   {
      // This should be even simpler!
   }

   public String getName()
   {
      // This should be as simple as getRating!
   }

   public void updateAdjustment(int adjustValue)
   {
      // Update adjustmentForTournament
   }

   public void updateRating()
   {
      // Update rating using adjustmentForTournament
   }

   public String toString()
   {
      // name followed by colon followed by space followed by rating
   }

   public int ratingAdjustment ( int loserRating )
   {
      // NOTE THAT THIS IS ALWAYS PASSED THE LOSER RATING: loserRating
      final int NUMBER_OF_LEVELS = 11;
      final int level[]
          = {12, 37, 62, 87, 112, 137, 162, 187, 212, 237, 3000};  // levels
      final int expected[]  = {8, 7, 6, 5, 4, 3, 2, 2, 1, 1, 0};
                                                  // expected values when
                                                  // higher rated player wins.
      final int unexpected[]  =
                         {8, 10, 13, 16, 20, 25, 30, 35, 40, 45, 50};
                                                  // unexpected values when
                                                  // lower rated player wins.

      // See information above as well as discussion here & in class.
      // pseudocode for algorithm:
      // calculate the difference [the absolute value of the difference, using Math.abs]
      // find the index in the level table where the difference
      // is less than or equal.
      // use this index together with which rating is higher to return a rating
      // adjustment.
      // The magic #s used here  are the only allowable magic numbers.

   }

   // That's all. You can't have any other methods or data.
   // [-2 for each additional method added.
   // You can't read or write in any method.
   // If you get the urge to put in more data or methods, you have some
   // misunderstanding that needs to be cleared up!

}

Next, you will be making a TableTennisPlayerDatabase.java file which will read
and store a list of Table Tennis Players.  Then, it will read in matches and
calculate the adjustments to be made to the ratings.  It will import java.util.Scanner.



import java.util.Scanner;

public class TableTennisPlayerDatabase
{
   // Array of table tennis players.
   // This must be allocated exactly the right size at run-time.
   // After that, just use list.length to get at the number of elements.
   private TableTennisPlayer list[];

   Scanner stdin;  // read from stdin

   public void run() throws java.io.IOException
   {
      stdin = new Scanner(System.in);
      .  .  .  // see below

   }


   // No other object data are allowed!

   // You MUST have several good methods, including run.
   // If you don't have several GOOD methods, expect to loose several points!
   // The run method MUST be public and ALL others private!  [-1 for other public methods, other than run!]
   // Reminder: ARE YOU REMOVING MY COMMENTS??

}

-----------------------------------------------------------------------------

You will read in a set of table tennis records.  Next, you will read and
process a series of players' matches.  One player's match will consist of
a name followed a zero-terminated list of ratings that a player beat or was
beaten by.  You must calculate an adjustment to be made to the player for each
of these ratings.

The input file has the format:

   number_of_table_tennis_players
   list_of_table_tennis_players
   list_of_names_and_matches

The list_of_table_tennis_players will be "number_of_table_tennis_players"
lines, with each line having format:

    rating_table_tennis_player   name_of_table_tennis_player

The list_of_names_and_matches is a variable number of lines, with each
line containing a name and series of integers terminated by zero; each
nonzero integer represents a rating, positive indicating that the person
whose name appears on this line beat a person with that rating, negative
indicating that the person whose name appears on this line lost to a
person with the rating, -rating.

      name  series of integers terminated by a zero

See the sample input.

Your program will read and store the table tennis player information
in a TableTennisPlayerDatabase object.  Then, it will read and process
name and matches until "FINISHED!" is read.  For each integer on a line, it will
calculate the adjustment value to be made to the name on that line.

See the sample output for the exact wording of all the messages.

Assumptions:  To simplify the program (after all, it is program 1!), you
can assume the following and don't need to check for these:

  1.  The first line in the file will be a number, call it M.
  2.  The next M lines will be table tennis player info.,
      in the proper format.
  3.  The next set of lines will be of the form:
                name  series of integer terminated with zero
      No name will appear more than once in the second portion
      of the input.
  4.  There will be no spaces in any name.

What you do need to check when processing a match: Is the name in the list?
If it isn't, then print out an error message (see sample output below)
and then stop processing the matches.  Continue on processing
with the next match.

--------------------------------------------------------------------
                      Programming Requirements

1. The program source files must be called TableTennisPlayer.java
   and TableTennisPlayerDatabase.java
   Remember that java is case-sensitive, even file names!

2. You must follow the software development ground rules.

3. You must use the declarations as given above.

4. You program must be modular.  The methods must be "natural".
   All methods must be less than or equal to 30 lines in length.

5. Your "run" method should be short, mostly method calls, something like:

      Read TableTennisPlayer Info
      Print TableTennisPlayer Info
      done = false
      playerNumber = 0
      while not done
         done = Process One-Name-Match(++playerNumber)
      Update TableTennisPlayer ratings
      Print TableTennisPlayer Info

   Of course, this will also have to keep track of and print the player
   number.

6. Note that the output isn't formatted very well.  That's okay.
   We'll be switching to Applets/Frames after a couple more programs.
   Recall that the GRADER requires that you match the output exactly.
   In this case, it shouldn't be too difficult,
   since I am not having you do any special or fancy formatting.

7.  You must use SE_Tools to keep an up-to-date log of the time spent working.
    You must use the automatic punch in and punch out when possible.
    Provide specific comments about what you worked on during that period.
    Access SE Tools from CSSE page. [up to -4 if you do NOT log all your time
    or you do NOT provide specific comments as to what you were working on.]

--------------------------------------------------------------------------
                      Procedural Hints/Requirements

1. You can open this file and copy over the declarations to your java files.

2. Build and test the program in pieces, one method at a time.
   Write a small method.  Then compile and run and test it.

3. Use the next() method of Scanner to read in a String, use nextInt() 
   method to read an integer and use nextFloat() to read in a float.

4. You can start testing by typing in data.  Later, to save typing,
   you can read data from a file.  You can make an input file, say
   P1.in, with some data in it (such as the sample input) and then
   read from the file by putting the following in the run method:

     //stdin = new Scanner(System.in);
     stdin = new Scanner( new java.io.File("P1.in") );

   After your program is well-tested and it is awaiting the
   running of the Grader, change it to:

     stdin = new Scanner(System.in);
     //stdin = new Scanner( new java.io.File("P1.in") );

   DON'T FORGET, or your grade won't be very high!!! 
   Make sure the file, P1.in is in the Prog1 solution folder and NOT
   in any subfolders.

5. Note that in TableTennisPlayerDatabase you will need to
   "find" a TableTennisPlayer based on name.
   You should make a private find method to do it.
   This is a good indication
   that you should make a method to do it.  This would be 
   what we called a linear search in CS1430 -- so you should have
   this method/function and call it as many times as necessary.

6. Run your program as in Prog0.

7. If you have questions OR problems, put a copy of the ENTIRE java project in
   an S drive folder given by:

             S:\Courses\CSSE\scanlan\cs2430\Your_user_Name

   Then I can look at your code.

--------------------------------------------------------------------------

Sample Input:
23
1082 HARROD
2070 KELLY
1810 HOUED
2018 HOGSHEAD
813 EPSTEIN
2663 BUTLERJ
1717 FELSTEIN
1764 ALSTOTT
1845 LONERGANT
1930 FAHLSTROM
1793 BUTLERA
2258 LONERGANS
1592 BHADURI
2579 BOGGAN
2045 MARCUS
1627 MOREHEAD
1265 PETERSON
1693 SCANLAN
1860 NUSINOW
1843 REED
1778 DAHLIN
2317 GEE
1989 MADRIGAL
MADRIGAL 1693 0
SCANLAN  -1989 1793 0
BHADURI  2018 0
HOGSHEAD -2045 -1592 0
MARCUS   2018 0
SCANMAN  1234 5678 -987 0
SCANLON  0
LONERGANT 1843 0
REED -1845 0
GEE  2258 0
LONERGANS  -2317 0
SMITH 1000 0
JONES -900 0
BUTLERA -1693 0
FINISHED!

Corresponding Sample Output:

Current List
The Table Tennis Players with their ratings are:
HARROD: 1082
KELLY: 2070
HOUED: 1810
HOGSHEAD: 2018
EPSTEIN: 813
BUTLERJ: 2663
FELSTEIN: 1717
ALSTOTT: 1764
LONERGANT: 1845
FAHLSTROM: 1930
BUTLERA: 1793
LONERGANS: 2258
BHADURI: 1592
BOGGAN: 2579
MARCUS: 2045
MOREHEAD: 1627
PETERSON: 1265
SCANLAN: 1693
NUSINOW: 1860
REED: 1843
DAHLIN: 1778
GEE: 2317
MADRIGAL: 1989
Processing Player's Matches for a Tournament
Player Number 1 ---> MADRIGAL
No adjustment necessary for MADRIGAL as ratings differential is too large.
Player Number 2 ---> SCANLAN
No adjustment necessary for SCANLAN as ratings differential is too large.
Adjusting ratings upward by 20 for SCANLAN; he/she has beaten a player of rating 1793.
Player Number 3 ---> BHADURI
Adjusting ratings upward by 50 for BHADURI; he/she has beaten a player of rating 2018.
Player Number 4 ---> HOGSHEAD
Adjusting ratings downward by 7 for HOGSHEAD; he/she has lost to a player of rating 2045.
Adjusting ratings downward by 50 for HOGSHEAD; he/she has lost to a player of rating 1592.
Player Number 5 ---> MARCUS
Adjusting ratings upward by 7 for MARCUS; he/she has beaten a player of rating 2018.
Player Number 6 ---> SCANMAN is not in list! No results processed.
Player Number 7 ---> SCANLON is not in list! No results processed.
Player Number 8 ---> LONERGANT
Adjusting ratings upward by 8 for LONERGANT; he/she has beaten a player of rating 1843.
Player Number 9 ---> REED
Adjusting ratings downward by 8 for REED; he/she has lost to a player of rating 1845.
Player Number 10 ---> GEE
Adjusting ratings upward by 6 for GEE; he/she has beaten a player of rating 2258.
Player Number 11 ---> LONERGANS
Adjusting ratings downward by 6 for LONERGANS; he/she has lost to a player of rating 2317.
Player Number 12 ---> SMITH is not in list! No results processed.
Player Number 13 ---> JONES is not in list! No results processed.
Player Number 14 ---> BUTLERA
Adjusting ratings downward by 20 for BUTLERA; he/she has lost to a player of rating 1693.
Updated List
The Table Tennis Players with their ratings are:
HARROD: 1082
KELLY: 2070
HOUED: 1810
HOGSHEAD: 1961
EPSTEIN: 813
BUTLERJ: 2663
FELSTEIN: 1717
ALSTOTT: 1764
LONERGANT: 1853
FAHLSTROM: 1930
BUTLERA: 1773
LONERGANS: 2252
BHADURI: 1642
BOGGAN: 2579
MARCUS: 2052
MOREHEAD: 1627
PETERSON: 1265
SCANLAN: 1713
NUSINOW: 1860
REED: 1835
DAHLIN: 1778
GEE: 2323
MADRIGAL: 1989
Normal Termination of Program 1
