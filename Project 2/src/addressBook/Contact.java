package addressBook;

import java.util.*;
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
 * Enter type purpose here
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Contact
{

	private String	name;
	private String	streetAddress;
	private String	city;
	private String	state;
	private int		zipCode;
	private String	phone;
	private String	email;

	public Contact ( )
	{

	}

	public Contact (int temp)
	{

	}

	public Contact (Contact original)
	{

	}

	public String toString ( )
	{
		String output = "";
		return output;
	}

	// setters
	public void setName (String name)
	{
		this.name = name;
	}

	public void setStreetAddr (String addr)
	{
		streetAddress = addr;
	}

	public void setCity (String city)
	{
		this.city = city;
	}

	public void setState ( )
	{

	}

	public void setZipCode (int zip)
	{
		zipCode = zip;
	}

	public void setPhone (String number)
	{
		if (number.length ( )  > 10 || number.length ( )  < 10)
		{
			phone = "(000)000-0000.";
		}
		else
		{
			phone = "(" + number.substring (0, 3) + ")" + number.substring (3, 6) + "-" + number.substring (6,10) + ".";
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
	public String getEmail ( )
	{
		return email;
	}
	public String getPhone() {
		return phone;
	}
}
