package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class DemoAutomationTestingMainPage extends BasePageObject {

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public DemoAutomationTestingMainPage(EmergyaWebDriver driver) {
		super(driver);
	}

	/**
	 * Logger class initialization
	 */

	static Logger log = Logger.getLogger(DemoAutomationTestingMainPage.class);

	/**
	 * Items keys selectors
	 */

	private static final String INDEX_LOGO = "indexLogo";
	private static final String SIGN_IN_BUTTON = "signInButton";
	private static final String SKIP_SIGN_IN_BUTTON = "skipSignInButton";
	private static final String INPUT_EMAIL = "inputEmail";
	private static final String SUBMIT_BUTTON = "submitButton";

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		boolean status = this.isElementVisibleById(INDEX_LOGO);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		return status;
	}

	public DemoAutomationTestingSignInPage clickSignInButton() {

		if (this.isElementVisibleById(SIGN_IN_BUTTON))
			this.getElementById(SIGN_IN_BUTTON).click();

		return new DemoAutomationTestingSignInPage(driver);
	}

	public DemoAutomationTestingRegisterPage clickSkipSignInButton() {
		if (this.isElementVisibleById(SKIP_SIGN_IN_BUTTON))
			this.getElementById(SKIP_SIGN_IN_BUTTON).click();

		return new DemoAutomationTestingRegisterPage(driver);
	}

	public DemoAutomationTestingRegisterPage fillFormAndSubmit(String email) {
		if (this.isElementVisibleById(INPUT_EMAIL)) {
			this.getElementById(INPUT_EMAIL).sendKeys(email);
			if (this.isElementVisibleById(SUBMIT_BUTTON))
				this.getElementById(SUBMIT_BUTTON).click();
		}
		return new DemoAutomationTestingRegisterPage(driver);
	}

}
