package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class EmergyaTrabajaConNosotrosPage extends BasePageObject {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(EmergyaTrabajaConNosotrosPage.class);

	/**
	 * Items keys selectors
	 */

	public static final String H1_OF_EMERGYA_TRABAJA_CON_NOSOTROS = "h1TitleWorkWithUs";

	/**
	 * Constructor
	 */
	public EmergyaTrabajaConNosotrosPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(H1_OF_EMERGYA_TRABAJA_CON_NOSOTROS);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}
}
