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
import java.util.Random;

/**
 * Create a class that uses the Card class and emulates a Deck of cards.
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

		nextCard = 0;
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
	 * shuffle shuffles the deck once
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * 
	 */

	public void shuffle ( )
	{

		for (int i = 0; i < deck.length; i++ )
		{
			Random rand = new Random ( );
			int randomNum = rand.nextInt (deck.length - 1);

			Card temp = new Card (deck [i]);
			deck [i] = new Card (deck [randomNum]);
			deck [randomNum] = new Card (temp);

		}

		nextCard = 0;
	}

	/**
	 * shuffle shuffles the deck according to how many times the user wants.
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @param int shuffleTimes
	 */

	public void shuffle (int shuffleTimes)
	{
		for (int i = 0; i < shuffleTimes; i++ )
		{
			for (int m = 0; m < deck.length; m++ )
			{
				Random rand = new Random ( );
				int randomNum = rand.nextInt (deck.length - 1);

				Card temp = new Card (deck [m]);
				deck [m] = new Card (deck [randomNum]);
				deck [randomNum] = new Card (temp);

			}

			nextCard = 0;
		}
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
		Card deltCard = new Card (deck [nextCard]);
		nextCard++ ;

		if (nextCard >= deck.length)
		{
			nextCard = deck.length - 1;
		}
		
		return deltCard; //returns a card
	}

	/**
	 * DealAHand deals a hand of cards any size
	 * 
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @param int handSize
	 * @return String
	 */

	public Hand dealAHand (int handSize)
	{
		Hand hand = new Hand(handSize);
		
		for (int i = 0; i <= handSize; i ++) {
			hand.addCard (dealACard());
		}
		
		return hand;
	}

	/**
	 * toString converts deck array into a readable format with help from toString from Card class.
	 *
	 * <hr>
	 * Date created: Feb 26, 2018
	 *
	 * @return String output
	 */

	public String toString ( )
	{
		String [ ] output = new String [deck.length];

		for (int i = 0; i < deck.length; i++ )
		{
			output [i] = new Card (deck [i]).toString ( ) + "\n";
		}

		return Arrays.toString (output).replace (",", "").replace ("[", " ").replace ("]", ""); //returns formatted array String

	}

}
