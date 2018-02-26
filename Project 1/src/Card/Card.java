/**
 * ---------------------------------------------------------------------------
 * File name: Card.java
 * Project name: project 1
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shupe Ryan, shuper@etsu.edu
 * Course: CSCI 1260
 * Creation Date: Feb 26, 2018
 * ---------------------------------------------------------------------------
 */

package Card;

import Card.Card;
import Card.Face;
import Card.Suit;

/**
 * To create a card
 *
 * <hr>
 * Date created: Feb 26, 2018
 * <hr>
 * 
 * @author Ryan Shupe
 */

public class Card
{
	private Suit	suit;
	private Face	face;

	public Card ( )
	{
		suit = Suit.SPADES;
		face = Face.ACE;
	}

	public Card (Card original)
	{
		suit = original.suit;
		face = original.face;
	}

	public Card (int n)
	{
		face = Face.values ( ) [n % 13];
		suit = Suit.values ( ) [n % 4];
	}

	public String toString ( )
	{
		String output = "the " + face + " of " + suit;
		return output;
	}
}