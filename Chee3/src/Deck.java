/**
 * The Deck Class represents a collection of Card objects, it creates an array deckOfCards and adds 104 cards into that array. There is
 * a deal method that returns one card which is dealt and a shuffle method that shuffles the entire deck randomly. I also created a deckLength method
 * which gets the length of the deck.
 * 
 * @author Vincent Chee
 * @version 29/01/15
 */

import java.util.Random;

public class Deck {
	private static int deckLength = 104;
	private static Card[] deckOfCards = new Card[deckLength];
	private int cardsDealt = 0;
	private int numDeck = 2;

	private String[] Suits = { "Spades", "Hearts", "Diamonds", "Clubs" };

	private String[] Values = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
			"Eight", "Nine", "Ten", "Jack", "Queen", "King" };

	/**
	 * Deck Constructor creates the deck, uses to for loops by going through
	 * each suit and then each value
	 */
	public Deck() {
		int i = 0;
		for (int counter = 0; counter < numDeck; counter++) {
			for (int numSuits = 0; numSuits < Suits.length; numSuits++) {
				for (int numValue = 0; numValue < Values.length; numValue++) {
					Card newCard = new Card(Suits[numSuits], Values[numValue]);
					deckOfCards[i] = newCard;
					i++;
				}
			}
		}
	}

	/**
	 * the toString method returns the deck as an entire string
	 */
	public String toString() {
		String cardDeck = "";
		for (int counter = 0; counter < deckOfCards.length; counter++) {
			cardDeck += deckOfCards[counter].toString();
			cardDeck += "\n";
		}
		return cardDeck;
	}

	/**
	 * @return next card dealt when called when there are no cards to be dealt
	 *         and .deal is called, there is an error message
	 */
	public Card deal() {
		Card cardDeal = deckOfCards[cardsDealt];
		cardsDealt++;
		return cardDeal;
	}

	/**
	 * shuffle method randomizes the deck by picking random number and swap's
	 * that index's card with the first index [0], then pick's a number from
	 * 1-104 and swaps and this repeats until the whole deck is randomized. It
	 * utilize java.util.Random.
	 */
	public void shuffle() {
		Random rand = new Random();
		int max = deckLength;
		for (int count = 0; count < deckLength; count++) {
			int randomNum = rand.nextInt(max - count) + count;
			Card randomCard = deckOfCards[randomNum];
			deckOfCards[randomNum] = deckOfCards[count];
			deckOfCards[count] = randomCard;
		}
	}
	
	/**
	 * deckLength checks the length of deck
	 * @return the length of deck
	 */
	public int deckLength() {
		return deckLength;
	}
}