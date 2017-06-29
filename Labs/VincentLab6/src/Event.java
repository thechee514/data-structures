/**
 * An Event is a gathering that happens on a particular date.  
 * It has a defined name, starting time, and ending time.
 * 
 * @authors Chris Fernandes
 * @version 5/14/2013
 */
public class Event implements AgendaItem
{
    private String name;    // name/description of event
    private int year;       // 4-digit year in which event occurs (e.g. 2011)
    private int month;      // number of month 1=Jan, 12=Dec
    private int day;        // day of the month
    private int startTime;  // time the event starts in military time 
                            // (e.g. 1:15PM is 1315 and 9:00AM is 900)
    private int endTime;    // time the event ends in military time 

    /** non-default constructor
     * 
     * @param eventName name of event
     * @param year  4-digits
     * @param month integer: 1=Jan, 2=Feb, etc.
     * @param day day of the month
     * @param start start time in military time
     * @param end end time in military time
     */
    public Event(String eventName, int year, int month, int day,
                 int start, int end)
    {
        this.name=eventName;
        this.year=year;
        this.month=month;
        this.day=day;
        this.startTime=start;
        this.endTime=end;
    }
    
    /**
     * Each of the following getters returns the eponymous part of the event
     * @return name, year, month, day, startTime, or endTime
     */
    public String getName() {return name;}
    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDay() {return day;}
    public int getStart() {return startTime;}
    public int getEnd() {return endTime;}
    
    /** 
     *  @return returns the event as a printable String
     */
    public String toString()
    {
        return getName() + "  "
                + getMonth() + "/" + getDay() + "/" + getYear() + "  "
                + getStart() + "-" + getEnd();
    }

    /** 
     * Compares this event with otherEvent to see which one is earlier.
     * 
     * @param otherEvent the event to compare with
     * @return 1 if this event is later than otherEvent,
     * -1 if this event is earlier than otherEvent, 
     * or 0 if the two events occur on exactly the same
     * day with the exact same START time.
     */
    public int compareTo(Event otherEvent)
    {
    	if (getYear() > otherEvent.getYear()) {
            return 1;
    	} else if (getYear() < otherEvent.getYear()) {
            return -1;
    	} else if (getMonth() > otherEvent.getMonth()) {
            return 1;
    	} else if (getMonth() < otherEvent.getMonth()) {
            return -1;
    	} else if (getDay() > otherEvent.getDay()) {
            return 1;
    	} else if (getDay() < otherEvent.getDay()) {
            return -1;
    	} else if (getStart() > otherEvent.getStart()) {
            return 1;
    	} else if (getStart() < otherEvent.getStart()) {
            return -1;
    	} else {
            return 0;
    	}
    }
}
