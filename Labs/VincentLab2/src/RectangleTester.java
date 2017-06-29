/**
 * RectangleTester Class 
 * Testing object constructors and instance methods on the rectangle objects created
 * 
 * @author Vincent Chee
 * @version 15/01/15
 */

import CSLib.DrawingBox;
import java.awt.Rectangle;
import CSLib.OutputBox;

public class RectangleTester {

	public static void main(String[] args) {
		DrawingBox myBoard;
		
		myBoard = new DrawingBox();
		myBoard.setVisible(true);
		//myBoard.drawRect(320,230,120,180);
		
		Rectangle myRectangle; 
		
		myRectangle = new Rectangle(320,230,120,180);
		myBoard.drawRect(myRectangle);
		
		myRectangle.grow(20,20);
		myBoard.drawRect(myRectangle);
		
		myRectangle.translate(280,-50);
		myBoard.drawRect(myRectangle);
		
		myRectangle.setLocation(75,250);
		myRectangle.setSize(200,150);
		myBoard.drawRect(myRectangle);
		
		
		DrawingBox myOtherBoard;
		
		myOtherBoard = new DrawingBox();
		myOtherBoard.setVisible(true);
		
		Rectangle Rect1;
		Rect1 = new Rectangle(50,180,120,180);
		myOtherBoard.drawRect(Rect1);
		
		Rectangle Rect2;
		Rect2 = new Rectangle(100,240,150,200);
		myOtherBoard.drawRect(Rect2);

		
		OutputBox printBox;
		printBox = new OutputBox();
		
		Rect1.intersects(Rect2);
		if (Rect1.intersects(Rect2) == true) {
			printBox.println("they do intersect");
		} else {
			printBox.println("they do not intersect");
		}

		myOtherBoard.drawRect(Rect1.union(Rect2));

		if (Rect1.union(Rect2).contains(Rect1) && Rect1.union(Rect2).contains(Rect2)) {
			printBox.println("the two rectangles are bounded");
		} else {
			printBox.println("the two rectangles aren't bounded");
		}
	}
}