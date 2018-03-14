package com.emergya.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class VeechMainPage extends BasePageObject {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(GoogleMainPage.class);

	/**
	 * Items keys selectors
	 */

	private static final String VEECH_HEADER = "cabecera";
	private static final String VEECH_HEADER_XPATH = "cabeceraXpath";
	private static final String VEECH_SLOGAN_XPATH = "sloganXpath";
	private static final String VEECH_IMAGENES_DE_MARCA = "madera";
	private static final String VEECH_BANNER_COLECCION = "categoria_entre_marca_y_slider";
	private static final String VEECH_SLIDER = "slider";
	private static final String VEECH_TILES = "tiles";
	private static final String VEECH_CLUB_BANNER = "veech_club_container";
	private static final String VEECH_CLUB_CARDS = "contenedor_cartas";
	private static final String VEECH_FOOTER = "footer";


	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public VeechMainPage(EmergyaWebDriver driver) {
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

		boolean status = this.isElementVisibleById(VEECH_HEADER);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if madera section is displayed
	 * 
	 * @return
	 */
	public boolean isVeechHeaderVisible() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechHeaderVisible method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechHeaderVisible method");

		log.error("Header Visible por id");
		return this.isElementVisibleById(VEECH_HEADER);
	}

	public boolean isVeechHeaderVisibleByXpath() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechHeaderVisibleByXpath method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechHeaderVisibleByXpath method");

		if (this.isElementVisibleByXPath(VEECH_HEADER_XPATH)) {
			log.error("Header visible por xpath");
			return true;
		} else {
			return false;
		}
	}

	public boolean isVeechSloganDisplayedByClass() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechSloganDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechSloganDisplayed method");

		if ((this.getElementByClassName("imagen_enjoy_your_walk") != null)) {
			log.error("Slogan Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isSloganVisibleByXpath() {
		if (this.isElementVisibleByXPath(VEECH_SLOGAN_XPATH)) {
			log.error("Slogan1 Visible por xpath");
			return true;
		} else {
			return false;
		}
	}

	public boolean isVeechImagenesDeMarcaDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName()
				+ "]- Start isVeechImagenesDeMarcaDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName()
				+ "]- End isVeechImagenesDeMarcaDisplayed method");

		if ((this.getElementByClassName(VEECH_IMAGENES_DE_MARCA) != null)) {
			log.error("madera Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechColeccionBannerDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start ColeccionBanner method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End ColeccionBanner method");

		if ((this.getElementByClassName(VEECH_BANNER_COLECCION) != null)) {
			log.error("Coleccion Banner Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechSliderDisplayed1() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start VeechSlider method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End VeechSlider method");

		if ((this.getElementByClassName(VEECH_SLIDER) != null)) {
			log.error("slider Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechTilesDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechTiles method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechTiles method");

		if ((this.getElementByClassName(VEECH_TILES) != null)) {
			log.error("tiles Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechClubBannerDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechClubBannerDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechClubBannerDisplayed method");

		if ((this.getElementByClassName(VEECH_CLUB_BANNER) != null)) {
			log.error("veech_club_container Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechClubCardsDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechClubCardsDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechClubCardsDisplayed method");

		if ((this.getElementByClassName(VEECH_CLUB_CARDS) != null)) {
			log.error("contenedor_cartas Visible por clase");
			return true;
		}

		else
			return false;
	}

	public boolean isVeechFooterVisible() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isVeechFooterVisible method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isVeechFooterVisible method");

		log.error("footer Visible por id");
		return this.isElementVisibleById(VEECH_FOOTER);
	}

	

	public VeechLoginPage clickOnLoginPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");
		String xpathLink = "//*[@id=\'_desktop_user_info\']/div/a";

		//*[@id="_desktop_user_info"]/div/a
		
		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new VeechLoginPage(driver);
	}
	
	
	/**
	 * Selenium GetElementByClassName
	 * @param selector
	 * @return
	 */
	public WebElement getElementByClassName(String selector) {

		return driver.findElement(By.className(selector));
	}

}
