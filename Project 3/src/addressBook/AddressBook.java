/**
 * ---------------------------------------------------------------------------
 * File name: AddressBook.java
 * Project name: Project 3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Mar 27, 2018
 * ---------------------------------------------------------------------------
 */

package addressBook;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The AddressBook class holds an arraylist of contacts (atleast 10), also contains methods that can be used to add
 * remove and edit
 * that can be used in other classes.
 *
 * <hr>
 * Date created: Mar 27, 2018
 * <hr>
 * 
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

	public String toString ( )
	{

		String output = null;

		if (addressBook.size ( ) > 0)
		{
			output = "\nFull Contact List: \n\n";

			for (int i = 0; i < addressBook.size ( ); i++ )
			{
				String temp = "Contact " + (i + 1) + ":\n" + addressBook.get (i).toString ( ) + "\n\n";
				output += temp;
			}

			return output;
		}
		return output;
	}

	public void fillAddressBook ( )
	{

		JFileChooser fileChooser = new JFileChooser ("ContactData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select existing file..");

		int button = fileChooser.showOpenDialog (null);

		File fileIn;
		Scanner file;

		if (button == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				fileIn = fileChooser.getSelectedFile ( );
				file = new Scanner (fileIn);

				while (file.hasNext ( ))
				{
					String str = file.nextLine ( );
					String [ ] fields = str.split ("\\|");

					try
					{
						Contact c = new Contact (fields [0], fields [1], fields [2], fields [3], fields [4], fields [5],
										fields [6], fields [7], fields [8], fields [9]);
						add (c);
					}
					catch (Exception e)
					{
						System.out.println ("Bad input record: '" + str + "'" + e.getMessage ( ));
					}

				}

				file.close ( );
			}
			catch (Exception e)
			{
				System.out.println ("Unable to import contacts from imported text file./n" + e.getMessage ( ));
			}

		}

	}

	public void addAContact ( )
	{
		add (addContactInfo ( ));
		System.out.println ("Contact Added!\n\n");

	}

	public Contact addContactInfo ( )
	{
		Scanner input = new Scanner (System.in);

		Contact c = new Contact ( );

		JFileChooser fileChooser = new JFileChooser ("ContactData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("JPG Files", "jpg", "jpeg");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select photo file..");

		System.out.print ("What is the name of the contact?: ");
		c.setName (input.nextLine ( ));

		System.out.print ("What is the contact type?: ");
		c.setType (input.nextLine ( ));

		System.out.print ("What is the address?: ");
		c.setAddr (input.nextLine ( ));

		System.out.print ("What is the city name?: ");
		c.setCity (input.nextLine ( ));

		System.out.print ("What is the state abbreviation?: ");
		c.setState (input.nextLine ( ));

		System.out.print ("What is the zip code?: ");
		c.setZip (input.nextLine ( ));

		System.out.print ("What is the phone number?: ");
		c.setPhone (input.nextLine ( ));

		System.out.println ("What is the email address?: ");
		c.setEmail (input.nextLine ( ));

		int button = fileChooser.showOpenDialog (null);

		if (button == JFileChooser.APPROVE_OPTION)
		{
			c.setPhotoName (fileChooser.getSelectedFile ( ).getName ( ));
			c.setPhotoPath (fileChooser.getSelectedFile ( ).getAbsolutePath ( ));
		}
		return c;
	}

	public void editAContact ( )
	{
		Scanner input = new Scanner (System.in);

		System.out.println (firstNameList ( ));
		System.out.print ("Enter the name of the contact would you like to edit: ");
		String name = input.nextLine ( ).toUpperCase ( );
		boolean found = true;

		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			if (addressBook.get (i).getName ( ).toUpperCase ( ).equals (name))
			{
				addressBook.set (i, addContactInfo ( ));
				found = true;

				System.out.println ("Contact Updated!\n\n");
			}
			else
			{
				found = false;
			}
		}

		if ( !found)
		{
			System.out.println ("\nCannot find the name in the address book!\n");
		}

	}

	public void removeAContact ( )
	{
		Scanner input = new Scanner (System.in);
		System.out.println (firstNameList ( ));
		System.out.print ("Enter the name of the contact you wish to remove.");
		String name = input.nextLine ( ).toUpperCase ( );
		boolean found = true;

		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			if (addressBook.get (i).getName ( ).toUpperCase ( ).equals (name))
			{
				addressBook.remove (i);
				found = true;
				System.out.println ("Contact Removed!\n\n");
			}
			else
			{
				found = false;
			}
		}

		if ( !found)
		{
			System.out.println ("\nCannot find the name in the address book!\n");
		}

	}

	public String firstNameList ( )
	{
		String output = null;

		if (addressBook.size ( ) > 0)
		{
			output = "\nFull Contact List: \n\n";

			for (int i = 0; i < addressBook.size ( ); i++ )
			{
				String temp = "Contact " + (i + 1) + ":\n" + addressBook.get (i).getName ( ) + "\n";
				output += temp;
			}

			return output;
		}
		return output;
	}

	public void findAContact ( )
	{
		Scanner input = new Scanner (System.in);
		System.out.println (firstNameList ( ));
		System.out.print ("Enter the name of the contact you wish to find.");
		String name = input.nextLine ( ).toUpperCase ( );
		boolean found = true;

		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			if (addressBook.get (i).getName ( ).toUpperCase ( ).equals (name))
			{
				System.out.println ("Contact Found!\n\n");
				found = true;
				System.out.println (addressBook.get (i).toString ( ) + "\n\n");
				

			}
			else
			{
				found = false;
			}
		}
		if ( !found)
		{
			System.out.println ("\nCannot find the name in the address book!\n");
		}

	}
}
