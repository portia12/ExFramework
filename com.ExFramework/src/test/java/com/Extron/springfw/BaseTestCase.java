package com.Extron.springfw;

package com.extron.gve.testcases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.extron.gve.framework.pageobjects.HomePageObject;
import com.extron.gve.framework.pageobjects.LoginPageObject;
import com.extron.gve.properties.TestProperties;
import com.extron.gve.spring.SpringConfiguration;

@ContextConfiguration(classes = { SpringConfiguration.class })
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class })
public abstract class BaseTestCase extends AbstractTestNGSpringContextTests {

	@Autowired
	private LoginPageObject loginPageObject;
	
	@Autowired
	private HomePageObject homePageObject;

	@Autowired
	private TestProperties testProperties;

	/**
	 * Login to GVE using test username and password
	 */
	public void login() {
		loginPageObject.waitForPageToLoad();

		loginPageObject.enterUserName(testProperties.username);
		loginPageObject.enterPassword(testProperties.password);
		HomePageObject homePageObject = loginPageObject.clickLoginButton();
		homePageObject.waitForPageToLoad();
	}

	/**
	 * Logout of the system
	 */
	public void logout() {
		homePageObject.clickLogoutButton();
	}

}








package org.testng;

/**
 * This is a marker interface for all objects that can be passed
 * as a -listener argument.
 *
 * @author cbeust
 */
public interface ITestNGListener {
}


