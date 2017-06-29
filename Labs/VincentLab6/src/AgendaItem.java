
public interface AgendaItem {
	
	public String toString();
	
	public int getMonth();
	
	public int getDay();
	
	public int getYear();
	
	public int compareTo(AgendaItem otherItem);
}
