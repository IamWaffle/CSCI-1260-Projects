/**
 * ---------------------------------------------------------------------------
 * File name: Hand.java
 * Project name: project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Mar 12, 2018
 * ---------------------------------------------------------------------------
 */

package Card;

import java.util.Arrays;

/**
 * hand
 *
 * <hr>
 * Date created: Mar 12, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */
public class Hand
{
	private int			handSize;
	private int			cardsInHand;
	private Card [ ]	hand;

	public Hand ( )
	{
		handSize = 5;
		cardsInHand = 0;

	}

	public Hand (int handSize)
	{
		if (handSize > 52 && handSize < 1)
		{
			this.handSize = 5;
		}
		else
		{
			this.handSize = handSize;
		}

		cardsInHand = 0;
	}

	public Hand (Hand handIn)
	{
		handSize = handIn.handSize;
		cardsInHand = handIn.cardsInHand;

		for (int i = 0; i < handIn.hand.length; i++ )
		{
			this.hand [i] = handIn.hand [i];
		}
	}

	public void addCard (Card card)
	{
		if (cardsInHand < handSize)
		{
			hand [cardsInHand] = card;
			cardsInHand++ ;
		}

	}

	public String toString ( )
	{
		String [ ] output = new String [hand.length];

		for (int i = 0; i < hand.length; i++ )
		{
			output [i] = new Card (hand [i]).toString ( ) + "\n";
		}

		return Arrays.toString (output).replace (",", "").replace ("[", " ").replace ("]", ""); // returns formatted
																								 // array String
	}
}
