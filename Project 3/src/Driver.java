
import java.util.*;
import addressBook.*;

/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: Project 3
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Mar 18, 2018
 * ---------------------------------------------------------------------------
 */

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
					addressBook.fillAddressBook ( );
					;
					System.out.println ("Task Completed!\n\n");
				}
				catch (Exception e)
				{
					System.out.println (e.getMessage ( ));
				}
			}
			else if (menuChoice == 2)
			{
				addressBook.addAContact ( );

			}
			else if (menuChoice == 3)
			{
				addressBook.editAContact ( );

			}
			else if (menuChoice == 4)
			{
				addressBook.removeAContact ( );

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
			else if (menuChoice == 6)
			{
				try
				{
					addressBook.findAContact ( );
				}
				catch (Exception e)
				{
					System.out.println ("\nCannot find the name in the address book!\n");
				}
			}
			else if (menuChoice == 7)
			{
				try
				{
					System.out.print ("Enter the Type you want to search for: ");
					String search = input.nextLine ( );
					addressBook.searchForType (search);
				}
				catch (Exception e)
				{
					System.out.print ("\n\nType not found or doesn't exist!\n\n");
				}
			}
			else if (menuChoice == 8)
			{
				try
				{
					System.out.print ("Enter the Zip code you want to search for: ");
					String search = input.nextLine ( );
					addressBook.searchForZip (search);
				}
				catch (Exception e)
				{
					System.out.print ("\n\nZip not found or valid!\n\n");
				}
			}

			else if (menuChoice == 9)
			{
				addressBook.sortByName ( );
			}
			else if (menuChoice == 10)
			{
				addressBook.saveAddressBook ( );
				exit = true;
			}

		}
		while ( !exit);

		if (exit == true)
		{
			System.exit ( -1);
		}

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
				System.out.println ("10. Exit & Save");
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
}
