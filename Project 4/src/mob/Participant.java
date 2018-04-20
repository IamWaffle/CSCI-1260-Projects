package mob;

/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * To create an abstract class that makes up all participants in the game including monsters and the player
 *
 * <hr>
 * Date created: Apr 19, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */

public abstract class Participant
{

	protected String	name;
	protected int		health;
	protected int		damage;

	/**
	 * Constructor default
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Participant ( )
	{
		setName ("Deafult Name");
	}

	/**
	 * Constructor to set name health and damage
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * 
	 */
	public Participant (String name, int health, int damage)
	{
		setName (name);
		setHealth (health);
		setDamage (damage);
	}

	/**
	 * returns a boolean to see if the participant landed the attack or not
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public abstract boolean attack ( );

	/**
	 * sets the health of the participant
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @param health
	 */
	public void setHealth (int health)
	{
		if (health < 0)
		{
			this.health = 0;
		}
		else
		{
			this.health = health;
		}

	}

	/**
	 * sets the damage of the participant
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @param damage
	 */
	public void setDamage (int damage)
	{
		this.damage = damage;
	}

	/**
	 * sets the name of the participant
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
	 * returns the name of the participant
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public String getName ( )
	{
		return name;
	}

	/**
	 * returns the health of the participant
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public int getHealth ( )
	{
		return health;
	}

	/**
	 * returns the damage of the participant
	 *
	 * <hr>
	 * Date created: Apr 15, 2018
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public int getDamage ( )
	{
		return damage;
	}

	/**
	 * makes a neatly formatted string to show the type of participant (name) the health and and damage
	 *
	 * <hr>
	 * Date created: Apr 19, 2018
	 *
	 * <hr>
	 * 
	 * @return output
	 */
	public String toString ( )
	{
		String output = "Type: " + getName ( ) +
						"\nHealth: " + getHealth ( ) +
						"\nDamage: " + getDamage ( );
		return output;
	}

}
