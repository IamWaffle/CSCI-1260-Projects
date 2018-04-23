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


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class Dungeon
{

	private int	dungeonSize;
	 String [ ]	dungeon;

	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * 
	 */
	public Dungeon ( )
	{
		setDungeonSize ( );
		dungeon = new String [getDungeonSize ( )];
		fillDungeon ( );
	}

	/**
	 * Fills the dungeon with monsters and one item        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 */
	private void fillDungeon ( )
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
				if (random >= 85)
				{
					roomString += "H";
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
				else if (roomString.contains ("H"))
				{
					roomString = "|_H__|";
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

	/**
	 * sets the dungeon size to anything between 5 and 10         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 */
	private void setDungeonSize ( )
	{
		Random rand = new Random ( );
		dungeonSize = rand.nextInt (5) + 5;
	}

	/**
	 * returns the dungeon size        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return dungeonSize
	 */
	public int getDungeonSize ( )
	{
		return dungeonSize;
	}

	/**
	 * send the Dungeon in a format like this |___| |___|        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
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
