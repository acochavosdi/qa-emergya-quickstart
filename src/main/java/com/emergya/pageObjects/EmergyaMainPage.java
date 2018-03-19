package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

/**
 * A Page Object (PO) contain the behavior of a specific page in the application
 * EmergyaMainPage: This PO contain the methods to interact with the emergya
 * main page
 * 
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class EmergyaMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(GoogleMainPage.class);

	/**
	 * Items keys selectors.
	 */
	private static final String IMG_LOGO_EMERGYA = "imgLogoEmergya";
	private static final String NAVBAR_CONTACT_BUTTON = "navbarContactButton";
	private static final String BLOCK_HOME_FEATURED = "blockHomeFeatured";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public EmergyaMainPage(EmergyaWebDriver driver) {
		super(driver);
	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(IMG_LOGO_EMERGYA);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if emergya logo is displayed
	 * 
	 * @return
	 */
	public boolean isEmergyaLogoDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isEmergyaLogoDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isEmergyaLogoDisplayed method");

		return this.isElementVisibleById(IMG_LOGO_EMERGYA);
	}

	public EmergyaContactPage clickOnNavbarContactButton() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnNavbarContactButton method");

		driver.clickIfExists(By.xpath(this.getXPath(NAVBAR_CONTACT_BUTTON)));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnNavbarContactButton method");

		return new EmergyaContactPage(driver);

	}

	public void acceptCookies() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start acceptCookies method");

		String agreeButtonCssSelector = ".agree-button";

		driver.waitUntilVisible(By.cssSelector(agreeButtonCssSelector), 2);
		if (driver.isElementDisplayed(By.cssSelector(agreeButtonCssSelector))) {
			log.info("Cookies Button found, lets press it");
			driver.findElement(By.cssSelector(agreeButtonCssSelector)).click();
		} else {
			log.info("Cookiges Button not found, so i cant press it");
		}
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End acceptCookies method");

	}

	public void checkAndPrintLanguageByUrl() {

		String url = driver.getCurrentUrl();

		if (url.contains("/es"))
			log.info("Spanish URL");
		if (url.contains("/en"))
			log.info("English URL");
		if (url.contains("/cl"))
			log.info("Chile URL");
	}

	public void usingScrolling() throws InterruptedException {

		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		// Scroll to Top
		this.scrollTop();
		Thread.sleep(1500);

		// Scroll top a WebElement
		this.scrollTo(this.getElementById(BLOCK_HOME_FEATURED));
		Thread.sleep(1500);

		// Scroll with Javascript
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1500);

		// Scroll to Bottom
		this.scrollBottom();
		Thread.sleep(1500);

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1500);

		this.scrollTop();
		Thread.sleep(1500);
	}

	public void usingMouse() throws InterruptedException {

		driver.moveMouseOverElement(By.xpath(getXPath(NAVBAR_CONTACT_BUTTON)));
		Thread.sleep(1500);

		driver.moveMouseOutElement(By.xpath(getXPath(NAVBAR_CONTACT_BUTTON)));
		Thread.sleep(1500);

		driver.clickOnWithMouse(By.xpath(getXPath(NAVBAR_CONTACT_BUTTON)));
		Thread.sleep(1500);

		driver.clickOutWithMouse(By.xpath(getXPath(NAVBAR_CONTACT_BUTTON)));
		Thread.sleep(1500);

	}
}
