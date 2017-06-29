/**
 * Original Block Class with original implementation (five instance variables), two constructors, one default, one non-default, 
 * five getter methods, which get width, height, depth, x position and y position of rectangle. Two setter methods, one that sets the
 * x position and y position and the other that sets the dimensions of the rectangle width, height and depth. It also contains a 
 * display method which draws the block based on the current instance variables.
 * 
 * @author Vincent Chee
 * @version 22/01/15
 */

package original;
import CSLib.DrawingBox;
import java.awt.Rectangle;

public class Block {
	private int width;
	private int height;
	private int depth;
	private int xPos;
	private int yPos;
	
	private static final int INITIAL_WIDTH = 50;
	private static final int INITIAL_HEIGHT = 50;
	private static final int INITIAL_DEPTH = 10;
	private static final int INITIAL_XPOS = 100;
	private static final int INITIAL_YPOS = 100;

	public Block() {
		width = INITIAL_WIDTH;
		height = INITIAL_HEIGHT;
		depth = INITIAL_DEPTH;
		xPos = INITIAL_XPOS;
		yPos = INITIAL_YPOS;
	}
		
	/**
	 * Non-default constructor
	 * @param newXPos constructs rectangle at defined x position
	 * @param newYPos constructs rectangle at defined y position
	 */
	public Block(int newXPos, int newYPos) {
		xPos = newXPos;
		yPos = newYPos;
		width = INITIAL_WIDTH;
		height = INITIAL_HEIGHT;
		depth = INITIAL_DEPTH;
	}
	
	/**
	 * Getter methods
	 */
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
		
	/**
	 * Setter methods
	 * @param setXPos sets x position of rectangle
	 * @param setYPos sets y position of rectangle
	 */
	public void setPosition(int setXPos, int setYPos) {
		xPos = setXPos;
		yPos = setYPos;
	}
		
	/**
	 * @param setWidth sets width of rectangle
	 * @param setHeight sets height of rectangle
	 * @param setDepth sets depth of rectangle
	 */
	public void setDimension(int setWidth, int setHeight, int setDepth) {
		width = setWidth;
		height = setHeight;
		depth = setDepth;
	}
		
	/**
	 * @param box takes an already defined box to draw rectangles
	 */
	public void Display(DrawingBox box) {
		Rectangle myRectangle = new Rectangle(xPos, yPos, width, height);
		for (int i = 0; i < depth; i++) {
			box.drawRect(myRectangle);
			myRectangle.translate(-2,-2);
		}
	}
}
