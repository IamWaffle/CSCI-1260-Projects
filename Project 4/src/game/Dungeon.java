package game;
/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */
import java.util.Random;

public class Dungeon
{

	public int	dungeonSize;
	String [ ]	dungeon;

	public Dungeon ( )
	{
		setDungeonSize ( );
		dungeon = new String [getDungeonSize ( )];
		fillDungeon ( );
	}

	public void fillDungeon ( )
	{
		boolean itemSpawn = false;
		int roomNumber = 0;
		Random rand = new Random ( );

		while (roomNumber < dungeon.length)
		{
			
			if (roomNumber == 0)
			{
				dungeon [roomNumber] = "|____|";
			}
			else
			{
				String roomString = "|_";

				int random = rand.nextInt (100);
				if (random <= 50)
				{
					roomString += "M";
				}
				if ( !itemSpawn)
				{
					int random2 = rand.nextInt (100);
					if (random2 <= 50)
					{
						roomString += "I";
						itemSpawn = true;
					}
				}
				roomString += "_|";

				if (roomString.contains ("M") && roomString.contains ("I"))
				{
						roomString = "|_M_I|";		
				}
				else if (roomString.contains ("M"))
				{
					roomString = "|_M__|";
				}
				else if (roomString.contains ("I"))
				{
					roomString = "|_I__|";
				}
				else
				{
					roomString = "|____|";
				}
				dungeon [roomNumber] = roomString;
			}

			roomNumber++ ;
		}

	}

	public void setDungeonSize ( )
	{
		Random rand = new Random ( );
		dungeonSize = rand.nextInt (5) + 5;
	}

	public int getDungeonSize ( )
	{
		return dungeonSize;
	}

	public String toString ( )
	{
		String output = "Dungeon: \n";
		for (int i = 0; i < dungeon.length; i++ )
		{
			if (i == 0)
			{
				output += "|____|";
			}
			else
			{
				output += dungeon [i].toString ( );
			}

		}
		return output;
	}

}
