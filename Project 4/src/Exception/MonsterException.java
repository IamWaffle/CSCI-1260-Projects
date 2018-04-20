/**
 * ---------------------------------------------------------------------------
 * File name: MonsterException.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 15, 2018
 * ---------------------------------------------------------------------------
 */

package Exception;

/**
 * Create own MonsterException so it can be thrown/caught when the player finds a monster
 *
 * <hr>
 * Date created: Apr 17, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class MonsterException extends Exception
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
	public MonsterException (String message)
	{
		super (message);
	}
}
