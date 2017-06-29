/**
 * Index Class contains an index instance variable and dictionary instance
 * variable. Has method that allows user to create index.
 * 
 * @author Vincent Chee
 * @version 19/03/15
 */
public class Index {

	BinarySearchTree<IndexEntry> index;
	BinarySearchTree<String> dictionary;
	private final int MIN_NUM_LETTERS = 3;

	/**
	 * Index constructor
	 */
	public Index() {
		index = new BinarySearchTree<IndexEntry>();
		dictionary = new BinarySearchTree<String>();
	}

	/**
	 * Index creation method, does the actual creation of the index, adding and
	 * removing things between index and dictionary binary search trees Uses
	 * GenericLinkedList to store page numbers
	 * 
	 * @param filename
	 */
	public void createIndex(String filename) {
		FileReader scanner = new FileReader(filename);
		IndexEntry anEntry;
		String currentWord = scanner.nextToken();
		int pageNumber = 1;

		while (currentWord != null) {
			if (currentWord.equals("#")) {
				pageNumber++;
			} else {
				if (currentWord.length() >= MIN_NUM_LETTERS
						&& dictionary.find(currentWord) == null) {
					anEntry = new IndexEntry(currentWord);
					IndexEntry currentEntry = index.find(anEntry);
					if (currentEntry != null) {
						if (!currentEntry.isFull()) {
							currentEntry.addPage(pageNumber);
						} else {
							System.out.println("Removed: "
									+ currentEntry.toString());
							index.remove(currentEntry);
							dictionary.add(currentWord);
						}
					} else {
						index.add(new IndexEntry(currentWord, pageNumber));
					}
				}
			}
			currentWord = scanner.nextToken();
		}
		System.out.println("\n");
		System.out.println("Index: \n" + index.toString());
		System.out.println("\n");
		System.out.println("Dict: \n" + dictionary.toString());
	}
}
