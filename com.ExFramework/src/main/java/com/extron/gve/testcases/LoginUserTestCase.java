package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.LoginPageObject;
import com.extron.gve.properties.CommonStringProperties;
import com.extron.gve.properties.TestProperties;

public class LoginUserTestCase extends BaseTestCase {

	@Autowired
	private LoginPageObject loginPageObject;

	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private TestProperties testProperties;

	@Autowired
	private CommonStringProperties commonStringProperties;

	/**
	 * When: Logging into GVE Given: Username longer than max length (128 chars)
	 * Should: Display error message and not login to GVE
	 */
	@Test(description = "Attempts to login with user name longer than max length")
	public void loginFailMaxUsernameTest() {
		loginPageObject.waitForPageToLoad();

		String userName = "This is a test for username. It accepts alphanumeric characters for a maximum length of 128 characters. This string exceeds the length, and should throw an error message";
		loginPageObject.enterUserName(userName);
		loginPageObject.enterPassword(testProperties.password);
		loginPageObject.clickLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageText(), commonStringProperties.incorrectLoginMessage);
	}
	
	/**
	 * When: Logging into GVE Given: Username shorter than min length (2 chars)
	 * Should: Display error message and not login to GVE
	 */
	@Test(description = "Attempts to login with user name shorter than min length")
	public void loginFailMinUsernameTest() {
		loginPageObject.waitForPageToLoad();

		loginPageObject.enterUserName("a");
		loginPageObject.enterPassword(testProperties.password);
		loginPageObject.clickLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageText(), commonStringProperties.incorrectLoginMessage);
	}
	
	/**
	 * When: Logging into GVE Given: Username with script characters
	 * Should: Display error message and not login to GVE
	 */
	@Test(description = "Attempts to login with script characters in username")
	public void loginFailScriptCharsTest() {
		loginPageObject.waitForPageToLoad();

		loginPageObject.enterUserName("<script type=\"text/javascript\"> alert(\"1111\"); </script>");
		loginPageObject.enterPassword(testProperties.password);
		loginPageObject.clickLoginButton();

		Assert.assertTrue(loginPageObject.getDangerMessageText().contains("Server Error"));
	}
	
	/**
	 * When: Logging into GVE Given: Incorrect Login Credentials Should: Display
	 * error message and not login to GVE
	 */
	@Test(description = "Attempts to login with bad user name")
	public void loginFailTest() {
		
		loginPageObject.driver.get(testProperties.url);
		loginPageObject.waitForPageToLoad();

		loginPageObject.enterUserName("NotAUser");
		loginPageObject.enterPassword("NotAPassword");
		loginPageObject.clickLoginButton();

		Assert.assertEquals(loginPageObject.getErrorMessageText(), commonStringProperties.incorrectLoginMessage);
	}
	
	/**
	 * When: Logging into GVE Given: No password
	 * Should: Display error message and not login to GVE
	 */
	@Test(description = "Attempt to log in with no password")
	public void loginNoPassword ()
	{
		loginPageObject.waitForPageToLoad();
		
		loginPageObject.enterUserName(testProperties.username);
		loginPageObject.enterPassword("");
		loginPageObject.clickLoginButton();
		
		Assert.assertEquals(loginPageObject.getPasswordErrorMessageText(), commonStringProperties.noPasswordMessage);
	}
	
	/**
	 * When: Logging into GVE Given: No username
	 * Should: Display error message and not login to GVE
	 */
	@Test(description = "Attempt to log in with no username")
	public void loginNoUsername ()
	{
		loginPageObject.waitForPageToLoad();
		
		loginPageObject.enterUserName("");
		loginPageObject.enterPassword(testProperties.password);
		loginPageObject.clickLoginButton();
		
		Assert.assertEquals(loginPageObject.getUsernameErrorMessageText(), commonStringProperties.noUsernameMessage);
	}
	
	/**
	 * When: Logging into GVE Given: Correct Login Credentials Should: Log into GVE
	 * Successfully
	 */
	@Test(description = "Logs into the GVE Website")
	public void loginTest() {
		loginPageObject.waitForPageToLoad();

		loginPageObject.enterUserName(testProperties.username);
		loginPageObject.enterPassword(testProperties.password);
		loginPageObject.clickLoginButton();
		homePageObject.waitForPageToLoad();

		Assert.assertTrue(loginPageObject.getCurrentUrl().contains(commonStringProperties.loginPageUrl));

		homePageObject.clickLogoutButton();
	}

}

