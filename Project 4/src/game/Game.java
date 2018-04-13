package game;

import java.util.Random;
import item.*;
import mob.*;

public class Game
{

	Dungeon	gameDungeon	= new Dungeon ( );
	Player	player		= new Player ( );

	int		playerLocation;

	public Game ( )
	{
		setPlayerLocation (0);
	}

	public void setPlayerName (String name)
	{
		player.setName (name);
	}

	public void setPlayerLocation (int loc)
	{
		if (playerLocation >= 0)
		{
			playerLocation += loc;
		}
		else
		{
			playerLocation = 0;
		}
	}

	public int getPlayerHealth ( )
	{
		return player.getHealth ( );
	}

	public int getDungeonSize ( )
	{
		return gameDungeon.getDungeonSize ( );
	}

	public String getPlayerName ( )
	{
		return player.getName ( );
	}

	public String toString ( )
	{
		String output = "";
		if(getPlayerLocation() < getDungeonSize()) {
			if (getPlayerLocation ( ) == 0)
			{
				output = playerString (0);
			}
			else if (getPlayerLocation ( ) == 1)
			{
				output = playerString (1);
			}
			else if (getPlayerLocation ( ) == 2)
			{
				output = playerString (2);
			}
			else if (getPlayerLocation ( ) == 3)
			{
				output = playerString (3);
			}
			else if (getPlayerLocation ( ) == 4)
			{
				output = playerString (4);
			}
			else if (getPlayerLocation ( ) == 5)
			{
				output = playerString (5);
			}
			else if (getPlayerLocation ( ) == 6)
			{
				output = playerString (6);
			}
			else if (getPlayerLocation ( ) == 7)
			{
				output = playerString (7);
			}
			else if (getPlayerLocation ( ) == 8)
			{
				output = playerString (8);
			}
			else if (getPlayerLocation ( ) == 9)
			{
				output = playerString (9);
			}
			else if (getPlayerLocation ( ) == 10)
			{
				output = playerString (10);
			}
		}
		
		else if(getPlayerLocation() >= getDungeonSize()){
			output = "Victory!";
		}

		return output;
	}

	public String playerString (int pos)
	{
		String output = "";
		for (int i = 0; i < gameDungeon.dungeonSize; i++ )
		{
			if (i == pos)
			{
				if (gameDungeon.dungeon [i].contains ("M"))
				{
					output += gameDungeon.dungeon [i].substring (0, 1) + "P" +
									gameDungeon.dungeon [i].substring (gameDungeon.dungeon [i].indexOf ("M"), 6);
				}
				else if (gameDungeon.dungeon [i].contains ("I"))
				{
					output += gameDungeon.dungeon [i].substring (0, 1) + "P" +
									gameDungeon.dungeon [i].substring (gameDungeon.dungeon [i].indexOf ("I"), 6);
				}
				else
				{
					output += gameDungeon.dungeon [i].substring (0, 2) + "P" + gameDungeon.dungeon [i].substring (3, 6);
				}
			}
			else
			{
				output += gameDungeon.dungeon [i].toString ( );
			}
		}
		return output;
	}

	public void move (String direction) throws Exception
	{
		String move = direction.toLowerCase ( );

		if (move.equals ("go east") || move.equals ("goeast") || move.equals ("east") && getPlayerLocation ( ) == 0)
		{
			throw new Exception ("Player cannot go east!\n");
		}
		else if (move.equals ("go east") || move.equals ("goeast") ||
						move.equals ("east") && getPlayerLocation ( ) >= 0)
		{
			setPlayerLocation ( -1);
		}
		else if (move.equals ("go west") || move.equals ("gowest") ||
						move.equals ("west") && getPlayerLocation ( ) >= 0)
		{
			setPlayerLocation ( +1);
		}
		else
		{
			throw new Exception ("Invalid direction!\n");
		}

	}

	private int getPlayerLocation ( )
	{
		return playerLocation;
	}

}