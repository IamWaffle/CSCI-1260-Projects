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
public class Driver
{
	static Game game;

	static boolean mainGame = true;
	static boolean playing = true;
	static Scanner input = new Scanner (System.in);
	
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
					System.out.println ("\n" + game.toString ( ));
					System.out.println (game.getPlayerName ( ) + "'s Health: " + game.getPlayerHealth ( ));
					game.positionCheck();
					System.out.print ("Which direction do you want to go?: ");	
					game.move (input.nextLine ( ));		
				}
				catch (VictoryException ve)
				{
					System.out.println ("The game is over!\n\nYou have defeated the dungeon and all the monsters!");
					System.exit (-1);
				}
				catch(MonsterException me) {
					System.out.println (me.getMessage ( ));
					System.out.println (game.fight());
					try
					{
						game.itemCheck ( );
					}
					catch (ItemException ie)
					{
						System.out.println (ie.getMessage ( ));
						System.out.println (game.pickupWeapon());
					}
					catch (Exception e)
					{

					}
					System.out.println(game.toString ( ));
					
					System.out.println (game.getPlayerName ( ) + "'s Health: " + game.getPlayerHealth ( ));
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

	public static String Welcome ( )
	{
		String output = "\t\tWelcome to the Zork Game!\n" +
						"----------------------------------------------------------------------------------\n" +
						"In this game there is a dungeon, which can contain anywhere from 5 to 10 rooms.\n" +
						"The player begins in the west most cell and tries to get to the east most cell which contains the dungeon exit.\n" +
						"A successful exit from the cell will result in victory.\n" +
						"Along the way, each room may contain a monster that MUST be defeated.\n" +
						"One cell may contain a weapon which may be used on the monster, if any, in that room.\n\n\n" +
						"The game continues until the player is defeated or until the player successfully exits the dungeon.\n" +
						"In each cell the player may move one cell to the east or one cell to the west, if there is an exit in that direction.\n\n" +
						"Press Enter to start your journey...";
		return output;
	}

}