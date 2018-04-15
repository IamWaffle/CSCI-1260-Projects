package mob;

/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 4
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Apr 13, 2018
 * ---------------------------------------------------------------------------
 */
import java.util.Random;
import item.*;

public class Player extends Participant
{

	boolean	hasWeapon;
	Weapon	weapon;

	public Player ( )
	{
		super ( );
		setHealth (100);
		hasWeapon = false;
		setDamage (10);
	}

	public Player (String name, int health, int damage)
	{
		super (name, health, damage);
	}

	@Override
	public void setName (String name)
	{
		this.name = name;
	}

	public void setDamage (int damage)
	{
		this.damage = damage;
	}

	// returns if the attacker hit or missed
	public boolean attack ( )
	{
		Random rand = new Random ( );
		int i = rand.nextInt (10) + 1;
		boolean hit;

		if (i == 1)
		{
			hit = false;
		}
		else
		{
			hit = true;
		}
		return hit;
	}

	public void setHealth (int health)
	{
		this.health = health;
	}

	public boolean hasWeapon ( )
	{
		return hasWeapon;
	}

	public void hasWeapon (boolean wep)
	{
		Random rand = new Random ( );
		int weaponNumber = rand.nextInt (3) + 1;

		if (weaponNumber == 1)
		{
			weapon = new Sword ( );
		}
		else if (weaponNumber == 2)
		{
			weapon = new Stick ( );
		}
		else if (weaponNumber == 3)
		{
			weapon = new Stone ( );
		}

		hasWeapon = wep;
	}

}
