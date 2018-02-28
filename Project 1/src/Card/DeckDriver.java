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
 * to create and displays an entire Deck of Cards, shuffle the Deck and display it again,
 * create another Deck as a copy of the first Deck, and deal and display two hands of 7 Cards
 * each from that second Deck.
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
	 * main method is where the whole program is run from.
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
		Deck deck1 = new Deck ( );

		System.out.println (deck1);

		printLine ( );

		deck1.shuffle ( );

		System.out.println (deck1);

		printLine ( );

		Deck deck2 = new Deck (deck1);

		System.out.println (deck2.dealAHand (7));

		printLine ( );

		System.out.println (deck2.dealAHand (7));

	}

	/**
	 * A simple method to spam println for clarity
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * <hr>
	 * 
	 * @param args
	 */
	public static void printLine ( )
	{
		for (int i = 0; i < 10; i++ )
		{
			System.out.println ( );
		}
	}

}
