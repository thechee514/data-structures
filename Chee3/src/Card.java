/**
 * The Card class represents a single playing card. It has two getter methods
 * returning the suit and value as well as a toString method which prints out
 * representation of the card as a string.
 * 
 * @author Vincent Chee
 * @version 29/01/15
 */

public class Card {
	final private String suit;
	final private String value;

	/**
	 * @return suit of card
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return value of card
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param Suits
	 *            - integer value representing a specific card suit
	 * @param Values
	 *            - integer value representing a specific card value
	 */
	public Card(String suits, String values) {
		suit = suits;
		value = values;
	}

	/**
	 * Associates value to string and returns card as printable string
	 */
	public String toString() {
		return value + " of " + suit;
	}
}
