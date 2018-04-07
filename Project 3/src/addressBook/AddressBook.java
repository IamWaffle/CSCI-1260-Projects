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

import java.io.*;
import java.util.*;
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
	private ArrayList <Contact>	addressBook	= new ArrayList ( );		// Array list of contacts called addressBook
	private Contact				owner		= new Contact ( );					// A contact object for the owner.

	/**
	 * No Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 */
	public AddressBook ( )
	{
		setOwnerName ("Default Owner Name");
	}

	/**
	 * Arg Constructor for name?
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 */
	public AddressBook (String name)
	{
		setOwnerName (name);
	}

	/**
	 * Copy Contructor
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 */

	public AddressBook (AddressBook original)
	{
		setOwnerName (original.getOwnerName ( ));

		for (int i = 0; i < addressBook.size ( ); i++ )
		{
			add (original.getContact (i));
		}
	}

	/**
	 * Add method adds a contact to the address book
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 * 
	 * @param Contact c
	 */
	public void add (Contact c)
	{
		addressBook.add (c);
	}

	/**
	 * remove method removes a contact from the address book
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 * 
	 * @param int i
	 */
	public void remove (int i)
	{
		addressBook.remove (i);
	}

	/**
	 * Get method returns the to String of the contact that is in that position in the array list
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 * 
	 * @param int i
	 * @return String s
	 */

	public String get (int i)
	{
		String s = addressBook.get (i).toString ( );
		return s;
	}

	/**
	 * gets a Contact and returns the object.
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 */

	public Contact getContact (int i)
	{
		Contact c = new Contact (addressBook.get (i));
		return c;
	}

	/**
	 * size method calls the size method from arraylist and returns the size of the address book array list
	 *
	 * <hr>
	 * Date created: Mar 27, 2018
	 * 
	 * @return int addressBook.size
	 */

	public int size ( )
	{
		return addressBook.size ( );
	}

	/**
	 * setOwnerName sets the name of the oner contact object
	 *
	 * <hr>
	 * Date created: Mar 28, 2018
	 * 
	 * @param String name
	 */

	public void setOwnerName (String name)
	{
		owner.setName (name);
	}

	/**
	 * getOwnerName calls the get name method from the contact class and returns the name of the owner from the owner
	 * object
	 *
	 * <hr>
	 * Date created: Mar 28, 2018
	 * 
	 * @return String owner.getName()
	 */

	public String getOwnerName ( )
	{
		return owner.getName ( );
	}

	/**
	 * toString displays every contacts informaion inside the addressbook in a neatly fashion
	 *
	 * <hr>
	 * Date created: Mar 28, 2018
	 * 
	 * @return String output
	 */

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

	/**
	 * fillAddressBook method uses JFile chooser to open a delimited text file to fill the addressbook
	 *
	 * <hr>
	 * Date created: Apr 1, 2018
	 * 
	 */

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

	/**
	 * saveAddressBook uses JFileChooser to select a file and write to it to save the information stored in the
	 * addressBook
	 *
	 * <hr>
	 * Date created: Apr 5, 2018
	 * 
	 */

	public void saveAddressBook ( )
	{

		JFileChooser fileChooser = new JFileChooser ("ContactData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select a file to save to...");

		int button = fileChooser.showSaveDialog (null);

		File fileIn;
		Scanner file;

		if (button == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				fileIn = fileChooser.getSelectedFile ( );
				PrintWriter pw = new PrintWriter (fileIn);

				for (int i = 0; i < addressBook.size ( ); i++ )
				{
					pw.println (addressBook.get (i).getType ( ) + "|" + addressBook.get (i).getName ( ) + "|" +
									addressBook.get (i).getAddr ( ) + "|" + addressBook.get (i).getCity ( ) + "|" +
									addressBook.get (i).getState ( ) + "|" + addressBook.get (i).getZip ( ) + "|" +
									addressBook.get (i).getPhone ( ) + "|" + addressBook.get (i).getEmail ( ) + "|" +
									addressBook.get (i).getPhotoName ( ) + "|" + addressBook.get (i).getPhotoPath ( ));
				}

				pw.close ( );
			}
			catch (Exception e)
			{
				System.out.println ("Unable to save!/n" + e.getMessage ( ));
			}

		}

	}

	/**
	 * addAContact calls the addContactInfo method
	 *
	 * <hr>
	 * Date created: Apr 3, 2018
	 * 
	 */

	public void addAContact ( )
	{
		add (addContactInfo ( ));
		System.out.println ("Contact Added!\n\n");

	}

	/**
	 * addContactInfo calls the setter for the contact and fill a contact object to put in the addressBook
	 *
	 * <hr>
	 * Date created: Apr 3, 2018
	 * 
	 */

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
		c.setState (input.nextLine ( ).toUpperCase ( ));

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

	/**
	 * EditAContact verifies which contact the user wishes to edit, then calls the addContactInfo method.
	 *
	 * <hr>
	 * Date created: Apr 4, 2018
	 * 
	 */

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

	/**
	 * RemoveAContact verifies the contact the user wishes to remove then calls the remove method.
	 *
	 * <hr>
	 * Date created: Apr 3, 2018
	 * 
	 */

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

	/**
	 * firstNameList displays the first names from all the contacts in the addressbook in a neatly fashion
	 *
	 * <hr>
	 * Date created: Apr 3, 2018
	 * 
	 * @return String output
	 */

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

	/**
	 * findAContact verifies by name which contact the user is looking for then calls the toString for that specific
	 * contact.
	 *
	 * <hr>
	 * Date created: Apr 4, 2018
	 * 
	 * @throws Exception if the contact is not found
	 */

	public void findAContact ( ) throws Exception
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
			throw new Exception ("Contact not found!");
		}

	}

	/**
	 * searchForType verifies which type the user wants to search for then searches through the entire addressBook
	 * returning the toString (get method) for each contact found with that type
	 *
	 * <hr>
	 * Date created: Apr 4, 2018
	 * 
	 * @param String input
	 * @throws Exception if the type is not found
	 */
	public void searchForType (String input) throws Exception
	{

		String search = input.toUpperCase ( );

		if (search.equals ("FAMILY") || search.equals ("CHURCH") || search.equals ("FRIEND") ||
						search.equals ("BUSINESSCOLLEAGUE") ||
						search.equals ("SERVICEPERSON") || search.equals ("CUSTOMER") || search.equals ("OTHER"))
		{
			for (int i = 0; i < addressBook.size ( ); i++ )
			{
				if (addressBook.get (i).getType ( ).equals (search))
				{
					System.out.println (addressBook.get (i) + "\n\n");
				}
			}
		}
		else
		{
			throw new Exception ("Type not found!");
		}

	}

	/**
	 * searchForZip verifies which type the user wants to search for then searches through the entire addressBook
	 * returning the toString (get method) for each contact found with that zip
	 *
	 * <hr>
	 * Date created: Apr 4, 2018
	 * 
	 * @param String input
	 * @throws Exception if the Zip is invalid
	 */

	public void searchForZip (String input) throws Exception
	{

		String search = input.toUpperCase ( );

		if (search.length ( ) < 6 && search.length ( ) > 0)
		{
			for (int i = 0; i < addressBook.size ( ); i++ )
			{
				if (addressBook.get (i).getZip ( ).equals (search))
				{
					System.out.println (addressBook.get (i) + "\n\n");
				}
			}
		}
		else
		{
			throw new Exception ("Zip invalid!");
		}

	}

	/**
	 * sorByName sorts the entire addressbook in ascending order by name.
	 *
	 * <hr>
	 * Date created: Apr 5, 2018
	 * 
	 */
	public void sortByName ( )
	{
		Collections.sort (addressBook, new Comparator <Contact> ( )
		{
			public int compare (Contact c1, Contact c2)
			{
				return Integer.valueOf (c1.getName ( ).compareTo (c2.getName ( )));
			}
		});
	}

}
