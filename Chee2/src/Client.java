/**
 * This is a client for the SolitaireSimulator.
 * It plays the game the number of times the user indicates it to.
 * It outputs the number of wins in a percentage. 
 * Received help from numerous helpdesk members.
 * 
 * @author Vincent Chee
 * @version 02/02/15
 */

public class Client {

	public static void main(String[] args) {
		double count = 0;
		for (int counter = 1; counter <= 10; counter++) {
			for (double i = 0; i <= 1000; i++) {
				SolitaireSimulator aSimulator = new SolitaireSimulator();
				aSimulator.playGame();
				if (aSimulator.checkWin() == true) {
					count++;	
				}
				if (i == 1000) {
					System.out.println(count + "/" + i*counter + " games won = " + (count / i*counter) + "%"); 
				}
			}
		}
	}
}