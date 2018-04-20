package mob;

/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */
import java.util.Random;
import item.*;


/**
 * create a player type because thats necessary 
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * @author Ryan Shupe
 * 
 */
public class Player extends Participant
{

	boolean	hasWeapon;

	
	/**
	 * Constructor     default  new player   
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * 
	 */
	public Player ( )
	{
		super ( );
		setHealth (100);
		hasWeapon = false;
		setDamage (5);
	}

	
	/**
	 * boolean to tell if the player landed its attack or not 10% chance of a miss       
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * <hr>
	 * @return hit
	 */
	public boolean attack ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (10) + 1;
		boolean hit;

		if (i == 1)
		{
			hit = false;
		}
		else
		{
			hit = true;
		}
		return hit;
	}

	/**
	 * returns the boolean if the player has a weapon or not        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * @return hasWeapon
	 */
	public boolean hasWeapon ( )
	{
		return hasWeapon;
	}

}
