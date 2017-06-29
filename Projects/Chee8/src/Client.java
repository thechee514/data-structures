/**
 * Client creates the index using the input
 * @author Vincent Chee
 * @version 19/03/15
 *
 */
public class Client {

	public static void main(String[] args) {
		Index anIndexer = new Index();
		anIndexer.createIndex("usconst.txt");
	}

}
