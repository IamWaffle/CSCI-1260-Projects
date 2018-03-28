/**
 * ---------------------------------------------------------------------------
 * File name: AddressBook.java
 * Project name: Project 3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 27, 2018
 * ---------------------------------------------------------------------------
 */

package addressBook;

import java.util.ArrayList;

/**
 * The AddressBook class holds an arraylist of contacts (atleast 10), also contains methods that can be used to add remove and edit
 * that can be used in other classes.
 *
 * <hr>
 * Date created: Mar 27, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class AddressBook
{
	private ArrayList <Contact>	addressBook	= new ArrayList ( );
	private Contact				owner		= new Contact ( );

	public AddressBook ( )
	{
		setOwnerName ("Default Owner Name");
	}

	public void add (Contact c)
	{
		addressBook.add (c);
	}

	public void remove (int i)
	{
		addressBook.remove (i);
	}

	public void get (int i)
	{
		addressBook.get (i);
	}

	public int size ( )
	{
		return addressBook.size ( );
	}

	public void setOwnerName (String name)
	{
		owner.setName (name);
	}

	public String getOwnerName ( )
	{
		return owner.getName ( );
	}

}
