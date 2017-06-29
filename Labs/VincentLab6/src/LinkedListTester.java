/**
 * Tests new (and old?) LinkedList methods.
 * 
 * @author Vincent Chee, Aaron Cass, and Chris Fernandes 
 * @version 13/02/15
 */
public class LinkedListTester
{
    public static final boolean VERBOSE = true;
    
    public static void main(String[] args)
    {
    	System.out.println("Starting Tests");

    	test231();
    	test123();
    	testSame();
    	testDifferentDay();
    	testDifferentYear();
    	System.out.println("Tests Complete");
    }
    
    /**
     * adds events in the order 1, 2, 3 that should end up in the order 2, 3, 1
     */
    private static void test231()
    {
    	testsSection("123 -> 231");
	
        LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);
        Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);
        Event E3 = new Event("book club", 2013, 2, 25, 800, 830);

        list.insertSorted(E1);
        list.insertSorted(E2);
        list.insertSorted(E3);

    	assertEquals("3-node list contents",
                     "(boy scouts  2/23/2013  900-1000,\nbook club  2/25/2013  800-830,\nchess club  2/25/2013  1900-1930)",
                     list.toString());
    	assertEquals("3-node list length", 3, list.getLength());
    }
    
    /**
     * adds events in the order 3, 2, 1 that should end up in the order 3, 2, 1
     */
    private static void test123() {
    	testsSection("321 -> 321");
    	
        LinkedList list = new LinkedList();
        Event E3 = new Event("book club", 2013, 2, 25, 800, 830);
        Event E2 = new Event("boy scouts", 2013, 2, 25, 900, 1000);
        Event E1 = new Event("chess club", 2013, 2, 25, 1900, 1930);

        list.insertSorted(E3);
        list.insertSorted(E2);
        list.insertSorted(E1);
   

    	assertEquals("3-node list contents",
                     "(book club  2/25/2013  800-830,\nboy scouts 2/25/2013  900-1000,\nchess club  2/25/2013  1900-1930)",
                     list.toString());
    	assertEquals("3-node list length", 3, list.getLength());
    }
    private static void testSame() {
    	testsSection("123 -> 123");
    	
        LinkedList list = new LinkedList();
        Event E3 = new Event("book club", 2013, 2, 25, 900, 1000);
        Event E2 = new Event("boy scouts", 2013, 2, 25, 900, 1000);
        Event E1 = new Event("chess club", 2013, 2, 25, 900, 1000);

        list.insertSorted(E1);
        list.insertSorted(E2);
        list.insertSorted(E3);

    	assertEquals("3-node list contents",
                     "(book club  2/25/2013  800-830,\nboy scouts 2/25/2013  900-1000,\nchess club  2/25/2013  1900-1930)",
                     list.toString());
    	assertEquals("3-node list length", 3, list.getLength());
    }
    
    private static void testDifferentDay() {
    	testsSection("321 -> 321");
    	
        LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2013, 2, 28, 900, 1000);
        Event E2 = new Event("boy scouts", 2013, 2, 23, 900, 1000);
        Event E3 = new Event("book club", 2013, 2, 21, 900, 1000);
        
        list.insertSorted(E3);
        list.insertSorted(E2);
        list.insertSorted(E1);

    	assertEquals("3-node list contents",
                     "(book club  2/21/2013  900-1000,\nboy scouts 2/23/2013  900-1000,\nchess club  2/28/2013  900-1000)",
                     list.toString());
    	assertEquals("3-node list length", 3, list.getLength());
    }
    private static void testDifferentYear() {
    	testsSection("321 -> 321");
    	
        LinkedList list = new LinkedList();
        
        Event E1 = new Event("chess club", 2014, 2, 28, 900, 1000);
        Event E2 = new Event("boy scouts", 2015, 2, 23, 900, 1000);
        Event E3 = new Event("book club", 2013, 2, 21, 900, 1000);
        
        list.insertSorted(E3);
        list.insertSorted(E2);
        list.insertSorted(E1);

    	assertEquals("3-node list contents",
                     "(book club  2/21/2013  900-1000,\nchess club  2/28/2014  900-1000),\nboy scouts 2/23/2015  900-1000",
                     list.toString());
    	assertEquals("3-node list length", 3, list.getLength());
    }
    /***********  TESTING TOOLS ****************/
    
    /**
     * Each of the assertEquals methods tests whether the actual
     * result equals the expected result.  If it does, then the test
     * passes, otherwise it fails.  If VERBOSE is true, then complete
     * information is printed, whether the tests passes or fails.  If
     * VERBOSE is false, only failures are printed.
     *
     * The only difference between these methods is the types of the
     * parameters.  All take a String message and two values of the
     * same type (either boolean, int, Object, or String) to compare:
     *
     * @param message a message or description of the test
     * @param expected the correct, or expected, value
     * @param actual the actual value
     */
    private static void assertEquals(String message, 
				    boolean expected, boolean actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }

    private static void assertEquals(String message, 
				    int expected, int actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }
    
    private static void assertEquals(String message, 
    		Object expected, Object actual)
    {
    	try {
            printTestCaseInfo(message, expected.toString(), actual.toString());
    	}
    	catch (NullPointerException e)
    	{
            printTestCaseInfo(message, "", "");
    	}

    	if (expected == null) {
            if (actual == null) {
                pass();
            } else {
                fail(message);
            }
    	} else if (expected.equals(actual)) {
            pass();
    	} else {
            fail(message);
    	}
    }
    
    private static void assertEquals(String message, 
                                     String expected, String actual)
    {
    	printTestCaseInfo(message, expected, actual);
	
    	if (expected == null) {
            if (actual == null) {
                pass();
            } else {
                fail(message);
            }
    	} else if (expected.equals(actual)) {
            pass();
    	} else {
            fail(message);
        }
    }
    
    private static void printTestCaseInfo(String message, 
					  String expected, String actual)
    {
    	if (VERBOSE) {
            System.out.println(message + ":");
            System.out.println("expected: " + expected);
            System.out.println("actual:   " + actual);
        }
    }
    
    private static void pass()
    {
    	if (VERBOSE) {
            System.out.println("PASS");
            System.out.println();
    	}
    }
    
    private static void fail(String description)
    {
    	if (!VERBOSE) {
            System.out.print(description + "  ");
    	}
    	System.out.println("FAIL");
    	System.out.println();
    }
    
    private static void testsSection(String sectionTitle)
    {
	if (VERBOSE) {
	    int dashCount = sectionTitle.length();
	    System.out.println(sectionTitle);
	    for (int i = 0; i < dashCount; i++) {
		System.out.print("-");
	    }
	    System.out.println();
	    System.out.println();
        }
    }
}
