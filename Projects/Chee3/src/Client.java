/**
 * This is a client for the CrazyEights game.
 * It runs through the game once until someone wins or draws.
 * @author Vincent Chee
 * @version 29/01/15
 */
public class Client {
	public static void main(String[] args) {
		CrazyEights crazy = new CrazyEights();
		crazy.playGame();
	}
}