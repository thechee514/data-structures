/**
 * Driver for Lab 4.  Tests out our Deck class.
 */
public class Client 
{
    public static void main(String[] args) 
    {
	sandbox();

	
//	inOrder();
//	shuffledOrder();
//	dealThenShuffle();
	gatherTest();
    }

    /**
     * Just a play area for you to try out the Card class.
     */
    public static void sandbox() 
    {
//    	Deck aDeck = new Deck(); 
//    	aDeck.shuffle();
//    	System.out.println(aDeck.deal());
    }
    
    /**
     * DECK TEST: Constructs a deck and prints it (should be in order).
     * This tests the constructor.
     */
    public static void inOrder()
    {
	System.out.println("IN ORDER TEST");
	Deck deck1 = new Deck();
	deck1.printStats();
	dealAndPrint(deck1);
    }
	
    /**
     * DECK TEST: Constructs a deck, shuffles, and prints it.
     * This tests the <code>shuffle</code> method to see if it shuffles all cards.
     */
    public static void shuffledOrder()
    {
	System.out.println("SHUFFLED ORDER TEST");
	Deck deck2 = new Deck();
	deck2.printStats();
	deck2.shuffle();
	dealAndPrint(deck2);
    }
	
    /**
     * DECK TEST: Deals first 3 (ordered) cards, shuffles, then prints the rest.
     * This tests the <code>shuffle</code> method to see if it shuffles remaining 
     * cards.
     */
    public static void dealThenShuffle()
    {
	System.out.println("DEAL IN SORTED ORDER, THEN SHUFFLE THE REST");
	Deck deck3 = new Deck();
	System.out.println(deck3.deal());
	System.out.println(deck3.deal());
	System.out.println(deck3.deal());
	deck3.shuffle();
	deck3.printStats();
	dealAndPrint(deck3);
    }
		
    /**
     * DECK TEST: Deals an ordered deck, prints number left in deck (should be zero), 
     * gathers cards, prints number left in deck (should be all), shuffles, and deals
     * all. This tests the <code>gather</code> and <code>size</code> methods.
     */
    public static void gatherTest(){
	System.out.println("GATHER METHOD TEST");
	Deck deck4 = new Deck();

	dealAndPrint(deck4);

	System.out.println("Before gathering, deck has " 
			   + deck4.size() + " cards.");
	deck4.printStats();
	deck4.gather();
	System.out.println("After gathering, deck now has " 
			   + deck4.size() + " cards.");
	deck4.printStats();

	deck4.shuffle();
	dealAndPrint(deck4);
    }
		
    /**
     * Use this method to help you debug.  It will deal out all cards in the deck.
     * @param theDeck the deck to deal
     */
    public static void dealAndPrint(Deck theDeck){
	System.out.println("dealing all cards:");
	System.out.println("------------------");
	if (theDeck.isEmpty()){
	    System.out.println("### No cards in deck! ###");
	}
	while (!theDeck.isEmpty()) {
	    System.out.println(theDeck.deal());
	}
	System.out.println();
    }
}
