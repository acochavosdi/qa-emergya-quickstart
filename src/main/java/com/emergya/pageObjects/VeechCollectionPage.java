package com.emergya.pageObjects;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class VeechCollectionPage extends BasePageObject {

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(VeechCollectionPage.class);

	/**
	 * Items Keys Selectors
	 */
	private static final String BODY_CATEGORY_ID = "collection";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public VeechCollectionPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(BODY_CATEGORY_ID);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean isBodyCategoryIdVisible() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isBodyCategoryIdVisible method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isBodyCategoryIdVisible method");

		log.error("Category Visible por id");
		return this.isElementVisibleById(BODY_CATEGORY_ID);
	}

	public VeechLoginPage clickOnLoginPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");
		String xpathLink = "//*[@id=\'_desktop_user_info\']/div/a";

		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new VeechLoginPage(driver);

	}

}