package mob;

import java.util.Random;

public class Player extends Participant
{

	public Player ( )
	{
		super ( );
		setHealth (100);
	}

	public Player (String name)
	{
		super (name);
	}

	@Override
	public void setName (String name)
	{
		this.name = name;
	}

	// returns the attack thrown (5-10 without an item)
	public int attack ( )
	{
		Random rand = new Random ( );
		int damage = rand.nextInt (5) + 5;
		return damage;
	}

	@Override
	public void setHealth ( )
	{
		this.health = 100;
	}

	public void setHealth (int health)
	{
		this.health = health;
	}
}
