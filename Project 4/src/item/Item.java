package item;
/**
 * ---------------------------------------------------------------------------
 * File name: Item.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * To create type item that has damage and a name that can be used in the game class. 
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Item
{

	String	name;
	int		damage;

	/**
	 * Constructor default
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Item ( )
	{
		setName ("Unknown");
		setDmg (0);

	}

	/**
	 * Constructor to set name and damage
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 * @param name
	 * @param damage
	 */
	public Item (String name, int damage)
	{
		setName (name);
		setDmg (damage);

	}

	/**
	 * sets the name of the item
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @param name
	 */
	public void setName (String name)
	{
		this.name = name;
	}

	/**
	 * sets the damage of the item
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @param damage
	 */
	public void setDmg (int damage)
	{
		this.damage = damage;
	}

	/**
	 * Returns a string formatted to show the name and the stats
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString ( )
	{
		String output = "Name: " + getName ( ) +
						"\nDamage: " + getDmg ( );
		return output;
	}

	/**
	 * returns the damage of the item
	 *
	 * <hr>
	 * Date created: Apr 12, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public int getDmg ( )
	{
		return damage;
	}

	/**
	 * returns the name of the item
	 *
	 * <hr>
	 * Date created: Apr 12, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public String getName ( )
	{
		return name;
	}
}
