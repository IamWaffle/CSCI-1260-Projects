/**
 * ---------------------------------------------------------------------------
 * File name: DeckDriver.java
 * Project name: project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Feb 26, 2018
 * ---------------------------------------------------------------------------
 */

package Card;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Feb 26, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class DeckDriver
{

	/**
	 * to create and displays an entire Deck of Cards, shuffle the Deck and display it again,
	 * create another Deck as a copy of the first Deck, and deal and display two hands of 7 Cards
	 * each from that second Deck.
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * <hr>
	 * 
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		Deck temp = new Deck ( );

		System.out.println (temp.toString ( ));

	}

}
