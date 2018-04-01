import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import addressBook.*;

/**
 * Driver will host the many options you can do with the addressBook, add contacts remove, view, etc..
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Driver
{
	public static void main (String [ ] args)
	{
		Scanner input = new Scanner (System.in);

		System.out.println ("Welcome to the program!");
		System.out.print ("What is the name of the address book owner?: ");
		AddressBook addressBook = new AddressBook ( );
		addressBook.setOwnerName (input.nextLine ( ));

		boolean exit = false;

		do
		{

			int menuChoice = menu ( );

			if (menuChoice == 1)
			{
				try
				{
					fillAddressBook (addressBook);
					System.out.println ("Task Completed!\n\n");
				}
				catch (Exception e)
				{
					System.out.println (e.getMessage ( ));
				}
			}
			else if (menuChoice == 2)
			{
				addressBook.add (addAContact ( ));
			}
			else if (menuChoice == 5)
			{
				if (addressBook.toString ( ) != null)
				{
					System.out.println (addressBook.toString ( ));
					System.out.println ("Task Completed!\n\n");
				}
				else
				{
					System.out.println ("Either there was an error, or they're no contacts in the system.");
				}

			}
			else if (menuChoice == 10)
			{
				exit = true;
			}

		}
		while ( !exit);

	}

	public static int menu ( )
	{
		Scanner input = new Scanner (System.in);
		int choice = -1;

		do
		{
			try
			{
				System.out.println ("-------------------MAIN---MENU----------------");
				System.out.println ("1. Import contacts from a file.");
				System.out.println ("2. Create and add a new Contact and update the AddressBook.");
				System.out.println ("3. Edit an existing Contact and update the AddressBook.");
				System.out.println ("4. Remove a Contact from the AddressBook by name.");
				System.out.println ("5. Display all Contacts from the AddressBook.");
				System.out.println ("6. Find and display a Contact by a given name in the AddressBook.");
				System.out.println ("7. Display all Contacts of a given ContactType");
				System.out.println ("8. Display all Contacts that are in a specified zip code.");
				System.out.println ("9. Sort the Contacts in the AddressBook by name.");
				System.out.println ("10. Exit");
				System.out.println ("----------------------------------------------");
				System.out.print ("Enter a number: ");

				choice = input.nextInt ( );
			}
			catch (Exception e)
			{
				System.out.println ("\n\nPlease enter a number...\n\n");
				input.nextLine ( );
			}

		}
		while (choice < 1 || choice > 10);
		return choice;
	}

	public static void fillAddressBook (AddressBook addressBook)
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
						addressBook.add (c);
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

	public static Contact addAContact ( )
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

		System.out.println ("Contact Added!\n\n");
		return c;
	}

}
