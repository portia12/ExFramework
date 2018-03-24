package com.extron.gve.framwork.pageObjects.systemMenu;

package com.extron.gve.framework.pageobjects.systemmenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.extron.gve.framework.pageobjects.BasePageObject;
import com.extron.gve.framework.pageobjects.systemmenu.emailmanager.EmailManagerPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.usermanager.UserManagerPageObject;

@Component
public class SystemMenuPageObject extends BasePageObject {
	
	@Autowired
	private UserManagerPageObject userManagerPageObject;

	@Autowired
	private EmailManagerPageObject emailManagerPageObject;

	@FindBy(id = "users")
	private WebElement userManagerButton;

	@FindBy(id = "email")
	private WebElement emailManagerButton;

	@Autowired
	public SystemMenuPageObject(WebDriver driver) {
		super(driver);
	}

	/**
	 * Clicks the Email Manager button
	 * 
	 * @return EmailManagerPageObject
	 */
	public EmailManagerPageObject clickEmailManagerButton() {
		emailManagerButton.click();
		return emailManagerPageObject;
	}

	/**
	 * Clicks the User Manager button
	 * 
	 * @return UserManagerPageObject
	 */
	public UserManagerPageObject clickUserManagerButton() {
		userManagerButton.click();
		return userManagerPageObject;
	}

	/**
	 * Waits for page to load
	 */
	@Override
	public void waitForPageToLoad() {
		waitUntilVisible(userManagerButton);
	}
}

