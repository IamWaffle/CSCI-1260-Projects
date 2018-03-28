import java.util.*;
import addressBook.*;

/**
 * Driver will host the many options you can do with the addressBook, add contacts remove, view, etc..
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
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

		if(menu() == 1) {
			try
			{
				addressBook.fillAddressBook();
			}
			catch (Exception e)
			{
				System.out.println (e.getMessage());
			}
		}
		
		System.out.println (addressBook.get (0));

	}

	public static int menu ( )
	{

		Scanner input = new Scanner (System.in);
		int choice = -1;

		do
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
		while (choice < 1 || choice > 10);
		return choice;
	}
	

}
