/**
 * The hand class represents one hand. It has a drawCard method, a removeCard method, a seekCard method, a toString method, an isEmpty method and a 
 * cardsInHand method. Each one of these methods are used in the CrazyEights Simulator.
 * 
 * @author Vincent Chee
 * @version 29/01/15
 *
 */

public class Hand {
	private int numHandCards = 7;
	private Card[] hand;
	private int numCards = 0;

	/**
	 * Hand constructor
	 * @param id is the id of the hand
	 * @param gameDeck is the deck to be used in game
	 */
	public Hand(int id, Deck gameDeck) {
		hand = new Card[gameDeck.deckLength() - numHandCards];
		for (int handCards = 0; handCards < numHandCards; handCards++) {
			hand[handCards] = gameDeck.deal();
			numCards++;
		}
	}

	/**
	 * drawCard adds card from deck to hand
	 * @param gameDeck takes cards from specified deck
	 */
	public void drawCard(Deck gameDeck) {
		hand[numCards] = gameDeck.deal();
		numCards++;
	}

	/**
	 * removeCard removes a specified card from hand
	 * @param cardNum specifies which card to remove
	 * @return the removed card 
	 */
	public Card removeCard(int cardNum) {
		Card removedCard = hand[cardNum];
		hand[cardNum] = null;
		Card temp = hand[numCards - 1];
		hand[numCards - 1] = null;
		hand[cardNum] = temp;
		numCards--;
		return removedCard;
	}

	/**
	 * seekCard is similar to removeCard since it returns a card, but
	 * it doesn't remove it from the player's hand 
	 * @param cardNum specified which card to seek
	 * @return the sought card
	 */
	public Card seekCard(int cardNum) {
		return hand[cardNum];
	}

	/**
	 * toString returns the players hand
	 */
	public String toString() {
		String playerHand = "";
		for (int handNum = 0; handNum < numCards; handNum++) {
			playerHand += handNum + ") ";
			playerHand += hand[handNum].toString();
			playerHand += "\n";
		}
		return playerHand;
	}

	/**
	 * isEmpty checks if the hand is empty
	 * @return whether a player's hand is empty
	 */
	public boolean isEmpty() {
		if (hand[0] == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * cardsInHand checks how many cards is in a players hand
	 * @return the number of cards in a players hand
	 */
	public int cardsInHand() {
		return numCards;
	}
}
