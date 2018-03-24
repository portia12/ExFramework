package com.extron.gve.framwork.publicObjects;

import com.extron.gve.properties.TestProperties;

public class TestUser {

	private final String USER_GROUP = "Global Admin";

	private NameGenerator nameGenerator;
	private PhoneNumberGenerator phoneNumberGenerator;
	private String language;
	private String userName;
	private Name name;
	private String firstName;
	private String lastName;
	private String email;
	private PhoneNumber phoneNumber;
	private String password;

	/**
	 * Generate a Test User with random information.
	 */
	public TestUser(TestProperties testProperties, NameGenerator nameGenerator,
			PhoneNumberGenerator phoneNumberGenerator) {
		this.language = testProperties.language;
		this.password = testProperties.password;
		this.nameGenerator = nameGenerator;
		this.phoneNumberGenerator = phoneNumberGenerator;
		this.name = generateName();
		this.firstName = getFirstName();
		this.lastName = getLastName();
		this.userName = generateUserName();
		this.email = generateEmail();
		this.phoneNumber = generatePhoneNumber();
	}

	/**
	 * Generate a Test User with specific information
	 * 
	 * @param userName
	 *            User's user name
	 * @param firstName
	 *            User's first name
	 * @param lastName
	 *            User's last name
	 * @param email
	 *            User's email address, should be form of name@domain.com
	 * @param phoneNumber
	 *            PhoneNumber object (includes sms, phone, and mobile)
	 */
	public TestUser(TestProperties testProperties, String userName, String firstName, String lastName, String email, PhoneNumber phoneNumber) {
		language = testProperties.language;
		this.password = testProperties.password;
		this.userName = userName;
		this.name = new Name(firstName, lastName);
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Generate a Test User with specific information
	 * 
	 * @param userName
	 *            User's user name
	 * @param firstName
	 *            User's first name
	 * @param lastName
	 *            User's last name
	 * @param email
	 *            User's email address, should be form of name@domain.com
	 * @param sms
	 *            User's sms number
	 * @param phone
	 *            User's phone number
	 * @param mobile
	 *            User's mobile number
	 */
	public TestUser(TestProperties testProperties, String userName, String firstName, String lastName, String email,
			String sms, String phone, String mobile) {
		language = testProperties.language;
		this.password = testProperties.password;
		this.userName = userName;
		this.name = new Name(firstName, lastName);
		this.email = email;
		this.phoneNumber = new PhoneNumber(sms, phone, mobile);
	}

	/**
	 * Generates an email of the first name's initial + last name @testuser.com.
	 * e.g. Thomas Hughes = thughes@testuser.com
	 * 
	 * @return a String containing the generated email address
	 */
	private String generateEmail() {
		return firstName.charAt(0) + lastName + "@testuser.com";
	}

	/**
	 * Generates a random Name object, sets name properties to random name
	 * generated.
	 * 
	 * @return Name object with randomly generated first and last name.
	 */
	private Name generateName() {
		Name name = nameGenerator.generateName();
		this.firstName = name.getFirstName();
		this.lastName = name.getLastName();
		return name;
	}

	/**
	 * Generates a random PhoneNumber object
	 * 
	 * @return PhoneNumber object with randomly generated phone number, mobile
	 *         number, and sms number.
	 */
	private PhoneNumber generatePhoneNumber() {
		return phoneNumberGenerator.generatePhoneNumber();
	}

	/**
	 * Generates a user name of first name's initial + last name. e.g. Thomas Hughes
	 * = thughes
	 * 
	 * @return a String containing the generated user name
	 */
	private String generateUserName() {
		return firstName.charAt(0) + lastName;
	}

	/**
	 * Gets the email address of the user
	 * 
	 * @return a String containing the email address of the user
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the first name of the user
	 * 
	 * @return a String containing the first name of the user
	 */
	public String getFirstName() {
		return name.getFirstName();
	}

	/**
	 * Gets the full name of the user formatted as "FirstName LastName" (with the
	 * space between)
	 * 
	 * @return a String containing the first name and last name of the user,
	 *         separated with a space
	 */
	public String getFullName() {
		return name.toString();
	}

	/**
	 * Gets the language for the user, e.g. en-US
	 * 
	 * @return a String containing the language for the user, e.g. en-US
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Gets the last name of the user
	 * 
	 * @return a String containing the last name of the user
	 */
	public String getLastName() {
		return name.getLastName();
	}

	/**
	 * Gets the mobile number for the user
	 * 
	 * @return a String containing the mobile number of the user
	 */
	public String getMobile() {
		return phoneNumber.getMobile();
	}

	/**
	 * Gets the Name Object for the user
	 * 
	 * @return the Name object of the user, containing first name and last name
	 */
	public Name getNameObject() {
		return name;
	}

	/**
	 * Gets the password for the user
	 * 
	 * @return a String containing the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the phone for the user
	 * 
	 * @return a String containing the phone of the user
	 */
	public String getPhone() {
		return phoneNumber.getPhone();
	}

	/**
	 * Gets the Phone Number Object of the user
	 * 
	 * @return a PhoneNumber object containing the phone, sms, and mobile of the
	 *         user.
	 */
	public PhoneNumber getPhoneNumberObject() {
		return phoneNumber;
	}

	/**
	 * Gets the sms for the user
	 * 
	 * @return a String containing the sms of the user
	 */
	public String getSms() {
		return phoneNumber.getSms();
	}

	/**
	 * Gets the user group of the user
	 * 
	 * @return a String containing the user group of the user
	 */
	public String getUserGroup() {
		return USER_GROUP;
	}

	/**
	 * Gets the user name of the user
	 * 
	 * @return a String containing the user name of the user
	 */
	public String getUserName() {
		return userName;
	}
}

