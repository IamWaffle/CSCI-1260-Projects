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
public abstract class Participant
{

	protected String	name;
	protected int		health;
	protected int		damage;

	public Participant ( )
	{
		setName ("Deafult Name");
	}

	public Participant (String name, int health, int damage)
	{
		setName (name);
		setHealth (health);
		setDamage (damage);
	}
	public abstract boolean attack( );
	
	public void setHealth (int health)
	{
		if (health < 0) {
			this.health = 0;
		}else {
			this.health = health;
		}
		
	}

	public void setDamage (int damage)
	{
		this.damage = damage;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public String getName ( )
	{
		return name;
	}

	public int getHealth ( )
	{
		return health;
	}

	/**
	 * Enter method description here
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
	
	public String toString( ) {
		String output = "Type: " + getName() + 
						"\nHealth: " + getHealth() + 
						"\nDamage: " + getDamage();
		return output;
	}

}
