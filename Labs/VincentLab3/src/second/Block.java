/**
 * Second Block class with different implementation (rectangle and depth instance variables only), but same behavior as original
 * Block class.
 * 
 * @author Vincent Chee
 * @version 22/01/15
 */

package second;
import java.awt.Rectangle;
import CSLib.DrawingBox;

public class Block {
	private Rectangle myRectangle;
	private int depth;
	
	private static final int INITIAL_WIDTH = 50;
	private static final int INITIAL_HEIGHT = 50;
	private static final int INITIAL_DEPTH = 10;
	private static final int INITIAL_XPOS = 100;
	private static final int INITIAL_YPOS = 100;
	

	public Block() {
		myRectangle = new Rectangle(INITIAL_XPOS, INITIAL_YPOS, INITIAL_WIDTH, INITIAL_HEIGHT);
		depth = INITIAL_DEPTH;
	}
		
	/**
	 * Non-default constructor
	 * @param newXPos constructs rectangle at defined x position
	 * @param newYPos constructs rectangle at defined y position
	 */
	public Block(int newXPos, int newYPos) {
		myRectangle = new Rectangle(newXPos, newYPos, INITIAL_WIDTH, INITIAL_HEIGHT);
		depth = INITIAL_DEPTH;
	}
	
	/**
	 * Getter methods
	 */
	public double getWidth() {
		return myRectangle.getWidth();
	}
	
	public double getHeight() {
		return myRectangle.getHeight();
	}
	
	public int getDepth() {
		return depth;
	}
	
	public double getXPos() {
		return myRectangle.getX();
	}
	
	public double getYPos() {
		return myRectangle.getY();
	}
		
	/**
	 * Setter methods
	 * @param setXPos sets x position of rectangle 
	 * @param setYPos sets y position of rectangle 
	 */
	public void setPosition(int setXPos, int setYPos) {
		myRectangle.setLocation(setXPos, setYPos);
	}
		
	/**
	 * @param setWidth sets width of rectangle
	 * @param setHeight sets height of rectangle
	 * @param setDepth sets depth of rectangle
	 */
	public void setDimension(int setWidth, int setHeight, int setDepth) {
		myRectangle.setSize(setWidth, setHeight);
		depth = setDepth;
	}
		
	/**
	 * @param box takes an already created box to draw rectangles
	 */
	public void Display(DrawingBox box) {
		for (int i = 0; i < depth; i++) {
			box.drawRect(myRectangle);
			myRectangle.translate(-2,-2);
		}
	}
}
