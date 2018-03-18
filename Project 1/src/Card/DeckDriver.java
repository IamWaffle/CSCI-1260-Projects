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

import java.util.Scanner;

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
		int handSize;
		int numPlayers;
		boolean ok = false;

		Scanner input = new Scanner (System.in);

		do
		{
			try
			{
				System.out.print ("How many cards are in one hand?: ");
				handSize = input.nextInt ( );

				System.out.print ("How many players are playing?: ");
				numPlayers = input.nextInt ( );

				Deck gameDeck = new Deck ();

				while ( (handSize * numPlayers) > 52)
				{
					printLine ( );
					System.out.println (
						"ERROR: They're not enough cards in the deck to deal " + numPlayers + " hands of " +
										handSize + " cards. Try Again...");
					System.out.print ("How many cards are in one hand?: ");
					handSize = input.nextInt ( );

					System.out.print ("How many players are playing?: ");
					numPlayers = input.nextInt ( );
				}

				printLine ( );

				gameDeck.shuffle ( );

				for (int i = 0; i < numPlayers; i++ )
				{
					System.out.println ("Player " + (i + 1) + ": \n" + gameDeck.dealAHand (handSize).toString ( ));
				}
				ok = true;
			}
			catch (Exception e)
			{
				System.out.println ("That is not valid... Try Again");
				input.nextLine ( );
			}
		}
		while ( !ok);
	}

	/**
	 * A simple method to spam println for clarity
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * <hr>
	 * 
	 * 
	 */
	public static void printLine ( )
	{
		for (int i = 0; i < 5; i++ )
		{
			System.out.println ( );
		}
	}

}
