import java.util.Scanner;
import game.Dungeon;
import game.Game;
import item.Stick;
import item.Sword;
import item.Weapon;
import mob.*;

public class Driver
{
	static Game game;

	public static void main (String [ ] args)
	{
		boolean mainGame = true;
		do
		{
			Scanner input = new Scanner (System.in);
			boolean playing = true;

			System.out.println (Welcome ( ));
			input.nextLine ( );
			game = new Game ( );

			System.out.print ("What is the name of the player?");
			game.setPlayerName (input.nextLine ( ));

			System.out.println ("Player Name: " + game.getPlayerName ( ));

			do
			{
				if (game.toString ( ).equals ("Victory!"))
				{
					System.out.print ("Victory!\nDo you want to play again?: ");
					if (input.nextLine ( ).toLowerCase ( ).equals ("n"))
					{
						playing = false;
						mainGame = false;
					}
					else
					{
						playing = false;
					}
				}
				else
				{
					System.out.println ("\n" + game.toString ( ));
					move ( );
				}
			}
			while (playing);

		}
		while (mainGame);
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

	public static void move ( )
	{
		Scanner in = new Scanner (System.in);
		boolean move = false;
		while ( !move)
		{
			try
			{
				System.out.print ("Which direction do you want to go?: ");
				game.move (in.nextLine ( ));
				move = true;
			}
			catch (Exception e)
			{
				System.out.print (e.getMessage ( ));

			}
		}
	}
}
