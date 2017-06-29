/**
 * AddressBook Class holds the information of the contacts in an address book
 * 
 * @author Vincent Chee
 * @version 20/02/15
 */
import java.util.Scanner;

public class AddressBook {
	private GenericLinkedList<Contact> addressBookContacts = new GenericLinkedList<Contact>();
	private Scanner userInputScanner;
	private Person aPerson;
	private Business aBusiness;

	/**
	 * Add method adds a new contact, prompts user asking whether they want to
	 * add business or person then asks them to input appropriate details for
	 * that contact. User must enter a name for business and a last name for
	 * person.
	 */
	public void add() {
		System.out
				.println("Please select whether you want to add a person or a business to your address book, enter p for person or b for business.");
		userInputScanner = new Scanner(System.in);
		String user_input = userInputScanner.next();
		if (user_input.equals("p")) {
			aPerson = new Person();
			addFirstName();
			addLastName();
			addAddress();
			addEmail();
			addPhoneNumber();
			addBirthday();
			addressBookContacts.insertSorted(aPerson);

		} else if (user_input.equals("b")) {
			aBusiness = new Business();
			addBusinessName();
			addBusinessAddress();
			addBusinessEmail();
			addBusinessPhone();
			addBusinessHours();
			addressBookContacts.insertSorted(aBusiness);

		} else {
			add();
		}
	}

	/**
	 * Several helper methods which uses scanner to ask for user input and user
	 * input is used to set contacts information.
	 */
	private void addFirstName() {
		System.out.println("Please enter the first name of your contact.");
		userInputScanner = new Scanner(System.in);
		String firstName = userInputScanner.nextLine();
		if (firstName.equals("")) {
			aPerson.setFirstName("");
		} else {
			aPerson.setFirstName(firstName);
		}
	}

	private void addLastName() {
		System.out
				.println("Please enter the last name of your contact (must).");
		userInputScanner = new Scanner(System.in);
		String lastName = "";
		lastName = userInputScanner.next();
		if (lastName.equals("")) {
			addLastName();
		}
		aPerson.setLastName(lastName);
	}

	private void addAddress() {
		System.out.println("Please enter an address.");
		userInputScanner = new Scanner(System.in);
		String address = (userInputScanner.nextLine());
		if (address.equals("")) {
			aPerson.setAddress("n/a");
		} else {
			aPerson.setAddress(address);
		}
	}

	private void addEmail() {
		System.out.println("Please enter your contacts email.");
		userInputScanner = new Scanner(System.in);
		String email = userInputScanner.nextLine();
		if (email.equals("")) {
			aPerson.setEmail("n/a");
		} else {
			aPerson.setEmail(email);
		}
	}

	private void addPhoneNumber() {
		System.out.println("Please enter your contacts phone number.");
		userInputScanner = new Scanner(System.in);
		String phoneNumber = userInputScanner.nextLine();
		if (phoneNumber.equals("")) {
			aPerson.setPhone("n/a");
		} else {
			aPerson.setPhone(phoneNumber);
		}
	}

	private void addBirthday() {
		System.out.println("Please enter your contacts birthday (DD/MM/YY)");
		userInputScanner = new Scanner(System.in);
		String birthday = userInputScanner.nextLine();
		if (birthday.equals("")) {
			aPerson.setBirthday("n/a");
		} else {
			aPerson.setBirthday(birthday);
		}
	}

	private void addBusinessName() {
		System.out.println("Please enter the name of the business (must).");
		userInputScanner = new Scanner(System.in);
		String businessName = userInputScanner.next();
		if (businessName.equals("")) {
			aBusiness.setName("");
		} else {
			aBusiness.setName(businessName);
		}
	}

	private void addBusinessAddress() {
		System.out.println("Please enter the address of the business.");
		userInputScanner = new Scanner(System.in);
		String businessAddress = userInputScanner.nextLine();
		if (businessAddress.equals("")) {
			aBusiness.setAddress("n/a");
		} else {
			aBusiness.setAddress(businessAddress);
		}
	}

	private void addBusinessEmail() {
		System.out.println("Please enter the email of the business.");
		userInputScanner = new Scanner(System.in);
		String businessEmail = userInputScanner.nextLine();
		if (businessEmail.equals("")) {
			aBusiness.setEmail("n/a");
		} else {
			aBusiness.setEmail(businessEmail);
		}
	}

	private void addBusinessPhone() {
		System.out.println("Please enter the phone number of the business.");
		userInputScanner = new Scanner(System.in);
		String businessPhone = userInputScanner.nextLine();
		if (businessPhone.equals("")) {
			aBusiness.setPhone("n/a");
		} else {
			aBusiness.setPhone(businessPhone);
		}
	}

	private void addBusinessHours() {
		System.out.println("Please enter the hours of the business.");
		userInputScanner = new Scanner(System.in);
		String businessHours = userInputScanner.nextLine();
		if (businessHours.equals("")) {
			aBusiness.setHours("n/a");
		} else {
			aBusiness.setHours(businessHours);
		}
	}

	/**
	 * find method finds the contact with the parameter name and prints out the
	 * contact information for a person or business in a nice way.
	 * 
	 * @param name
	 *            the name to be found
	 */
	public void find(String name) {
		Business toFind = new Business();
		toFind.setName(name);
		System.out.println(addressBookContacts.find(toFind));
	}

	/**
	 * find method finds the contact with the parameter name and removes it and
	 * prints a message informing the user which contact was deleted.
	 * 
	 * @param name
	 */
	public void remove(String name) {
		Business toFind = new Business();
		toFind.setName(name);
		System.out.println("You've removed this contact:");
		System.out.println(addressBookContacts.remove(toFind));
	}
}