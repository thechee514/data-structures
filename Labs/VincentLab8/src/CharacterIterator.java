/**
 * Iterates through a string one character at a time.
 * @author Aaron Cass
 */
public class CharacterIterator
{
    private String inputString;
    private int currentIndex;

    /**
     * Constructs the iterator, ready to read the first character.
     */
    public CharacterIterator(String input)
    {
        inputString = input;
        currentIndex = 0;
    }

    /**
     * @return true iff there are characters that have not yet been read with
     * getNext().
     */
    public boolean hasNext()
    {
        return (currentIndex < inputString.length());
    }

    /**
     * Gets the next character.
     *
     * @return the next unread character, or null if all the characters have
     * been read.
     */
    public Character getNext()
    {
        if (hasNext()) {
            Character toReturn = new Character(inputString.charAt(currentIndex));
            currentIndex ++;
            return toReturn;
        } else {
            return null;
        }
    }
}
