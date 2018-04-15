/**
 * ---------------------------------------------------------------------------
 * File name: Cyclops.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */

package mob;

import java.util.Random;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Apr 13, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class Cyclops extends Participant
{

	public Cyclops() {
		super("Cyclops", 20, 4);
	}
	
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
