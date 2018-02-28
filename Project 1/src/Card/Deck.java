/**
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Feb 26, 2018
 * ---------------------------------------------------------------------------
 */

package Card;

import java.util.Arrays;

/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Feb 26, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Deck
{
	private Card [ ]	deck	= new Card [52];
	private int			nextCard;

	/**
	 * No Arg Constructor
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * 
	 */
	public Deck ( )
	{
		for (int i = 0; i < deck.length; i++ )
		{
			deck [i] = new Card (i);
		}
	}

	/**
	 * Arg Copy Constructor
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @param Deck existingDeck
	 */

	public Deck (Deck existingDeck)
	{
		for (int i = 0; i < deck.length; i++ )
		{
			deck [i] = new Card (existingDeck.deck [i]);
		}
	}

	/**
	 * shuffle shuffles the deck
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * 
	 */

	public void shuffle ( )
	{

	}

	/**
	 * DealACard deals a card
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 * 
	 * @return card
	 * 
	 */

	public Card dealACard ( )
	{
		return null;

	}

	/**
	 * DealAHand deals a hand
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @param int handSize
	 * @return Card
	 */

	public String dealAHand (int handSize)
	{
		return null;
	}

	/**
	 * toString converts into a readable format
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @return String output
	 */

	public String toString ( )
	{
		String [ ] output = new String [52];

		for (int i = 0; i < deck.length; i++ )
		{
			output  [i] = new Card (i).toString ( ) + "\n";
		}

		return Arrays.toString (output).replace (",", "").replace ("[", " ").replace ("]", "");
		
	}

}
