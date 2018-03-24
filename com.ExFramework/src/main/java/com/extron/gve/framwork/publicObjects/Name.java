package com.extron.gve.framwork.publicObjects;

package com.extron.gve.framework.publicobjects;

public class Name {
	private final String firstName;
	private final String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Compares if two names are equal by comparing the first and last names to each
	 * other through String.equals. Verifies neither are null.
	 * 
	 * @return True if names are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		// Objects reference each other
		if (this == obj) {
			return true;
		}

		// Object is null or objects are not of same class
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Name name = (Name) obj;

		// If firstName's are not equal, or either is null, return false.
		if (firstName != null ? !firstName.equals(name.firstName) : name.firstName != null) {
			return false;
		}

		// If lastName's are not equal, or either is null, return false.
		if (lastName != null ? !lastName.equals(name.lastName) : name.lastName != null) {
			return false;
		}

		// Names are equal
		return true;
	}

	/**
	 * Gets the first name
	 * 
	 * @return a String containing the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the last name
	 * 
	 * @return a String containing the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Converts name to easy readable format of firstName lastName with a space
	 * between
	 * 
	 * @return a String containing the firstName and lastName with a space between
	 */
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}

