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
 * Enter type purpose here
 *
 * <hr>
 * Date created: Mar 18, 2018
 * <hr>
 * @author Ryan Shupe
 */
public class Driver
{
	public static void main (String[] args) {
		
	
	Contact hey = new Contact();
	hey.setEmail("hey@lo.com");
	
	System.out.println (hey.getEmail());
	
	hey.setPhone ("6511231582");
	System.out.println (hey.getPhone ( ));
	
	hey.setType ("FRIEND");
	System.out.println (hey.getType ( ));
	}
}
