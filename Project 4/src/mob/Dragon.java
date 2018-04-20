/**
 * ---------------------------------------------------------------------------
 * File name: Dragon.java
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
 * to Create a pretty over powered monster that is hard to beat because whats a game without a challenge
 *
 * <hr>
 * Date created: Apr 13, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Dragon extends Participant
{

	/**
	 * Constructor to fill the name damage and health
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Dragon ( )
	{
		super ("Dragon", 50, 15);
	}

	/**
	 * returns a boolean if the monster landed its attack or missed 30% chance to miss
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

		if (i <= 3)
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
