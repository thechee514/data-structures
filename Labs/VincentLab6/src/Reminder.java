/** I'd fill this in if I were you.
 * 
 * @author Chris Fernandes and <your name here>
 * @version 2/20/12
 */
public class Reminder
{
    private String msg;
    private String date;

    private static final int NUM_PARTS = 3;
    private static final int MONTH_PART = 0;
    private static final int DAY_PART = 1;
    private static final int YEAR_PART = 2;
    
    /**
     * Creates a reminder
     *
     * @param msg The text of the reminder
     * @param date The date of the reminder (in mm/dd/yyyy format)
     */
    public Reminder(String msg, String date)
    {
        this.msg = msg;
        this.date = date;
    }
    
    /**
     * @return the Reminder as a String
     */
    public String toString()
    {
        return msg + " "  + date;
    }

    /**
     * @return the month of the reminder
     */
    public int getMonth()
    {
        return getDateParts()[MONTH_PART];    
    }

    /**
     * @return the day of the reminder
     */
    public int getDay()
    {
        return getDateParts()[DAY_PART];    
    }

    /**
     * @return the year of the reminder
     */
    public int getYear()
    {
        return getDateParts()[YEAR_PART];
    }

    /**
     * Parses the date string to determine the 3 integer values for
     * month, day, and year.
     *
     * @return an array of 3 ints in the order {month, day, year}
     */
    private int[] getDateParts()
    {
        int[] intParts = new int[NUM_PARTS];
        String[] stringParts = date.split("/");

        for (int i = 0; i < stringParts.length; i++) {
            intParts[i] = Integer.valueOf(stringParts[i]).intValue();
        }

        return intParts;
    }
}
