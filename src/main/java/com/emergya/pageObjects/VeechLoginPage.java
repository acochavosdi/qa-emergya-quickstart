package com.emergya.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class VeechLoginPage extends BasePageObject {

	/**
	 * Logger initialization
	 */

	static Logger log = Logger.getLogger(VeechLoginPage.class);

	/**
	 * Items Keys Selectors
	 */
	private static final String LOGIN_FORM_ID = "loginFormId";
	private static final String LANGUAGE_SELECTOR = "languaje_selector";
	private static final String ENGLISH_SELECTOR = "english_selector";
	private static final String SPANISH_SELECTOR = "spanish_selector";
	private static final String NAVBAR_LOGIN_BUTTON_XPATH = "//*[@id=\'_desktop_user_info\']/div/a";
	private static final String CONTENT_CUENTA = "content_spanish_word";
	private static final String CONTENT_ACCOUNT = "content_english_word";
	private static final String EMAIL_INPUT = "loginform_email_input";
	private static final String PASSWORD_INPUT = "loginform_password_input";
	private static final String HIDE_AND_SHOW_BUTTON = "hideandshowbutton";

	/**
	 * CONSTRUCTOR METHOD
	 * 
	 * @param driver
	 *            selenium webdriver
	 * 
	 */
	public VeechLoginPage(EmergyaWebDriver driver) {
		super(driver);
	}

	/**
	 * COMRPRUEBA QUE ESTAS EN LA LOGIN PAGE
	 */
	@Override
	public boolean isReady() {

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(LOGIN_FORM_ID);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	/**
	 * COMPRUEBA QUE ES VISIBLE EL FORMULARIO DEL LOGIN, PARA VERIFICAR QUE ESTAS EN
	 * LA LOGIN PAGE
	 * 
	 * @return
	 */
	public boolean isLoginFormVisible() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechHeaderVisible method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechHeaderVisible method");

		log.error("Login Form Visible por id");
		return this.isElementVisibleById(LOGIN_FORM_ID);
	}

	/**
	 * CLICKAR EN EL BOTON COLECCION DEL MENU
	 * 
	 * @return
	 */
	public VeechCollectionPage clickOnCollectionPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");
		String xpathLink = "//*[@id=\"barra_de_menu_coleccion\"]/div/div[1]/div[1]/a";
		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new VeechCollectionPage(driver);

	}

	/**
	 * CLICKAR EN EL LOGO DEL MENU PARA VOLVER AL INDEX
	 * 
	 * @return
	 */
	public VeechMainPage clickOnMainPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");
		String xpathLink = "	//*[@id=\'barra_de_menu_coleccion\']/div/div[1]/div[2]/a";
		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new VeechMainPage(driver);

	}

	/**
	 * CAMBIAR IDIOMA A INGLES
	 */
	public void changeLanguageToEng() {
		log.info("[log-" + this.getClass().getSimpleName() + "]- Start changing languaje to eng -["
				+ this.getClass().getSimpleName() + "- method]");

		if (this.isElementVisibleByXPath(LANGUAGE_SELECTOR)) {
			this.getElementByXPath(LANGUAGE_SELECTOR).click();
			this.waitForByXPath(LANGUAGE_SELECTOR);

			if (this.isElementVisibleByXPath(ENGLISH_SELECTOR)) {
				this.getElementByXPath(ENGLISH_SELECTOR).click();

				log.error("Idioma cambiado a ingles");

			}

		}

		log.info("[log-" + this.getClass().getSimpleName() + "]- End changing languaje to eng -["
				+ this.getClass().getSimpleName() + "- method]");
	}

	/**
	 * CAMBIAR IDIOMA A ESPAÑOL
	 */
	public void changeLanguageToSpanish() {
		log.info("[log-" + this.getClass().getSimpleName() + "]- Start changing languaje to spa -["
				+ this.getClass().getSimpleName() + "- method]");

		if (this.isElementVisibleByXPath(LANGUAGE_SELECTOR)) {
			this.getElementByXPath(LANGUAGE_SELECTOR).click();
			this.waitForByXPath(LANGUAGE_SELECTOR);

			if (this.isElementVisibleByXPath(SPANISH_SELECTOR)) {
				this.getElementByXPath(SPANISH_SELECTOR).click();

				log.error("Idioma cambiado a español");

			}

		}

		log.info("[log-" + this.getClass().getSimpleName() + "]- End changing languaje to spa -["
				+ this.getClass().getSimpleName() + "- method]");
	}

	public void checkIfSpanishLanguaje() {

		// String text = "cuenta";
		List<WebElement> myList = this.getElementsByXPath(CONTENT_CUENTA);

		// Assert.assertTrue("Text not found!", list.size() > 0);

		if (myList.size() > 0)
			log.error("Estamos en español");
		else {
			log.error("Estamos en ingles");
		}

	}

	public void checkIfEnglishLanguaje() {

		// String text = "account";
		List<WebElement> myList = this.getElementsByXPath(CONTENT_ACCOUNT);
		// Assert.assertTrue("Text not found!", list.size() > 0);

		if (myList.size() > 0)
			log.error("Estamos en ingles");
		else {
			log.error("Estamos en español");
		}
	}

	public void clickOnAccountLogin() {

		log.info("[log-" + this.getClass().getSimpleName() + "]- Start clickOnAccountLogin -["
				+ this.getClass().getSimpleName() + "- method]");

		String xpathLink = NAVBAR_LOGIN_BUTTON_XPATH;
		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-" + this.getClass().getSimpleName() + "]- End clickOnAccountLogin -["
				+ this.getClass().getSimpleName() + "- method]");

	}

	public void writeOnLoginFormEmailField(String emailString) {
		if (this.isElementVisibleByXPath(EMAIL_INPUT)) {
			this.getElementByXPath(EMAIL_INPUT).sendKeys(emailString);
		}
	}

	public void writeOnLoginFormPasswordField(String passwordString) {
		if (this.isElementVisibleByXPath(PASSWORD_INPUT)) {
			this.getElementByXPath(PASSWORD_INPUT).sendKeys(passwordString);
		}
	}
	
	public void pressHideAndShowPasswordButton() {
		if (this.isElementVisibleByXPath(HIDE_AND_SHOW_BUTTON)) {
			this.getElementByXPath(HIDE_AND_SHOW_BUTTON).click();
		}
	}
}
