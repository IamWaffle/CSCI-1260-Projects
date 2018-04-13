package item;

public class Weapon
{

	String	name;
	int		damage;
	int		durability;

	public Weapon ( )
	{
		setName ("Unknown");
		setDmg (0);
		setDurability (0);
	}

	public Weapon (String name, int damage, int durability)
	{
		setName (name);
		setDmg (damage);
		setDurability (durability);
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public void setDmg (int damage)
	{
		this.damage = damage;
	}

	public void setDurability (int durability)
	{
		this.durability = durability;
	}

	public String toString() {
		String output = "Name: " + getName() + 
						"\nDamage: " + getDmg() +
						"\nDurability: " + getDurability();
		return output;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Apr 12, 2018
	 *
	 * <hr>
	 */
	private int getDurability ( )
	{
		return durability;
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
	private int getDmg ( )
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
	private String getName ( )
	{
		return name;
	}
}
