/**
 * The SolitaireSimulator class handles the simulation of the game. It initializes a new deck of cards in the constructor and shuffles 
 * it. Simulation follows the rules of the game, deals 4 cards then checks the condition and removes accordingly. After all cards
 * have been dealt, it checks whether or not it wins.
 * 
 * @author Vincent Chee
 * @version 02/02/15
 */

public class SolitaireSimulator {
	private Deck aDeck = new Deck(); 
	private static Card[] faceUp = new Card[52];
	private int faceUpCards = 0;
	private int cardsDealt = 0;

	/**
	 * Constructor method creates new deck and shuffles it
	 */
	public SolitaireSimulator() {
		aDeck.shuffle();
	}

	/**
	 * playGame has a precondition of a new shuffled deck
	 */
	public void playGame() {
		while (cardsDealt != faceUp.length) {
			faceUp[faceUpCards] = aDeck.deal();
			faceUpCards++;
			cardsDealt++;
			checkCondition();
		}
		checkCondition();
	}

	/**
	 * checkCondition method checks if the one of the two conditions are true and removes cards accordingly
	 */
	public void checkCondition() {
		if (faceUpCards >= 4) {
			if (faceUp[faceUpCards-1].getSuit().equals(faceUp[faceUpCards-2].getSuit())
					&& faceUp[faceUpCards-2].getSuit().equals(faceUp[faceUpCards-3].getSuit())
					&& faceUp[faceUpCards-3].getSuit().equals(faceUp[faceUpCards-4].getSuit())) {

				faceUp[faceUpCards-1] = null;
				faceUp[faceUpCards-2] = null;
				faceUp[faceUpCards-3] = null;
				faceUp[faceUpCards-4] = null;

				faceUpCards-=4;
				checkCondition();

			} else if (faceUp[faceUpCards-1].getSuit().equals(faceUp[faceUpCards-4].getSuit())) {
				faceUp[faceUpCards-2] = null;
				faceUp[faceUpCards-3] = faceUp[faceUpCards-1];
				faceUp[faceUpCards-1] = null;
				faceUpCards -= 2;
				checkCondition();
			}
		}	
	}

	/**
	 * @return whether we win (true) or lose (false)
	 */
	public boolean checkWin() {
		return faceUpCards == 0;
	}
}
