/**
 * ---------------------------------------------------------------------------
 * File name: VictoryException.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 16, 2018
 * ---------------------------------------------------------------------------
 */

package Exception;


/**
 * Create own VictoryException so it can be thrown/caught when the player wins the game
 *
 * <hr>
 * Date created: Apr 17, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class VictoryException extends Exception
{
	/**
	 * Constructor to full super class constructor        
	 *
	 * <hr>
	 * Date created: Apr 19, 2018 
	 *
	 * 
	 * @param message
	 */
	public VictoryException (String message)
	{
		super (message);
	}
}
