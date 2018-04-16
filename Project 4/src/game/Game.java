package game;

/**
 * ---------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */
import java.util.Random;
import Exception.*;
import item.*;
import mob.*;

public class Game
{

	Dungeon		gameDungeon	= new Dungeon ( );
	Participant	player		= new Player ( );

	int			playerLocation;

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
		return gameDungeon.getDungeonSize ( ) - 1;
	}

	public String getPlayerName ( )
	{
		return player.getName ( );
	}

	public String toString ( ) 
	{
		String output = "";
			
		if (getPlayerLocation ( ) <= getDungeonSize ( ))
		{
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
		return output;
	}

	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Apr 16, 2018
	 *
	 * <hr>
	 */
	public void positionCheck ( ) throws Exception
	{
		if(getPlayerLocation ( ) > getDungeonSize ( )) {
			throw new VictoryException("Victory!");
		}
		
	}

	private String playerString (int pos)
	{
		String output = "";
		for (int i = 0; i < gameDungeon.dungeonSize; i++ )
		{
			if (i == pos)
			{
				if (gameDungeon.dungeon [i].contains ("M") && gameDungeon.dungeon [i].contains ("I"))
				{
					output += gameDungeon.dungeon [i].substring (0, 1) + "P" +
									gameDungeon.dungeon [i].substring (gameDungeon.dungeon [i].indexOf ("M"), 6);
				}
				else if (gameDungeon.dungeon [i].contains ("M"))
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

	public String fight ( )
	{
		Participant monster = createMonster ( );
		String output = "Monster Encountered: \n" + monster.toString ( ) + "\n\nThe fight begins...\n\t";
		boolean dead = false;

		while(!dead) {
			if (monster.attack ( ))
			{
				player.setHealth (getPlayerHealth ( ) - monster.getDamage ( ));
				output += player.getName ( ) + " was hit by the " + monster.getName ( )+". " + player.getName ( ) + "'s Health: " +
								player.getHealth ( ) + "\n\t";
				if(player.getHealth ( ) == 0) 
				{
					output += "\n\t "+ player.getName ( ) + "has been killed...\n";
					dead = true;
				}
			}
			else
			{
				output += monster.getName ( ) + " has missed " + player.getName ( ) + ". " + player.getName ( ) + "'s Health: " +
								player.getHealth ( ) + "\n\t";
			}
			if (player.attack ( ))
			{
				monster.setHealth (monster.getHealth ( ) - player.getDamage ( ));
				output += monster.getName ( ) + " was hit by " + player.getName ( ) + ". " + monster.getName ( ) + "'s Health: " +
								monster.getHealth ( ) + "\n\t";
				if(monster.getHealth ( ) == 0) 
				{
					output += "\n\t The " + monster.getName ( ) + " has been killed...\n";
					dead = true;
				}
			}
			else
			{
				output += player.getName ( ) + " has missed " + monster.getName ( ) +". " + monster.getName ( ) + "'s Health: " +
								monster.getHealth ( ) + "\n\t";;
			}
		}	
		return output;
	}


	public void move (String direction) throws Exception
	{
		String move = direction.toLowerCase ( );

		if (move.equals ("go west") || move.equals ("gowest") || move.equals ("west") && getPlayerLocation ( ) == 0)
		{
			throw new Exception ("Sorry, but I can't go in that direction!\n");
		}
		else if (move.equals ("go east") || move.equals ("goeast") ||
						move.equals ("east") && getPlayerLocation ( ) >= 0)
		{
			positionCheck ( );
			setPlayerLocation ( +1);
			monsterCheck ( );
			itemCheck();
		}
		else if (move.equals ("go west") || move.equals ("gowest") ||
						move.equals ("west") && getPlayerLocation ( ) >= 0)
		{
			setPlayerLocation ( -1);
		}
		else
		{
			throw new Exception ("Sorry, but I can't go in that direction!\n");
		}

	}

	public void monsterCheck ( ) throws Exception
	{
		
		if (gameDungeon.dungeon [getPlayerLocation ( )].toString ( ).contains ("M"))
		{
			throw new MonsterException ("Monster is here!\n");
		}
	}

	public void itemCheck ( ) throws Exception
	{

		if (gameDungeon.dungeon [getPlayerLocation ( )].toString ( ).contains ("I"))
		{
			throw new ItemException ("Item in room!\n");
		}

	}

	private Participant createMonster ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (3) + 1;
		Participant monster = null;
		if (i == 0)
		{
			monster = new Cyclops ( );
		}
		else if (i == 1)
		{
			monster = new Dragon ( );
		}
		else if (i == 2)
		{
			monster = new Ogre ( );
		}
		else
		{
			monster = new Cyclops ( );
		}
		return monster;

	}
	
	private Weapon createWeapon ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (3) + 1;
		Weapon weapon = null;
		if (i == 0)
		{
			weapon = new Stick ( );
		}
		else if (i == 1)
		{
			weapon = new Stone ( );
		}
		else if (i == 2)
		{
			weapon = new Sword ( );
		}
		else
		{
			weapon = new Stick ( );
		}
		return weapon;

	}

	private int getPlayerLocation ( )
	{
		return playerLocation;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Apr 16, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public String pickupWeapon ( )
	{
		Weapon weapon = createWeapon ( );
		player.setDamage (player.getDamage ( ) + weapon.getDmg ( ));
		String output = player.getName ( ) + " picked up a " + weapon.getName ( ) + "!\n" +
						player.getName ( ) + "'s damage is now: " + player.getDamage ( );

		return output;
	}

}