package addressBook;
/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: Project 2
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Mar 18, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * To test the contact class.
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class Driver
{
	public static void main (String[] args) {
		
	
	Contact c1 = new Contact();
	Contact c2 = new Contact("Customer", "John Smith", "865 Google Drive", "Keyboard Town", "CA", "76852", "6578452135", "SmithJ@gmail.com", "JohnSmith", "johnsmith.jpg");
	Contact c3 = new Contact(c2);
	
	System.out.println (c1.toString ( ));
	
	System.out.println ();
	
	c1.setState("TND");
	c1.setEmail ("shu.per@etsu.edu");
	c1.setAddr ("423 Street Ave");
	c1.setPhone ("423846451");
	c1.setType ("Friend");
	c1.setPhotoPath ("myphoto.png");
	
	System.out.println (c1.toString ( ));
	
	System.out.println ();
	
	System.out.println (c2.toString ( ));
	
	System.out.println ();
	
	System.out.println (c3.toString ( ));
	
	}
}
