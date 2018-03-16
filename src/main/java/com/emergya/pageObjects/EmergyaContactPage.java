package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class EmergyaContactPage extends BasePageObject {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(EmergyaContactPage.class);

	/**
	 * Items keys selectors
	 */
	private static final String CONTACT_CARD = "contactCard";
	private static final String SEVILLA_ADRESS = "paragraphSevillaAdress";
	private static final String TOP_RIGHT_SLIDE_MENU = "topRightSlideMenu";
	private static final String LINK_TRABAJA_CON_NOSOTROS_SECUNDARY_MENU_SLIDING = "buttonTrabajaConNostrosSecondMenu";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public EmergyaContactPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(CONTACT_CARD);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");
		return status;
	}

	public boolean isSevillaAdressDisplayed() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isSevillaAdressDisplayed method");

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isSevillaAdressDisplayed method");

		return this.isElementVisibleByXPath(SEVILLA_ADRESS);
	}

	public boolean clickOnTopRightSlideMenu() {

		boolean status = false;

		if (this.isElementVisibleById(TOP_RIGHT_SLIDE_MENU, 10)) {
			this.getElementById(TOP_RIGHT_SLIDE_MENU).click();
			status = true;
		}
		return status;
	}

	public EmergyaTrabajaConNosotrosPage clickOnTrabajaConNosotrosPage() {

		if (this.isElementVisibleByXPath(LINK_TRABAJA_CON_NOSOTROS_SECUNDARY_MENU_SLIDING, 10))
			this.getElementByXPath(LINK_TRABAJA_CON_NOSOTROS_SECUNDARY_MENU_SLIDING).click();

		return new EmergyaTrabajaConNosotrosPage(driver);

	}
}
