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

	ContactType			type;			//the Contact type
	private String		name;			//String to hold the name
	private String		streetAddress;  //String to hold the address
	private String		city;			//String to hold the city
	private String		state;			//String to hold the state
	private String		zipCode;		//String to hold the zip code
	private String		phone;			//String to hold the phone number (in format)
	private String		email;			//String to hold the email (in format)

	private String [ ]	statesArray	= new String [50];   //Array to hold the state abbreviations 

	File				file;			//File object
	Scanner				inputFile;		//Scanner that opens the file

	
	/**
	 * No Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 18, 2018
	 */
	
	public Contact ( )
	{
		setType ("OTHER");
		setName ("Temp Name");
		setAddr ("123 Street St.");
		setCity ("Temp City");
		setState ("XX");
		setZip ("00000");
		setPhone ("0000000000");
		setEmail ("temp@email.address");
	}

	public Contact (ContactType type, String name, String addr, String city, String state, String zip, String phone,
					String email)
	{
		this.type = type;
		this.name = name;
		streetAddress = addr;
		this.city = city;
		this.state = state;
		zipCode = zip;
		this.phone = phone;
		this.email = email;
	}

	public Contact (Contact original)
	{
		setName (original.getName ( ));
		setAddr (original.getAddr ( ));
		setCity (original.getCity ( ));
		setState (original.getState ( ));
		setZip (original.getZip ( ));
		setPhone (original.getPhone ( ));
		setEmail (original.getEmail ( ));
	}

	public String toString ( )
	{
		String output = "Name: " + getName ( ) +
						"\nType: " + getType ( ) +
						"\nAddress: " + getAddr ( ) +
						"\nCity: " + getCity ( ) +
						"\nState: " + getState ( ) +
						"\nZip: " + getZip ( ) +
						"\nPhone: " + getPhone ( ) +
						"\nEmail: " + getEmail ( );
		return output;
	}

	public void fillStates ( )
	{
		try
		{
			file = new File ("States.txt");
			inputFile = new Scanner (file);

			int i = 0;
			while (inputFile.hasNext ( ))
			{
				statesArray [i] = inputFile.nextLine ( );
				i++ ;
			}
			inputFile.close ( );
		}
		catch (IOException e)
		{
			System.out.println ("Cannot open states file.");
		}
	}

	// setters
	public void setType (String typeString)
	{
		try
		{
			type = ContactType.valueOf (typeString.toUpperCase ( ));
		}
		catch (Exception e)
		{
			type = ContactType.OTHER;
		}
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public void setAddr (String addr)
	{
		streetAddress = addr;
	}

	public void setCity (String city)
	{
		this.city = city;
	}

	public void setState (String statePassed)
	{
		statePassed.toUpperCase ( );
		fillStates ( );

		if (ArrayOperations.sequentialSearch (statesArray, statePassed))
		{
			state = statePassed;
		}
		else
		{
			state = "XX";
		}
	}

	public void setZip (String zip)
	{
		zipCode = zip;
	}

	public void setPhone (String number)
	{
		if (number.length ( ) > 10 || number.length ( ) < 10)
		{
			phone = "(000)000-0000.";
		}
		else
		{
			phone = "(" + number.substring (0, 3) + ")" + number.substring (3, 6) + "-" + number.substring (6, 10) +
							".";
		}

	}

	public void setEmail (String input)
	{
		if (input.indexOf ("@") >= 0 && input.indexOf ("@") < input.indexOf ("."))
		{
			email = input;
		}
		else
		{
			email = "invalid@address.given";
		}
	}

	// getters
	public String getType ( )
	{
		return type.toString ( );
	}

	public String getName ( )
	{
		return name;
	}

	public String getAddr ( )
	{
		return streetAddress;
	}

	public String getCity ( )
	{
		return city;
	}

	public String getState ( )
	{
		return state;
	}

	public String getZip ( )
	{
		return zipCode;
	}

	public String getPhone ( )
	{
		return phone;
	}

	public String getEmail ( )
	{
		return email;
	}

}
