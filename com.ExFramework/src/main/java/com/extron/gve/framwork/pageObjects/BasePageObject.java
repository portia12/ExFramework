package com.extron.gve.framwork.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.extron.gve.framework.elements.factory.api.ElementFactory;

public abstract class BasePageObject {

	public WebDriver driver;
	private WebDriverWait driverWait;

	public BasePageObject(WebDriver driver) { // constructor. to call the same driver.
		this.driver = driver;
		ElementFactory.initElements(driver, this);

		driverWait = new WebDriverWait(driver, 5);
		driverWait.pollingEvery(1, TimeUnit.SECONDS);
		driverWait.ignoring(NoSuchElementException.class);
	}

	/**
	 * Closes the driver
	 */  
	public void closeBrowser() {
		driver.close();
	}

	/**
	 * Generic method which takes a WebElement, and enters the text in it.
	 * 
	 * @param element
	 *            The WebElement object
	 * @param text
	 *            The text which is to be entered in the element
	 */
	public void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Grabs the URL from the webdriver
	 * 
	 * @return a String of the current URL in the webdriver
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Returns a boolean value after checking if element is displayed or not
	 * 
	 * @param element
	 *            The WebElement to check display status
	 * @return boolean value depending on display status
	 */
	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * Switches to default content in the web page.
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Switches to the frame passed in the parameter
	 * 
	 * @param frameToSwitchTo
	 *            The WebElement object containing the frame to switch to
	 */
	public void switchToFrame(WebElement frameToSwitchTo) {
		driver.switchTo().frame(frameToSwitchTo);
	}

	public abstract void waitForPageToLoad();

	/**
	 * Waits until element is both visible and clickable before interacting with it.
	 * 
	 * @param element
	 *            The WebElement you want to wait for
	 */
	public void waitUntilClickable(WebElement element) {
		waitUntilClickable(element, 5);
	}

	/**
	 * Waits until element is both visible and clickable before interacting with it.
	 * 
	 * @param element
	 *            The WebElement you want to wait for
	 * @param timeOutDuration
	 *            The timeout length in seconds.
	 */
	public void waitUntilClickable(WebElement element, long timeOutDuration) {
		driverWait.withTimeout(timeOutDuration, TimeUnit.SECONDS);
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Waits for an element to be visible before interacting with it, implicitly
	 * waits 5 seconds.
	 * 
	 * @param element
	 *            The WebElement you want to wait for.
	 */
	public void waitUntilVisible(WebElement element) {
		waitUntilVisible(element, 5);
	}

	/**
	 * Waits for an element to be visible before interacting with it.
	 * 
	 * @param element
	 *            The WebElement you want to wait for.
	 * @param timeOutDuration
	 *            The timeout length in seconds.
	 */
	public void waitUntilVisible(WebElement element, long timeOutDuration) {
		driverWait.withTimeout(timeOutDuration, TimeUnit.SECONDS);
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}
}



