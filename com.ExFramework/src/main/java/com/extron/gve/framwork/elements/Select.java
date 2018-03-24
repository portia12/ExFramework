package com.extron.gve.framwork.elements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.extron.gve.framework.elements.base.Element;
import com.extron.gve.framework.elements.base.ImplementedBy;

/**
 * Interface for a custom Select WebElement.
 */
@ImplementedBy(SelectImpl.class)
public interface Select extends Element {
	/**
	 * Wraps Selenium's method
	 */
	void deselectAll();

	/**
	 * Wraps Selenium's method
	 * 
	 * @param index
	 *            index to select
	 */
	void deselectByIndex(int index);

	/**
	 * Wraps Selenium's method
	 * 
	 * @param value
	 *            value to deselect
	 */
	void deselectByValue(String value);

	/**
	 * Wraps Selenium's method
	 * 
	 * @param text
	 *            text to deselect by visible text
	 */
	void deselectByVisibleText(String text);

	/**
	 * Wraps Selenium's method
	 * 
	 * @return List of WebElements selected in the Select
	 */
	List<WebElement> getAllSelectedOptions();

	/**
	 * Wraps Selenium's method
	 * 
	 * @return WebElement of the first selected option.
	 */
	WebElement getFirstSelectedOption();

	/**
	 * Wraps Selenium's method
	 * 
	 * @return list of all options in the Select
	 */
	List<WebElement> getOptions();

	/**
	 * Wraps Selenium's method
	 * 
	 * @return boolean if this is a multi-select
	 */
	boolean isMultiple();

	/**
	 * Wraps Selenium's method
	 * 
	 * @param index
	 *            index to select
	 */
	void selectByIndex(int index);

	/**
	 * Wraps Selenium's method
	 * 
	 * @param value
	 *            the value to select
	 */
	void selectByValue(String value);

	/**
	 * Wraps Selenium's method
	 * 
	 * @param text
	 *            visible text to select
	 */
	void selectByVisibleText(String text);
}









