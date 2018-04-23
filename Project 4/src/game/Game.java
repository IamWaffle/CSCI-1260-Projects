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


/**
 * The game class is going to be how the driver controls the game. Basically this is the brain of the whole thing.
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * @author Ryan Shupe
 */

public class Game
{

	private Dungeon		gameDungeon	= new Dungeon ( );
	private Participant	player		= new Player ( );

	private int			playerLocation;

	/**
	 * Constructor
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Game ( )
	{
		setPlayerLocation (0);
	}

	/**
	 * Sets the player name        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param name
	 */
	public void setPlayerName (String name)
	{
		player.setName (name);
	}

	/**
	 * Sets the player location        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param loc
	 */
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

	/**
	 * returns the player health         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getPlayerHealth ( )
	{
		return player.getHealth ( );
	}
	
	/**
	 * method to set the player health         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param int health
	 */
	public void setPlayerHealth (int health)
	{
		player.setHealth (health);
	}

	/**
	 * returns the player location        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return playerLocation
	 */
	private int getPlayerLocation ( )
	{
		return playerLocation;
	}


	/**
	 * returns the dungeon size        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getDungeonSize ( )
	{
		return gameDungeon.getDungeonSize ( ) - 1;
	}

	/**
	 * returns the player name         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return
	 */
	public String getPlayerName ( )
	{
		return player.getName ( );
	}

	/**
	 * Makes a String that has the dungeon and the player position.        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * <hr>
	 * @return output
	 */
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
	 * checks to see if the player has beat the dungeon or not       
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void positionCheck ( ) throws Exception
	{
		if(getPlayerLocation ( ) > getDungeonSize ( )) {
			throw new VictoryException("Victory!");
		}
		
	}

	/**
	 * Creates a String containing the player in the cell of the dungeon         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param pos
	 * @return output
	 */
	private String playerString (int pos)
	{
		String output = "";
		for (int i = 0; i < gameDungeon.getDungeonSize(); i++ )
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
				else if (gameDungeon.dungeon [i].contains ("H"))
				{
					output += gameDungeon.dungeon [i].substring (0, 1) + "P" +
									gameDungeon.dungeon [i].substring (gameDungeon.dungeon [i].indexOf ("H"), 6);
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

	/**
	 * This is where the player fighting the monster occurs. it updates health values and returns a string about the details of the fight.        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return
	 * @throws Exception
	 */
	public String fight ( ) throws Exception
	{
		Participant monster = createMonster ( );
		String output = "Monster Encountered: \n" + monster.toString ( ) + "\n\nThe fight begins...\n\t";
		boolean dead = false;

		while(!dead) {
			if (monster.attack ( ))
			{
				player.setHealth (getPlayerHealth ( ) - monster.getDamage ( ));
				if (player.getHealth ( ) == 0)
				{
					output += player.getName ( ) + " was hit by the " + monster.getName ( ) + ". " +
									player.getName ( ) + "'s Health: " +
									player.getHealth ( ) + "\n\t";
					output += "\n\t " + player.getName ( ) + " has been killed...\n";
					dead = true;
					throw new DeadPlayerException(output);
				}
				else
				{
					output += player.getName ( ) + " was hit by the " + monster.getName ( ) + ". " +
									player.getName ( ) + "'s Health: " +
									player.getHealth ( ) + "\n\t";
				}
			}
			else
			{
				output += monster.getName ( ) + " has missed " + player.getName ( ) + ". " + player.getName ( ) + "'s Health: " +
								player.getHealth ( ) + "\n\t";
			}
			if (player.attack ( ) && player.getHealth ( ) > 0)
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
			else if(!player.attack ( ) && player.getHealth ( ) > 0)
			{
				output += player.getName ( ) + " has missed " + monster.getName ( ) +". " + monster.getName ( ) + "'s Health: " +
								monster.getHealth ( ) + "\n\t";;
			}
		}	
		return output;
	}

	/**
	 * moves the player in a direction and checks for monsters or items.        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @param direction
	 * @throws Exception
	 */
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
			healthCheck( );
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

	/**
	 * Checks to see if a monster is in the cell the player is in         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void monsterCheck ( ) throws Exception
	{
		
		if (gameDungeon.dungeon [getPlayerLocation ( )].toString ( ).contains ("M"))
		{
			throw new MonsterException ("Monster is here!\n");
		}
	}

	/**
	 * Checks to see if an item is in the cell the player is in         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void itemCheck ( ) throws Exception
	{

		if (gameDungeon.dungeon [getPlayerLocation ( )].toString ( ).contains ("I"))
		{
			throw new ItemException ("Item in room!\n");
		}

	}
	/**
	 * Checks to see if a healing pot is in the cell the player is in         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void healthCheck( ) throws Exception 
	{

		if (gameDungeon.dungeon [getPlayerLocation ( )].toString ( ).contains ("H"))
		{
			throw new HealthException ("Healing Pot in room!\n");
		}

	}
	/**
	 * Creates and returns a monster to fight        dragon is rareish because its overpowered
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return monster
	 */
	private Participant createMonster ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (50) + 1;
		Participant monster = null;
		
		if (i < 8)
		{
			monster = new Dragon ( );
		}
		else if (i < 30)
		{
			monster = new Ogre ( );
		}
		else if (i <= 50)
		{
			monster = new Cyclops ( );
		}
		else
		{
			monster = new Cyclops ( );
		}
		return monster;

	}
	
	/**
	 * Creates  and returns a weapon  1/4 chance for each one      
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return weapon
	 */
	private Item createWeapon ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (4) + 1;
		Item weapon = null;
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
			weapon = new Dagger ( );
		}
		return weapon;

	}


	/**
	 * uses Create Weapon and adds the weapon damage onto the player damage         
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return output
	 */
	public String pickupWeapon ( )
	{
		Item weapon = createWeapon ( );
		player.setDamage (player.getDamage ( ) + weapon.getDmg ( ));
		String output = player.getName ( ) + " picked up a " + weapon.getName ( ) + "!\n" +
						player.getName ( ) + "'s damage is now: " + player.getDamage ( );

		return output;
	}

}