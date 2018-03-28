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

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

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

	public String get (int i)
	{
		String s = addressBook.get (i).toString ( );
		return s;
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
	
	public void fillAddressBook ( ) throws Exception
	{
		File fileIn = new File ("ContactData\\ContactList.txt");
		Scanner file = null;

		if (fileIn.exists ( ))
		{
			try
			{
				file = new Scanner (fileIn);
			}
			catch (Exception e)
			{
				System.out.println ("Unable to import contacts from ContactList.txt\n" + e.getMessage ( ));
			}

			while (file.hasNext ( ))
			{
				String str = file.nextLine ( );
				String [ ] fields = str.split ("\\|");

				try
				{
					Contact c = new Contact (fields [0], fields [1], fields [2], fields [3], fields [4], fields [5],
									fields [6], fields [7], fields [8], fields [9]);
					addressBook.add (c);
				}
				catch (Exception e)
				{
					System.out.println ("Bad input record: '" + str + "'" + e.getMessage ( ));
				}
			}

			file.close ( );
		}
		else
		{
			throw new Exception ("The Contact List file does not exist..");
		}

	}

}
