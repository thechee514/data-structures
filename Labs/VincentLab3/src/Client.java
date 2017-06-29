/**
 * Client class which was used to test the original block class, but is currently set to test the second block class.
 * 
 * @author Vincent Chee
 * @version 22/01/15
 */
import second.Block;
import CSLib.DrawingBox;

public class Client {

	public static void main(String[] args) {
		DrawingBox myBoard = new DrawingBox();
		myBoard.setVisible(true);

		Block defaultBlock = new Block();
		defaultBlock.Display(myBoard);
		
		Block nonDefaultBlock = new Block(100,250);
		nonDefaultBlock.Display(myBoard);
		
		defaultBlock.setPosition(300, 175);
		defaultBlock.Display(myBoard);
		
		nonDefaultBlock.setPosition(200, 400);
		nonDefaultBlock.Display(myBoard);

		defaultBlock.setPosition(700, 200);
		defaultBlock.setDimension(150,90,45);
		defaultBlock.Display(myBoard);
		
		DrawingBox arrayBoard = new DrawingBox();
		Block[] arrayOfBlocks = new Block[5];
		int arrayYPos = 100;
		Block arrayBlocks = new Block(100,arrayYPos);

		for (int i=0; i < arrayOfBlocks.length; i++) {
			arrayOfBlocks[i] = arrayBlocks;
			arrayBlocks = new Block(100,arrayYPos);
			arrayBlocks.Display(arrayBoard);
			arrayYPos+=100;
		}
	}
}
