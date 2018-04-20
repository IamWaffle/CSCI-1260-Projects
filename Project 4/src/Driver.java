import java.util.Scanner;
import Exception.*;
import game.Game;
/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */

/**
 *   To create a text-based or menu-driven similar to the old Zork (http://en.wikipedia.org/wiki/Zork) games.
 *   The game is played in a dungeon that has between 5 and 10 cells or rooms.  
 *   The objective of the game is to exit the dungeon while still alive. 
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class Driver
{
	/**
	 * main will be where the whole program is run from. It will create a game object and manage the game through try catch and loops.       
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
	
		Game game;
		boolean playing = true;
		Scanner input = new Scanner (System.in);
		
		
			System.out.println (Welcome ( ));
			input.nextLine ( );
			game = new Game ( );

			System.out.print ("What is the name of the player?");
			game.setPlayerName (input.nextLine ( ));

			do {
				try
				{
					game.positionCheck ( );
					System.out.println ("\n" + game.toString ( ));
					System.out.println (game.getPlayerName ( ) + "'s Health: " + game.getPlayerHealth ( ));
					game.positionCheck();
					System.out.print ("Which direction do you want to go?: ");	
					game.move (input.nextLine ( ));	
					game.positionCheck ( );
				}
				catch (VictoryException ve)
				{
					System.out.println ("The game is over!\n\nYou have defeated the dungeon and all the monsters!");
					System.exit (-1);
				}
				catch(MonsterException me) {
					try
					{
						System.out.println (me.getMessage ( ));
						System.out.println (game.fight());
						game.itemCheck ( );
					}
					catch (ItemException ie)
					{
						System.out.println (ie.getMessage ( ));
						System.out.println (game.pickupWeapon());
					}
					catch(DeadPlayerException dpe) {
						System.out.println ("\n" + game.toString ( ));
						System.out.println (dpe.getMessage ( ));
						System.exit (-1);
					}
					catch (Exception e)
					{

					}
				}
			catch (HealthException he)
			{
				System.out.println (he.getMessage ( ));
				if (game.getPlayerHealth ( ) >= 100)
				{
					System.out.println ("The max health is 100. Cannot overheal!");
				}
				else
				{
					game.setPlayerHealth (game.getPlayerHealth ( ) + 10);
					System.out.println (game.getPlayerName ( ) + "'s health is now " + game.getPlayerHealth ( ));
				}

			}
				catch (ItemException ie)
				{
					System.out.println (ie.getMessage ( ));
					System.out.println (game.pickupWeapon());
				}
				catch (Exception e)
				{
					System.out.print (e.getMessage ( ));

				}
			}
			while (playing);
	}

	/**
	 * Puts the welcome message into a string and returns it         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return output
	 */
	public static String Welcome ( )
	{
		String output = "\t\tWelcome to the Zork Game!\n" +
						"----------------------------------------------------------------------------------\n" +
						"In this game there is a dungeon, which can contain anywhere from 5 to 10 rooms.\n" +
						"The player begins in the west most cell and tries to get to the east most cell which contains the dungeon exit.\n" +
						"A successful exit from the cell will result in victory.\n" +
						"Along the way, each room may contain a monster that MUST be defeated. If you want to go back through rooms be prepared to fight a monster again..\n" +
						"One cell may contain a weapon which may be used on the monster, if any, in that room.\n\n\n" +
						"The game continues until the player is defeated or until the player successfully exits the dungeon.\n" +
						"In each cell the player may move one cell to the east or one cell to the west, if there is an exit in that direction.\n\n" +
						"The game is difficult. The monsters can do substantial damage if you do not get lucky finding a weapon.\n" +
						"Watch out for the rare dragon monster.. This monster does 15 damage every hit! (it has a 30% chance of missing..)\n" +
						
						"Press Enter to start your journey...";
		return output;
	}

}