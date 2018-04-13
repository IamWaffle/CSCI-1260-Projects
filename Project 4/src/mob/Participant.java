package mob;

public abstract class Participant
{

	protected String	name;
	protected int		health;

	public Participant ( )
	{
		setName ("Deafult Name");
	}

	public Participant (String name)
	{
		setName (name);
	}

	public abstract void setHealth ( );

	public abstract void setName (String name);
	

	public String getName ( )
	{
		return name;
	}

	public int getHealth ( )
	{
		return health;
	}

}
