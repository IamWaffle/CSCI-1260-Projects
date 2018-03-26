package addressBook;

import java.util.*;
import lib.ArrayOperations;
import java.io.*;

/**
 * ---------------------------------------------------------------------------
 * File name: Contact.java
 * Project name: Project 2
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Mar 18, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * Contact class is a class that hold information about a contact.
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Contact
{

	ContactType			type;							// the Contact type
	private String		name;							// String to hold the name
	private String		streetAddress;					// String to hold the address
	private String		city;							// String to hold the city
	private String		state;							// String to hold the state
	private String		zipCode;						// String to hold the zip code
	private String		phone;							// String to hold the phone number (in format)
	private String		email;							// String to hold the email (in format)
	private String		photoName;						// String to hold the name of the photo
	private String		photoPath;						//String to hold the path of the file (has to be jpg)
	
	private String [ ]	statesArray	= new String [50];		   // Array to hold the state abbreviations

	private File				file;															// File object
	private Scanner				inputFile;														// Scanner that opens the file

	/**
	 * No Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 */

	public Contact ( )
	{
		// if this is called and nothing is passed in then it sets the default values to this.
		setType ("OTHER");
		setName ("Temp Name");
		setAddr ("123 Street St.");
		setCity ("Temp City");
		setState ("XX");
		setZip ("00000");
		setPhone ("0000000000");
		setEmail ("temp@email.address");
		setPhotoName("Temp Photo Name");
		setPhotoPath("TempPath.jpg");
	}

	/**
	 * Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param ContactType type, String name, String addr, String city, String state, String zip, String phone,
	 *            String email
	 */

	public Contact (String type, String name, String addr, String city, String state, String zip, String phone,
					String email, String photoName, String photoPath)
	{
		// sets the values passed in to the variables of the contact.
		setType (type);
		setName (name);
		setAddr (addr);
		setCity (city);
		setState (state);
		setZip (zip);
		setPhone (phone);
		setEmail (email);
		setPhotoName (photoName);
		setPhotoPath (photoPath);
	}

	/**
	 * Copy Constructor
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param Contact origninal
	 */

	public Contact (Contact original)
	{
		// sets the values from the original Contact to this one
		setType(original.getType ( ));
		setName (original.getName ( ));
		setAddr (original.getAddr ( ));
		setCity (original.getCity ( ));
		setState (original.getState ( ));
		setZip (original.getZip ( ));
		setPhone(original.getPhone ( ));
		setEmail (original.getEmail ( ));
		setPhotoName(original.getPhotoName ( ));
		setPhotoPath(original.getPhotoPath ( ));
	}

	/**
	 * ToString - sends back the contact elements in a readable format
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return String output
	 */

	public String toString ( )
	{
		// creates a string that has neatly formatted details
		String output = "Name: " + getName ( ) +
						"\nType: " + getType ( ) +
						"\nAddress: " + getAddr ( ) +
						"\nCity: " + getCity ( ) +
						"\nState: " + getState ( ) +
						"\nZip: " + getZip ( ) +
						"\nPhone: " + getPhone ( ) +
						"\nEmail: " + getEmail ( ) +
						"\nPhoto Name: " + getPhotoName ( ) +
						"\nPhoto Path: " + getPhotoPath ( );
		return output; // returns the string
	}

	/**
	 * fillStates - fills the states array
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 */

	public void fillStates ( )
	{
		// trys to open the file
		try
		{
			file = new File ("States.txt");
			inputFile = new Scanner (file);

			int i = 0;
			// while loop to fill the array
			while (inputFile.hasNext ( ))
			{
				statesArray [i] = inputFile.nextLine ( );
				i++ ;
			}
			// close file
			inputFile.close ( );
		}
		// if it cannot find the file then it catches the expection and shows this error message
		catch (IOException e)
		{
			System.out.println ("Cannot open states file.");
		}
	}

	// setters
	/**
	 * setType - sets the type of the contact from the contact type enum
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String typeString
	 */
	public void setType (String typeString)
	{
		// trys to set the contact type to the one passed in
		try
		{
			type = ContactType.valueOf (typeString.toUpperCase ( ));
		}

		// if it doesnt exist then it is set to OTHER
		catch (Exception e)
		{
			type = ContactType.OTHER;
		}
	}

	/**
	 * setName - sets the name of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String name
	 */
	public void setName (String name)
	{
		this.name = name; // sets the name variable to the one passed in
	}

	/**
	 * setAddr - sets the address of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String addr
	 */

	public void setAddr (String addr)
	{
		streetAddress = addr; // sets the var to the thing passed in
	}

	/**
	 * setCity - sets the city of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String city
	 */

	public void setCity (String city)
	{
		this.city = city; // sets the city var to what is passed in
	}

	/**
	 * setState - makes sure the state is valid, then sets the state of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String statePassed
	 */

	public void setState (String statePassed)
	{
		// fills the array / makes the var passed in uppercase
		statePassed.toUpperCase ( );
		fillStates ( );

		// checks to see if what is passed in is valid and is in the array
		if (ArrayOperations.sequentialSearch (statesArray, statePassed))
		{
			state = statePassed;
		}
		// if it isnt then it is set to XX
		else
		{
			state = "XX";
		}
	}

	/**
	 * setZip - sets the zip of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String zip
	 */

	public void setZip (String zip)
	{
		zipCode = zip; // sets the zip code to the var passed in
	}

	/**
	 * setPhone - sets the phone number of the contact the correct format
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String number
	 */

	public void setPhone (String number)
	{
		if (number.indexOf ("(") >= 0 && number.indexOf ("") >= 0 && number.indexOf ("-") < number.indexOf ("."))
		{ // checks to see if it is already formatted.
			phone = number;
		}
		else
		{
			// checks to see if the phone number is the appropriate length, if it isnt it is set to (000)000-0000.
			if (number.length ( ) > 10 || number.length ( ) < 10)
			{
				phone = "(000)000-0000.";
			}
			// if it is the correct length it formats it to (000)000-0000 form
			else
			{
				phone = "(" + number.substring (0, 3) + ")" + number.substring (3, 6) + "-" + number.substring (6, 10) +
								".";
			}
		}

	}

	/**
	 * setEmail - sets the email of the contact the correct format
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @param String input
	 */
	public void setEmail (String input)
	{
		// checks to see if the @ exists and if . comes after @
		if (input.indexOf ("@") >= 0 && input.indexOf ("@") < input.indexOf ("."))
		{
			email = input;
		}
		// if not email is set to invalid
		else
		{
			email = "invalid@address.given";
		}
	}
	
	/**
	 * setPhotoName - sets the photo name 
	 *
	 * <hr>
	 * Date created: Mar 25, 2018
	 * 
	 * @param String name
	 */
	public void setPhotoName (String name)
	{
		photoName = name;
	}

	/**
	 * setPhotoPath - sets the path of the file (has to be a jpg)
	 *
	 * <hr>
	 * Date created: Mar 25, 2018
	 * 
	 * @param String path
	 */
	public void setPhotoPath (String path)
	{
		if (path.contains (".jpg"))
		{
			photoPath = path;
		}
		else
		{
			photoPath = "InvalidFileName.jpg";
		}
	}

	// getters
	/**
	 * getType - returns the type of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return type.toString()
	 */
	public String getType ( )
	{
		return type.toString ( ); // returns the tostring of the type
	}

	/**
	 * getName - returns the Name of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return name
	 */
	public String getName ( )
	{
		return name; // returns name var
	}

	/**
	 * getAddr - returns the address of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return streetAddress
	 */

	public String getAddr ( )
	{
		return streetAddress; // returns streetAddress var
	}

	/**
	 * getCity - returns the city of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return city
	 */

	public String getCity ( )
	{
		return city; // returns city var
	}

	/**
	 * getState - returns the state of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return state
	 */
	public String getState ( )
	{
		return state; // returns state var
	}

	/**
	 * getZip - returns the zip code of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return zipCode
	 */
	public String getZip ( )
	{
		return zipCode; // returns zipcode var
	}

	/**
	 * getPhone - returns the phone number of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return phone
	 */
	public String getPhone ( )
	{
		return phone; // returns phone var
	}

	/**
	 * getEmail - returns the email address of the contact
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return email
	 */

	public String getEmail ( )
	{
		return email; // returns email var
	}
	
	/**
	 * getPhotoName - returns the photo name
	 *
	 * <hr>
	 * Date created: Mar 25, 2018
	 * 
	 * @return photoName
	 */
	
	public String getPhotoName ( )
	{
		return photoName; //returns photoName var
	}
	
	/**
	 * getPhotoPath = returns the photo path
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 * 
	 * @return photoPath
	 */

	public String getPhotoPath ( )
	{
		return photoPath;	//returns photoPath var
	}

}
