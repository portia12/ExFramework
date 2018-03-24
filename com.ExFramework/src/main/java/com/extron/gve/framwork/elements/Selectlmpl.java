package com.extron.gve.framwork.elements;

import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.ElementImpl;

/**
 * Wrapper around a WebElement for the Select class in Selenium
 */
public class SelectImpl extends ElementImpl implements Select {
	/**
	 * enum to track state of Select items, whether they are visible or not,
	 * disabled or not, and selected or not, or if they are found or not.
	 */
	private enum State {

		NOT_FOUND, NOT_VISIBLE, DISABLED, SELECTED;

		/**
		 * Checks the state of the element you are searching for and throws the proper
		 * exception with better logging if needed.
		 * 
		 * @param searchCriteria
		 */
		private void checkState(String searchCriteria) {
			switch (this) {
			case NOT_VISIBLE:
				throw new ElementNotVisibleException(
						"The element was no visible using the search criteria: " + searchCriteria);
			case DISABLED:
				throw new InvalidElementStateException(
						"The element found with search criteria: " + searchCriteria + " was found, but is disabled.");
			case NOT_FOUND:
				throw new NoSuchElementException("Cannot locate option with search criteria:" + searchCriteria);
			case SELECTED:
				return;
			}
		}

		/**
		 * Sets the State of a WebElement to newState
		 * 
		 * @param newState
		 *            the State to set to
		 * @return the new State based on newState
		 */
		private State recognizeNewState(State newState) {
			if (this.ordinal() < newState.ordinal()) {
				return newState;
			} else {
				return this;
			}
		}
	}

	private final org.openqa.selenium.support.ui.Select innerSelect;

	/**
	 * Wraps a WebElement with custom Select functionality
	 * 
	 * @param element
	 *            to wrap in Select wrapper
	 */
	public SelectImpl(WebElement element) {
		super(element);
		this.innerSelect = new org.openqa.selenium.support.ui.Select(element);
	}

	/**
	 * Wraps Selenium's method
	 */
	@Override
	public void deselectAll() {
		innerSelect.deselectAll();
	}

	/**
	 * Wraps Selenium's method
	 */
	@Override
	public void deselectByIndex(int index) {
		innerSelect.deselectByIndex(index);
	}

	/**
	 * Wraps Selenium's method
	 * 
	 * @param value
	 *            value to deselect
	 */
	@Override
	public void deselectByValue(String value) {
		innerSelect.deselectByValue(value);
	}

	/**
	 * Wraps Selenium's method
	 * 
	 * @param text
	 *            text to deselect by visible text
	 */
	@Override
	public void deselectByVisibleText(String text) {
		innerSelect.deselectByVisibleText(text);
	}

	/**
	 * Handles strings that need ` or " escaped (or both). Used in methods that
	 * require finding a string that has quotes in it that need to be escaped
	 * 
	 * @param toEscape
	 *            the String to escape the quotes on
	 * @return String String with quotes escaped
	 */
	private String escapeQuotes(String toEscape) {
		// Covert strings with both quotes and ticks: i.e. foo'"barr => concat("foo'",
		// '"', "bar")
		if (toEscape.indexOf("\"") > -1 && toEscape.indexOf("'") > -1) {
			boolean quoteIsLast = false;
			if (toEscape.lastIndexOf("\"") == toEscape.length() - 1) {
				quoteIsLast = true;
			}

			// split on the quotes, then re-add each one escaped in the string.
			String[] substrings = toEscape.split("\"");

			StringBuilder quoted = new StringBuilder("concat(");
			for (int i = 0; i < substrings.length; i++) {
				quoted.append("\"").append(substrings[i]).append("\"");
				quoted.append(((i == substrings.length - 1) ? (quoteIsLast ? ", '\"')" : ")") : ", '\"', "));
			}

			return quoted.toString();
		}

		// Escape String with just a quote into being single quoted: i.e. f"oo => 'f"oo'
		if (toEscape.indexOf("\"") > -1) {
			return String.format("'%s'", toEscape);
		}

		// Otherwise return the quoted String
		return String.format("\"%s\"", toEscape);
	}

	/**
	 * Wraps Selenium's method
	 * 
	 * @return list of WebElements selected in the Select
	 */
	@Override
	public List<WebElement> getAllSelectedOptions() {
		return innerSelect.getAllSelectedOptions();
	}

	/**
	 * Wraps Selenium's method
	 *
	 * @return WebElement of the first selected option
	 */
	@Override
	public WebElement getFirstSelectedOption() {
		return innerSelect.getFirstSelectedOption();
	}

	/**
	 * Gets the longest substring that doesn't contain a space. Used in locating
	 * elements that may have need to have escaped quotes in order to find by xpath
	 * 
	 * @param s
	 *            String to check for longest substring
	 * @return String containing the longest Substring of the original String s
	 */
	private String getLongestSubstringWithoutSpace(String s) {
		String result = "";
		StringTokenizer st = new StringTokenizer(s, " ");

		while (st.hasMoreTokens()) {
			String tokenString = st.nextToken();
			if (tokenString.length() > result.length()) {
				result = tokenString;
			}
		}
		return result;
	}

	/**
	 * Wraps Selenium's method
	 * 
	 * @return list of all the options in the Select
	 */
	@Override
	public List<WebElement> getOptions() {
		return innerSelect.getOptions();
	}

	/**
	 * Wraps Selenium's method
	 */
	@Override
	public boolean isMultiple() {
		return innerSelect.isMultiple();
	}

	/**
	 * Select the option at the given index. This is done by examining the "index"
	 * attribute of an element, and not merely by counting.
	 * 
	 * @param index
	 *            The option at this index will be selected
	 * @throws NoSucheElementException
	 *             if no matching option elements are found or the elements are not
	 *             visible or disabled.
	 */
	@Override
	public void selectByIndex(int index) {
		String match = String.valueOf(index);

		State state = State.NOT_FOUND;
		for (WebElement option : getOptions()) {
			if (match.equals(option.getAttribute("index"))) {
				if (!isMultiple() && state == State.SELECTED) {
					return;
				}
			}
		}

		state.checkState("index: " + index);
	}

	/**
	 * Select all options that have a value matching the argument. That is, when
	 * given "foo" this would select an option like:
	 * 
	 * &lt;option value="foo"&gt;Bar&lt;/option&gt;
	 * 
	 * @param value
	 *            The value to match against
	 * @throws NoSuchElementException
	 *             If no matching option elements are found or the elements are not
	 *             visible or disabled
	 */
	@Override
	public void selectByValue(String value) {
		StringBuilder sb = new StringBuilder(".//option[@value = ");
		sb.append(escapeQuotes(value));
		sb.append("]");
		List<WebElement> options = getWrappedElement().findElements(By.xpath(sb.toString()));

		State state = State.NOT_FOUND;
		for (WebElement option : options) {
			state = state.recognizeNewState(setSelected(option));
			if (!isMultiple() && state == State.SELECTED) {
				return;
			}
		}

		state.checkState("value: " + value);
	}

	/**
	 * Select all options that display text matching the argument. That is, when
	 * given "Bar" this would select an option like:
	 * 
	 * &lt;option value="foo"&gt;Bar&lt;/option&gt;
	 * 
	 * @param text
	 *            The visible text to match against
	 * @throws NoSuchElementException
	 *             If no matching option elements are found or the elements are not
	 *             visible or disabled.
	 */
	@Override
	public void selectByVisibleText(String text) {
		final WebElement element = getWrappedElement();

		// try finding via XPath
		List<WebElement> options = element
				.findElements(By.xpath(".//option[normalize-space(.) = " + escapeQuotes(text) + "]"));

		State state = State.NOT_FOUND;
		for (WebElement option : getOptions()) {
			state = state.recognizeNewState(setSelected(option));
			if (!isMultiple() && state == State.SELECTED) {
				return;
			}
		}

		if (options.isEmpty() && text.contains(" ")) {
			String subStringWithoutSpace = getLongestSubstringWithoutSpace(text);
			List<WebElement> candidates;
			if ("".equals(subStringWithoutSpace)) {
				// text is either empty or contains ONLY spaces, get all options
				candidates = element.findElements(By.tagName("option"));
			} else {
				// get candidates via xpath
				candidates = element
						.findElements(By.xpath(".//option[contains(., " + escapeQuotes(subStringWithoutSpace) + ")]"));
			}

			for (WebElement option : candidates) {
				if (text.equals(option.getText())) {
					state = state.recognizeNewState(setSelected(option));
					if (!isMultiple() && state == State.SELECTED) {
						return;
					}
				}
			}
		}
	}

	/**
	 * Sets the State of the given option to Selected
	 * 
	 * @param option
	 *            the WebElement to change the State of
	 * @return State State.SELECTED to denote the element is now selected.
	 */
	private State setSelected(WebElement option) {
		if (!option.isDisplayed()) {
			return State.NOT_VISIBLE;
		}
		if (!option.isEnabled()) {
			return State.DISABLED;
		}
		if (!option.isSelected()) {
			option.click();
		}
		return State.SELECTED;
	}
}
