package com.extron.gve.framwork.publicObjects;

package com.extron.gve.framework.publicobjects;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberGenerator {

	// 3 digits of area code - 3 digits of seq1 - 4 digits seq2
	private int area1, area2, area3, seq1, seq2;

	@Autowired
	private Random random;

	@Autowired
	public PhoneNumberGenerator() {
	}

	/**
	 * Generates a random area code from 100 to 777, no 0 to start and no 8 or 9 as
	 * these are not real area codes.
	 * 
	 * @return a String containing the randomly generated Area Code
	 */
	private String generateAreaCode() {
		area1 = random.nextInt(7) + 1;
		area2 = random.nextInt(8);
		area3 = random.nextInt(8);

		return area1 + "" + area2 + "" + area3;
	}

	/**
	 * Generates a random three digit number set from 100-799, nothing above 800 as
	 * it would not be a real number
	 * 
	 * @return a String containing the set of three numbers after the area code.
	 */
	private String generateNumberSeq1() {
		seq1 = random.nextInt(800) + 100;

		return Integer.toString(seq1);
	}

	/**
	 * Generates a random four digit number set from 1000-9999
	 * 
	 * @return a String containing the set of four numbers after the area code.
	 */
	private String generateNumberSeq2() {
		seq2 = random.nextInt(8999) + 100;

		return Integer.toString(seq2);
	}

	/**
	 * Generates a random phone number
	 * 
	 * @return a String containing a random phone number with no delimiters.
	 */
	private String generatePhone() {
		String areaCode = generateAreaCode();
		String set1 = generateNumberSeq1();
		String set2 = generateNumberSeq2();

		return (areaCode + set1 + set2);
	}

	/**
	 * Generates a PhoneNumber Object with a randomly generated sms, phone, and
	 * mobile
	 * 
	 * @return a PhoneNumber Object with a randomly generated sms, phone, and mobile
	 */
	public PhoneNumber generatePhoneNumber() {
		return new PhoneNumber(generatePhone(), generatePhone(), generatePhone());
	}
}

