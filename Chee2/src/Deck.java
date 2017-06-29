/**
 * The Deck Class represents a collection of Card objects, it creates an array deckOfCards and adds 52 cards into that array. There is
 * a deal method that returns one card which is dealt and a shuffle method that shuffles the entire deck randomly.
 * 
 * @author Vincent Chee
 * @version 02/02/15
 */

import java.util.Random;

public class Deck {
	private static int deckLength = 52;
	private static Card[] deckOfCards = new Card[deckLength];

	private int cardsDealt = 0;

	private String[] Suits = {"Spades", "Hearts", "Diamonds", "Clubs"};

	private String[] Values = {"Ace", "Two", "Three", "Four", "Five", 
			"Six", "Seven", "Eight", "Nine", "Ten",
			"Jack", "Queen", "King"};

	/**
	 * Deck Constructor creates the deck, uses to for loops by going through each suit and then each value
	 */

	public Deck() {
		int cardIndex = 0;
		for (String suit : Suits) {
			for (String value : Values) {
				Card newCard = new Card(suit,value);
				deckOfCards[cardIndex] = newCard;
				cardIndex++;
			}
		}
	}

	/**
	 * the toString method returns the deck as an entire string
	 */
	public String toString() {
		String cardDeck = "";
		for (int cardIndex = 0; cardIndex < deckOfCards.length; cardIndex++ ){
			cardDeck += deckOfCards[cardIndex].toString();
			cardDeck += "\n";
		}
		return cardDeck;
	}

	/**
	 * @return next card dealt when called
	 * when there are no cards to be dealt and .deal is called, there is an error message
	 */
	public Card deal() {
		Card cardDeal = deckOfCards[cardsDealt];
		cardsDealt ++;
		return cardDeal;

	}

	/**
	 * shuffle method randomizes the deck by picking random number and swap's that index's card with the first index [0], then pick's
	 * a number from 1-51 and swaps and this repeats until the whole deck is randomized. It utilize java.util.Random.
	 */
	public void shuffle() {
		Random rand = new Random(); 
		int max = deckLength;
		for(int count = 0; count < deckLength; count++) {
			int randomNum = rand.nextInt(max-count) + count;
			Card randomCard = deckOfCards[randomNum];
			deckOfCards[randomNum] = deckOfCards[count];
			deckOfCards[count] = randomCard;
		}		
	}	
}
