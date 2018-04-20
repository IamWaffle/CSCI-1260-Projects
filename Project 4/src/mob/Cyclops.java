/**
 * ---------------------------------------------------------------------------
 * File name: Cyclops.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */

package mob;

import java.util.Random;

/**
 * To create a type of monster to add variety
 *
 * <hr>
 * Date created: Apr 13, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Cyclops extends Participant
{

	/**
	 * Constructor to fill the name health and damage
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Cyclops ( )
	{
		super ("Cyclops", 30, 10);
	}

	/**
	 * returns a boolean if the monster landed its attack or missed 20% chance to miss
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return hit
	 */
	public boolean attack ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (10) + 1;
		boolean hit;

		if (i <= 2)
		{
			hit = false;
		}
		else
		{
			hit = true;
		}
		return hit;
	}

}
