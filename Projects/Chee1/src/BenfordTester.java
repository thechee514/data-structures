/** 
 * The class BenfordTester below has two methods, one for counting
 * and one for the actual graphing. The information is obtained from  
 *
 * NOTE: You also have to adapt the comments below to be appropriate
 * for your final program.
 * 
 * @author Vincent Chee
 * @version 15/01/15
 */

public class BenfordTester {

    // Array used for storing how often each digit  
    // occurs in the leading position.
    private int[] digitsArray = new int[10];

    /** Counts the number of times the number n is the first digit
     *  in file filename for all n=0-9
     *  The count is added to the array digitsArray.
     *  
     *  @param filename absolute or relative path to the file to be tokenized.
     */ 
    
    public void count(String filename) {
    	Tokenizer tokenObject = new Tokenizer(filename);
    	String token = tokenObject.nextToken();
    	
    	while (token != null) {
        	String leadingDigit = token.substring(0,1);
        	int convertedLeadDigit = Integer.parseInt(leadingDigit);
        	
        	if (convertedLeadDigit == 1) {
        		digitsArray[0] ++;
        	} else if (convertedLeadDigit == 2) {
        		digitsArray[1] ++;
        	} else if (convertedLeadDigit == 3) {
        		digitsArray[2] ++;
        	} else if (convertedLeadDigit == 4) {
        		digitsArray[3] ++;
        	} else if (convertedLeadDigit == 5) {
        		digitsArray[4] ++;
        	} else if (convertedLeadDigit == 6) {
        		digitsArray[5] ++;
        	} else if (convertedLeadDigit == 7) {
        		digitsArray[6] ++;
        	} else if (convertedLeadDigit == 8) {
        		digitsArray[7] ++;
        	} else if (convertedLeadDigit == 9) {
        		digitsArray[8] ++;
        	} else {
        		digitsArray[9] ++;
        	}
        	token = tokenObject.nextToken();
    	}
    }	
	

    /** Uses the nine total counts (one for each digit 1-9) to form
     *  a histogram (a bar graph) of leading digit frequency.
     *  One asterisk is printed in the bar graph for every unitsPerAsterisk in the count. 
     *  
     *  @param unitsPerAsterisk determines number of asterisks printed 
     */
    public void graph(int unitsPerAsterisk) {
    	String asterisk = "*";
    	System.out.println("frequency of the lead digit");
    	System.out.println("---------------------------");
    	for (int i = 0; i < digitsArray.length-1;i++) {
    		String empty = "";
    		double asteriskTotal = digitsArray[i]/unitsPerAsterisk;
    		for (int counter = 0; counter < Math.round(asteriskTotal); counter++) {
    			empty +=asterisk;
    		}
    		System.out.println((i+1) + ": " + empty); 
    	}
    }
}

