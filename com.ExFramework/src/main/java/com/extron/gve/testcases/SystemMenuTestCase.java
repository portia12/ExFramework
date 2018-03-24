package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.systemmenu.SystemMenuPageObject;
import com.extron.gve.framework.pageobjects.systemmenu.usermanager.UserManagerPageObject;
import com.extron.gve.framework.publicobjects.PhoneNumberGenerator;
import com.extron.gve.framework.publicobjects.TestUser;
import com.extron.gve.framework.publicobjects.TestUserFactory;
import com.extron.gve.properties.TestProperties;

public class SystemMenuTestCase extends BaseTestCase {

	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private TestUserFactory testUserFactory;

	@Autowired
	private TestProperties testProperties;

	@Autowired
	private PhoneNumberGenerator phoneNumberGenerator;

	/**
	 * Attempt to add a user with username greater than max length and check if
	 * error message is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to create invalid user with scripting characters")
	public void addInvalidScriptChars() throws InterruptedException {
		String userName = "<script type=\"text/javascript\"> alert(\"1111\"); </script>";
		TestUser testUser = new TestUser(testProperties, userName, "f", "l", "fl@testuser.com",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.uncheckSendConfirmation();
		userManagerPageObject.waitUntilVisible(userManagerPageObject.getTxtUserName());
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterPassword(testUser.getPassword());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());
		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblInvalidUsername()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Attempt to add a user with username greater than max length and check if
	 * error message is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to create invalid user with scripting characters in first name")
	public void addInvalidScriptFirstName() throws InterruptedException {
		String firstName = "<script type=\"text/javascript\"> alert(\"1111\"); </script>";
		TestUser testUser = new TestUser(testProperties, "username", firstName, "last name", "fl@testuser.com",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.waitUntilVisible(userManagerPageObject.getTxtUserName());
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());

		userManagerPageObject.clickCreateUserButton();
		userManagerPageObject.switchToDefaultContent();
		Thread.sleep(250);
		Assert.assertTrue(userManagerPageObject.getDangerMessageText().contains("potentially dangerous"));
		userManagerPageObject.clickFrameClose();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Attempt to add a new user to the system with username lesser than min length
	 * and check if error message is displayed
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to create invalid user with username length greater than max")
	public void addInvalidUserMaxLength() throws InterruptedException {
		String userName = "This is a test for username. It accepts alphanumeric characters for a maximum length of 128 characters. This string exceeds the length, and should throw an error message";
		TestUser testUser = new TestUser(testProperties, userName, "f", "l", "fl@testuser.com",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());
		userManagerPageObject.uncheckSendConfirmation();
		userManagerPageObject.waitUntilVisible(userManagerPageObject.getTxtUserName());
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterPassword(testUser.getPassword());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());
		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblInvalidUsername()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Attempt to add a user with username greater than max length and check if
	 * error message is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to create invalid user with username length lesser than min")
	public void addInvalidUserMinLength() throws InterruptedException {
		TestUser testUser = new TestUser(testProperties, "a", "f", "l", "fl@testuser.com",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());
		userManagerPageObject.uncheckSendConfirmation();
		userManagerPageObject.waitUntilVisible(userManagerPageObject.getTxtUserName());
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterPassword(testUser.getPassword());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());
		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblInvalidUsername()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Add a new user to the system, and check if user has been added successfully
	 * by displaying the list of all users and checking if new user is present
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Add a New User")
	public void addNewUser() throws InterruptedException {
		TestUser testUser = testUserFactory.getTestUser();

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.uncheckSendConfirmation();
		userManagerPageObject.waitUntilVisible(userManagerPageObject.getTxtUserName());
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterPassword(testUser.getPassword());
		userManagerPageObject.enterConfirmPassword(testUser.getPassword());
		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.enterSms(testUser.getSms());
		userManagerPageObject.enterPhone(testUser.getPhone());
		userManagerPageObject.enterMobile(testUser.getMobile());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());

		userManagerPageObject.clickCreateUserButton();
		userManagerPageObject.switchToDefaultContent();

		Thread.sleep(250);
		homePageObject.waitForPageToLoad();
		userManagerPageObject.waitUntilClickable(userManagerPageObject.getListAllButton(), 15);
		userManagerPageObject.enterSearchUser(testUser.getUserName());
		userManagerPageObject.clickSearchUserButton();

		Thread.sleep(250);
		Assert.assertEquals(userManagerPageObject.getSearchResultText(), testUser.getUserName());
	}

	/**
	 * Attempt to add a user by entering an invalid email address format and check
	 * if error message is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to add a user with invalid email address format")
	public void addNewUserInvalidEmail() throws InterruptedException {
		TestUser testUser = new TestUser(testProperties, "TestUser", "TestFirstName", "TestLastName", "flast@testuser",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());
		userManagerPageObject.enterEmail(testUser.getEmail());
		userManagerPageObject.selectUserGroup(testUser.getUserGroup());

		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblValidEmailFormat()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

	}

	/**
	 * Attempt to add a user without entering email address and check if error
	 * message is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to add a user without entering email address")
	public void addNewUserWithoutEmail() throws InterruptedException {
		TestUser testUser = new TestUser(testProperties, "TestUser", "TestFirstName", "TestLastName", "fl@testuser.com",
				phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());
		// userManagerPageObject.uncheckSendConfirmation();
		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());

		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblEmptyEmail()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Attempt to add a user without selecting user group and check if error message
	 * is displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to add a user without selecting user group")
	public void addNewUserWithoutUserGroup() throws InterruptedException {
		TestUser testUser = new TestUser(testProperties, "TestUser", "TestFirstName", "TestLastName",
				"flast@testuser.com", phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.enterUserName(testUser.getUserName());
		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());
		userManagerPageObject.enterEmail(testUser.getEmail());

		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblEmptyUserGroup()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	/**
	 * Attempt to add a user without entering username and check if error message is
	 * displayed.
	 * 
	 * @throws InterruptedException
	 */
	@Test(description = "Attempt to add a user without entering username")
	public void addNewUserWithoutUsername() throws InterruptedException {
		TestUser testUser = new TestUser(testProperties, "TestUser", "TestFirstName", "TestLastName",
				"flast@testuser.com", phoneNumberGenerator.generatePhoneNumber());

		SystemMenuPageObject systemMenuPageObject = homePageObject.clickSystemMenuTab();

		UserManagerPageObject userManagerPageObject = systemMenuPageObject.clickUserManagerButton();

		userManagerPageObject.clickAddNewUserButton();
		userManagerPageObject.switchToFrame(userManagerPageObject.getAddUserFrame());

		userManagerPageObject.enterFirstName(testUser.getFirstName());
		userManagerPageObject.enterLastName(testUser.getLastName());
		userManagerPageObject.enterEmail(testUser.getEmail());

		userManagerPageObject.clickCreateUserButton();
		Assert.assertTrue(userManagerPageObject.isDisplayed(userManagerPageObject.getLblEmptyUsername()));

		userManagerPageObject.clickCloseNewUserFormButton();
		userManagerPageObject.switchToDefaultContent();

		homePageObject.waitForPageToLoad();
	}

	@BeforeMethod
	@Override
	public void login() {
		super.login();
	}

	@AfterMethod
	@Override
	public void logout() {
		super.logout();
	}

}
