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

	/**
	 * No Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 12, 2018
	 */

	public Hand ( )
	{
		handSize = 5;
		cardsInHand = 0;

	}

	/**
	 * Arg Constructor
	 *
	 * <hr>
	 * Date created: Mar 12, 2018
	 */

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

		hand = new Card [handSize];

		cardsInHand = 0;
	}

	/**
	 * Copy Constructor
	 *
	 * <hr>
	 * Date created: Mar 12, 2018
	 */

	public Hand (Hand handIn)
	{
		handSize = handIn.handSize;
		cardsInHand = handIn.cardsInHand;

		hand = new Card [handSize];

		for (int i = 0; i < handIn.hand.length; i++ )
		{
			this.hand [i] = handIn.hand [i];
		}

	}

	/**
	 * adds one card to the hand
	 * 
	 *
	 * <hr>
	 * Date created: Mar 12, 2018
	 *
	 * @param card Card
	 * 
	 */
	public void addCard (Card card)
	{
		if (cardsInHand < handSize)
		{
			hand [cardsInHand] = card;
			cardsInHand++ ;
		}
	}

	/**
	 * toString converts hand array into a readable format with help from toString from Card class.
	 *
	 * <hr>
	 * Date created: Mar 12, 2018
	 *
	 * @return String output
	 */

	public String toString ( )
	{
		String output = "";

		for (int i = 0; i < handSize; i++ )
		{
			output += hand [i] + "\n";
		}

		return output;
	}
}
