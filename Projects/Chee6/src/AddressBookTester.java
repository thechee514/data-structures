/**
 * AddressBookTester tests the address book, it adds 3 contacts, finds some and
 * removes some.
 * 
 * @author Vincent Chee
 * @version 20/02/15
 *
 */
public class AddressBookTester {

	public static void main(String[] args) {
		AddressBook aBook = new AddressBook();
		int numContacts = 0;
		while (numContacts < 3) {
			aBook.add();
			numContacts++;
		}
		// Order of this input does not impact whether or not it finds contact
		// User should input one business with name: Google, the rest of the
		// information isn't important, you can choose to add or just skip the
		// input.
		System.out.println("Finding Contacts");
		aBook.find("Google");
		// User should input another person with firstName Vincent and lastName
		// Chee, the rest of the information isn't important, you can choose to
		// add or
		// just skip the input.
		System.out.println("\n");
		aBook.find("Chee, Vincent");
		// User should input another person or business with lastName/name
		// Bryant, and no first Name the rest of the information isn't
		// important, you can
		// choose to add or just skip the input.
		System.out.println("\n");

		aBook.find("Bryant");

		// Finds these contacts and removes them
		System.out.println("\n");
		aBook.remove("Bryant");

		System.out.println("\n");
		aBook.remove("Chee, Vincent");

		System.out.println("\n");
		aBook.remove("Google");

		// Trying to find these contacts again should return null
		System.out.println("\n");
		aBook.find("Bryant");

		System.out.println("\n");
		aBook.find("Google");

		System.out.println("\n");
		aBook.find("Chee, Vincent");
	}
}