package com.extron.gve.framwork.publicObjects;

package com.extron.gve.framework.publicobjects;

public class PhoneNumber {

	private final String sms;
	private final String phone;
	private final String mobile;

	/**
	 * Creates a PhoneNumber object with specified information
	 * 
	 * @param sms
	 *            the sms number
	 * @param phone
	 *            the phone number
	 * @param mobile
	 *            the mobile number
	 */
	public PhoneNumber(String sms, String phone, String mobile) {
		this.sms = sms;
		this.phone = phone;
		this.mobile = mobile;
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

		PhoneNumber phoneNumber = (PhoneNumber) obj;

		// If sms's are not equal, or either is null, return false.
		if (sms != null ? !sms.equals(phoneNumber.sms) : phoneNumber.sms != null) {
			return false;
		}

		// If phones's are not equal, or either is null, return false.
		if (phone != null ? !phone.equals(phoneNumber.phone) : phoneNumber.phone != null) {
			return false;
		}

		// If mobiles's are not equal, or either is null, return false.
		if (mobile != null ? !mobile.equals(phoneNumber.mobile) : phoneNumber.mobile != null) {
			return false;
		}

		// Phone numbers are equal
		return true;
	}

	/**
	 * Gets the mobile number
	 * 
	 * @return a String containing the mobile number
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Gets the phone number
	 * 
	 * @return a String containing the phone number
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Gets the sms number
	 * 
	 * @return a String containing the sms number
	 */
	public String getSms() {
		return sms;
	}

	/**
	 * Converts name to easy readable format of phone numbers in object
	 * 
	 * @return a String containing the phone number in format type:number e.g.
	 *         sms:2083469874 phone:91914359746 mobile:2094782099
	 */
	@Override
	public String toString() {
		return ("sms:" + sms + " phone:" + phone + " mobile:" + mobile);
	}
}

