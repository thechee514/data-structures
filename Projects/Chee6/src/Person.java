/**
 * Person class which contains information about one person
 * 
 * @author Vincent Chee
 * @version 20/02/15
 *
 */
public class Person implements Contact {

	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phoneNumber;
	private String birthday;

	/**
	 * Setter Method for first name
	 * 
	 * @param newFirst
	 */
	public void setFirstName(String newFirst) {
		firstName = newFirst;
	}

	/**
	 * Setter method for last name
	 * 
	 * @param newLast
	 */
	public void setLastName(String newLast) {
		lastName = newLast;
	}

	/**
	 * Getter method for name
	 * 
	 * @return name
	 */
	public String getName() {
		if (firstName.equals("")) {
			return lastName;
		} else {
			return lastName + ", " + firstName;
		}
	}

	/**
	 * Setter method for address
	 * 
	 * @param newAddress
	 */
	public void setAddress(String newAddress) {
		address = newAddress;
	}

	/**
	 * Getter method for address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for email
	 * 
	 * @param newEmail
	 */
	public void setEmail(String newEmail) {
		email = newEmail;
	}

	/**
	 * Getter method for email
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for phone number
	 * 
	 * @param newNumber
	 */
	public void setPhone(String newNumber) {
		phoneNumber = newNumber;
	}

	/**
	 * Getter method for phone number
	 * 
	 * @return phoneNumber
	 */
	public String getPhone() {
		return phoneNumber;
	}

	/**
	 * Setter method for birthday
	 * 
	 * @param newBirthday
	 */
	public void setBirthday(String newBirthday) {
		birthday = newBirthday;
	}

	/**
	 * Getter method for birthday
	 * 
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * toString provides a nice representation of contact information in string
	 * format
	 */
	public String toString() {
		return "Name: " + getName() + "\n" + "Address: " + getAddress() + "\n"
				+ "Email: " + getEmail() + "\n" + "Phone Number: " + getPhone()
				+ "\n" + "Birthday: " + getBirthday();
	}

	/**
	 * compareTo method which returns int depending on whether name is before,
	 * after or same
	 */
	public int compareTo(Contact compareContact) {
		return this.getName().compareToIgnoreCase(compareContact.getName());
	}
}
