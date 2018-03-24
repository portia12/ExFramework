package com.extron.gve.framwork.publicObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class NameGenerator {
	private List<String> firstNames = new ArrayList<>();
	private List<String> lastNames = new ArrayList<>();

	private Resource firstNameFile;
	private Resource lastNameFile;

	@Autowired
	private Random random;

	@Autowired
	public NameGenerator(ResourceLoader resourceLoader) {
		firstNameFile = resourceLoader.getResource("classpath:firstName.txt");
		lastNameFile = resourceLoader.getResource("classpath:firstName.txt");

		try {
			firstNames = loadNames(firstNameFile);
			lastNames = loadNames(lastNameFile);
		} catch (IOException e) {
			System.out.println("WARNING: IOException while loading names files. You may not get a name returned!");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Generates a single name.
	 * 
	 * @return a randomly generated name
	 */
	public Name generateName() {
		return new Name(pickName(firstNames), pickName(lastNames));
	}

	/**
	 * Generates a list of names
	 * 
	 * @param count
	 *            the number of names to generate
	 * 
	 * @return a list of randomly generated names
	 */
	public List<Name> generateNames(final int count) {
		List<Name> names = new ArrayList<>(count);

		for (int i = 0; i < count; i++) {
			names.add(generateName());
		}

		return names;
	}

	/**
	 * Loads all of the names in the given file into a List
	 * 
	 * @param file
	 *            the resource path to the text file containing the names to load
	 * 
	 * @return a List of all the names in the given file.
	 * @throws IOException
	 */
	private List<String> loadNames(Resource file) throws IOException {
		List<String> names = new ArrayList<>();
		InputStream inputStream = file.getInputStream();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = reader.readLine();
			while (line != null) {
				names.add(line);
				line = reader.readLine();
			}
		}

		return names;
	}

	/**
	 * Picks a name from the given list based on a random number between 0 and the
	 * size of the list, which serves as the index in the list.
	 * 
	 * @param names
	 *            the list of names to pick from
	 * @return the randomly picked name.
	 */
	private String pickName(final List<String> names) {
		Integer index = null;
		int size = names.size() - 1;
		while (index == null) {
			try {
				index = random.nextInt(size);
			} catch (NullPointerException ignored) {
				// Do Nothing, loop again.
			}
		}

		return names.get(index);
	}
}

