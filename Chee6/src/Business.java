/**
 * Business class which contains information about one business
 * 
 * @author Vincent Chee
 * @version 20/02/15
 *
 */
public class Business implements Contact {

	private String name;
	private String address;
	private String email;
	private String phoneNumber;
	private String businessHours;

	/**
	 * Setter method for name
	 * 
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Getter method for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
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
	 * Setter method for business hours
	 * 
	 * @param newHours
	 */
	public void setHours(String newHours) {
		businessHours = newHours;
	}

	/**
	 * Getter method for business hours
	 * 
	 * @return businessHours
	 */
	public String getHours() {
		return businessHours;
	}

	/**
	 * toString method provides string representation of business
	 */
	public String toString() {
		return "Name: " + getName() + "\n" + "Address: " + getAddress() + "\n"
				+ "Email: " + getEmail() + "\n" + "Phone Number: " + getPhone()
				+ "\n" + "Business Hours: " + getHours();
	}

	/**
	 * compareTo method which returns int depending on whether name is before,
	 * after or same
	 */
	public int compareTo(Contact compareContact) {
		return this.getName().compareToIgnoreCase(compareContact.getName());
	}
}
