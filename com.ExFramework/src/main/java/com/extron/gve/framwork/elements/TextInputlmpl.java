package com.extron.gve.framwork.elements;

import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.ElementImpl;

/**
 * TextInput Element wrapper
 */
public class TextInputImpl extends ElementImpl implements TextInput {

	/**
	 * Creates a custom TextInput Element for a given WebElement
	 * 
	 * @param element
	 */
	public TextInputImpl(WebElement element) {
		super(element);
	}

	/**
	 * Wraps Selenium's method
	 */
	@Override
	public void clear() {
		getWrappedElement().clear();
	}

	/**
	 * Gets the value of the input field.
	 * 
	 * @return String with the value of the field.
	 */
	@Override
	public String getText() {
		return getWrappedElement().getAttribute("value");
	}

	/**
	 * Sets the text in the TextInput to the given text
	 * 
	 * @param text
	 *            Text to enter into the TextInput
	 */
	@Override
	public void set(String text) {
		WebElement element = getWrappedElement();
		element.clear();
		element.sendKeys(text);
	}
}








