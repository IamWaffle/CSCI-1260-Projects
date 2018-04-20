/**
 * ---------------------------------------------------------------------------
 * File name: DeadPlayerException.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 17, 2018
 * ---------------------------------------------------------------------------
 */

package Exception;


/**
 * Create own DeadPlayerException so it can be thrown/caught when the player dies 
 *
 * <hr>
 * Date created: Apr 17, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class DeadPlayerException extends Exception
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
	public DeadPlayerException (String message)
	{
		super (message);
	}
}
