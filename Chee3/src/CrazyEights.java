/**
 * The CrazyEights Simulator handles the simulation of the game. It initializes a new deck of cards as an instance variable and shuffles it in the 
 * constructor. Simulation follows the rules of the game. The first player to remove all cards from their hand wins or if both players pass with 
 * no more cards in the deck, it's a draw.
 * @author Vincent Chee
 * @version 29/01/15
 * 
 */

import java.util.Scanner;

public class CrazyEights {
	Deck gameDeck = new Deck();
	private String[] namesOfPlayersArray = new String[14];
	Hand aHand;
	private Card faceUpCard;
	private Hand[] hands;
	private int playerTurn = 0;
	private boolean winner = false;
	private boolean draw = false;
	private int passCounter = 0;
	private String[] crazyEightSuit = new String[1];
	private boolean crazyEight = false;

	/**
	 * Constructor shuffles the deck.
	 */
	public CrazyEights() {
		gameDeck.shuffle();

	}

	/**
	 * playGame creates the hands and prints out the rules. It also has the conditions within so the game can be played.
	 */
	public void playGame() {
		int totalPlayers = numPlayers();

		playerNames(totalPlayers);

		gameRules();

		hands = new Hand[totalPlayers];

		handsCreation(totalPlayers);

		faceUpCard = gameDeck.deal();
		int cardsDealt = 1 + (totalPlayers * 7);
		while (winner == false || draw == false) {
			winner = hands[playerTurn].isEmpty();
			gameDisplay();
			Scanner userInputScanner = new Scanner(System.in);
			if (userInputScanner.hasNextInt()) {
				int convertedUserInput = Integer.parseInt(userInputScanner.next());

				if (convertedUserInput > hands[playerTurn].cardsInHand() - 1 || convertedUserInput < 0) {
					System.out.println("You're out of range, please try again.");

				} else if (crazyEight) {
					if (crazyEightSuit[0] == hands[playerTurn].seekCard(convertedUserInput).getSuit() || 
							hands[playerTurn].seekCard(convertedUserInput).getValue() == "Eight") {
						passCounter = 0;
						faceUpCard = hands[playerTurn].removeCard(convertedUserInput);
						winner = hands[playerTurn].isEmpty();
						checkWarning();
						nextTurn(totalPlayers);
						crazyEight = false;
						crazyEightSuit[0] = "";
					
					} else if (crazyEightSuit[0] != hands[playerTurn].seekCard(convertedUserInput).getSuit() && 
							   hands[playerTurn].seekCard(convertedUserInput).getValue() != "Eight") {
						System.out.println("Please play a card that matches the acting suit or an eight.");
					}
				} else if ((hands[playerTurn].seekCard(convertedUserInput).getValue()).equals("Eight")) {

					crazyEight = true;
					System.out.println("### CRAZY 8! ###");
					System.out.println("Which suit? (C, D, H, S)");
					String userInput = userInputScanner.next();
					char charUser = userInput.charAt(0);
					passCounter = 0;

					switch (charUser) {
					case 'C':
						crazyEightSuit[0] = "Clubs";
						break;
					case 'D':
						crazyEightSuit[0] = "Diamonds";
						break;
					case 'H':
						crazyEightSuit[0] = "Hearts";
						break;
					case 'S':
						crazyEightSuit[0] = "Spades";
						break;
					}
					faceUpCard = hands[playerTurn].removeCard(convertedUserInput);
					checkWarning();
					winner = hands[playerTurn].isEmpty();
					nextTurn(totalPlayers);

				} else if (faceUpCard.getSuit() != hands[playerTurn].seekCard(convertedUserInput).getSuit()
						&& faceUpCard.getValue() != hands[playerTurn].seekCard(convertedUserInput).getValue()) {
					System.out.println("Please match either the suit or value of your card with the suit or "
							+ "value of the top card.");

				} else if (faceUpCard.getSuit() == hands[playerTurn].seekCard(convertedUserInput).getSuit()
						|| faceUpCard.getValue() == hands[playerTurn].seekCard(convertedUserInput).getValue()) {

					passCounter = 0;
					faceUpCard = hands[playerTurn].removeCard(convertedUserInput);
					winner = hands[playerTurn].isEmpty();
					checkWarning();
					nextTurn(totalPlayers);

				}
			} else if (!userInputScanner.hasNextInt()) {
				String userInput = userInputScanner.next();

				if (userInput.equals("d")) {
					hands[playerTurn].drawCard(gameDeck);
					cardsDealt++;
					passCounter = 0;

				} else if (userInput.equals("p") && cardsDealt == gameDeck.deckLength()) {
					nextTurn(totalPlayers);
					passCounter++;
				} else if (userInput.equals("p") && cardsDealt != gameDeck.deckLength()) {
					System.out.println("You can still draw cards from the deck.");

				} else if (passCounter == totalPlayers && cardsDealt == gameDeck.deckLength()) {
					draw = true;

				} else {
					System.out.println("Please enter either 'd', 'p' or one of your playable cards.");
				}
			}
		}
		winPrint(totalPlayers);
	}

	/**
	 * numPlayers asks for user input of number of players
	 * @return an integer - number of players 
	 */
	public int numPlayers() {
		System.out.println("Please enter the number of players:");
		Scanner numOfPlayersScanner = new Scanner(System.in);
		int numOfPlayers = Integer.parseInt(numOfPlayersScanner.next());
		if (numOfPlayers > 14) {
			System.out.println("You can only have a maximum of 14 players.");
			numPlayers();
		} else if (numOfPlayers <= 1) {
			System.out.println("You need a minimum of 2 players.");
			System.out.println("\n");
			System.out.println(numOfPlayers);
			numPlayers();
		}

		return numOfPlayers;
	}

	/**
	 * playerNames allows user to input their names
	 * @param numPlayers takes the value numPlayers and asks for that many names
	 */
	public void playerNames(int numPlayers) {
		System.out.println("Please type your names: ");
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Player " + (i + 1) + ":");
			Scanner nameOfPlayersScanner = new Scanner(System.in);
			String nameOfPlayers = nameOfPlayersScanner.next();
			namesOfPlayersArray[i] = nameOfPlayers;
		}
	}

	/**
	 * gameRules prints out the rules
	 */
	public void gameRules() {
		System.out.println("Rules of the Game");
		System.out.println("------------------");
		System.out.println("The objective of the game is to get rid of all your cards.");
		System.out.println("Get rid of your cards by matching your value or your suit "
				+ "\n" + "with the current face up card's value suit.");
		System.out.println("Eight is a wildcard, you can play it regardless of the suit or value.");
		System.out.println("Once you play an eight, you must also declare an acting suit for it.");
		System.out.println("Whenever your play a card, it becomes to the new faceup card.");
		System.out.println("If you have no playabale cards, you must draw from the deck until you have a playable card.");
		System.out.println("You can draw cards even if you currently have playable cards.");
		System.out.println("You may only pass if you have no playable cards and the deck is empty.");
		System.out.println("We will warn you when a player has exactly one card remaining.");
		System.out.println("If both players have no playable cards and the deck is empty, it is a tie.");
	}

	/**
	 * handsCreation creates the hands of each player
	 * @param numPlayers takes the value of numPlayers and creates that many hands into an array
	 */
	public void handsCreation(int numPlayers) {
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new Hand(i, gameDeck);
		}
	}

	/**
	 * gameDisplay shows the players hand and provides a visual for the game
	 */
	public void gameDisplay() {
		System.out.println("\n");
		System.out.println(namesOfPlayersArray[playerTurn] + "'s hand");
		System.out.println("---------------");
		System.out.println(hands[playerTurn].toString());
		System.out.println("Top card is " + faceUpCard.toString());
		if (crazyEight) {
			System.out.println("(but is acting as " + crazyEightSuit[0] + ")");
		}
		System.out.println(namesOfPlayersArray[playerTurn] + "'s move?");
	}

	/**
	 * nextTurn switches turns
	 * @param totalPlayers takes the value totalPlayers and if playerTurn >= totalPlayers-1, we're at the last player so we go back to the first player
	 */
	public void nextTurn(int totalPlayers) {
		if (playerTurn >= (totalPlayers - 1)) {
			playerTurn -= (totalPlayers - 1);
		} else {
			playerTurn++;
		}
	}

	/**
	 * checkWarning checks if player only has one card remaining and announces it if they do
	 */
	public void checkWarning() {
		if (hands[playerTurn].seekCard(1) == null && hands[playerTurn].seekCard(0) != null) {
			System.out.println(namesOfPlayersArray[playerTurn] + " has only one card remaining!");
		}
	}

	/**
	 * winPrint prints out whoever wins
	 * @param totalPlayer takes the value totalPlayer and uses it only if player 1 wins
	 */
	public void winPrint(int totalPlayer) {
		if (playerTurn == 0) {
			System.out.println("Congradulations " + namesOfPlayersArray[playerTurn + totalPlayer - 1] + " you win!");
		} else {
			System.out.println("Congradulations " + namesOfPlayersArray[playerTurn - 1] + " you win!");
		}
	}
}