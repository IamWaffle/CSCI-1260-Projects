/**
 * ---------------------------------------------------------------------------
 * File name: HealthException.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 19, 2018
 * ---------------------------------------------------------------------------
 */

package Exception;


/**
 * Create own HealthException so it can be thrown/caught when the player finds a healing pot 
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class HealthException extends Exception
{
	/**
	 * Constructor to full super class constructor        
	 *
	 * <hr>
	 *
	 * 
	 * @param message
	 */
	public HealthException(String message) 
	{
		super(message);
	}
}
