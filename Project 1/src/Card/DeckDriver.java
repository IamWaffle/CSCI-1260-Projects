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
		Deck temp2 = new Deck (temp);

		System.out.println (temp);

		for (int i = 0; i < 20; i++ )
		{
			System.out.println ( );
		}

		temp.shuffle ( );
		temp.shuffle ( );
		temp.shuffle ( );

		System.out.println (temp);
		
		for (int i = 0; i < 20; i++ )
		{
			System.out.println ( );
		}
		
		
		for (int i = 0; i < 60; i++ )
		{
			System.out.println ("Delt Card:" + temp.dealACard ( ));
		}
		
		for (int i = 0; i < 20; i++ )
		{
			System.out.println ( );
		}
		
		temp.shuffle (5);
		
		System.out.println (temp);
		
		for (int i = 0; i < 20; i++ )
		{
			System.out.println ( );
		}
		
		System.out.println (temp.dealAHand (5));
		
	}

}
