package item;
/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */
public class Weapon
{

	String	name;
	int		damage;

	public Weapon ( )
	{
		setName ("Unknown");
		setDmg (0);

	}

	public Weapon (String name, int damage)
	{
		setName (name);
		setDmg (damage);

	}

	public void setName (String name)
	{
		this.name = name;
	}

	public void setDmg (int damage)
	{
		this.damage = damage;
	}



	public String toString() {
		String output = "Name: " + getName() + 
						"\nDamage: " + getDmg();
		return output;
	}

	/**
	 * Enter method description here
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
	 * Enter method description here
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
