/** 
 * This is a client for the BenfordTester, a program that uses the BenfordTester.
 * It creates and sends messages to Benford tester through user typed parameters and with these
 * parameters the program prints out a bar graph based on the user input. 
 * 
 * @author Vincent Chee
 * @version 15/01/15
 * 
 */

public class Client {

    public static void main(String[] args) {

	// creating an object of Type BenfordTester
	BenfordTester benford = new BenfordTester();

	benford.count("population.txt");
	benford.graph(2);
	}
}		
	