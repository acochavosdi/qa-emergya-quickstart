package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.ImgbbMainPage;
import com.emergya.utils.BasicTestSet;

/**
 * A test class contain the tests of a specific page in the application
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class GoogleTestSet extends BasicTestSet {

	static Logger log = Logger.getLogger(GoogleTestSet.class);

	public GoogleTestSet() {
		super();
	}

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	// **************** TESTS ****************
	// ------ EMERGYA QA SAMPLE TEST ------ //
	// ------ US00001 - Check google main page and do a search ------ //
	/**
	 * Description: Check the main page elements and do a search on google
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to www.google.es - Check that the google logo is displayed -
	 * Check that the 'Buscar con Google' button is displayed - Check that the 'Voy
	 * a tener suerte' button is displayed - Check that the search field is
	 * displayed - Do this search 'Hello world!' - Check that several results are
	 * displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 */

	/*
	 * @Test(description = "googleMainPageSearch") public void
	 * googleMainPageSearch(Method method) { log.info("[log-TestSet] " +
	 * this.getClass().getName() + " - Start test method: " + method.getName());
	 * 
	 * // Variable declaration and definition isReady(googleMainPage = new
	 * GoogleMainPage(driver));
	 * 
	 * // Steps to build the stage (Pre steps)
	 * 
	 * try { // Go to www.google.es // Check that the google logo is displayed
	 * isLogoDisplayed();
	 * 
	 * // Check that the 'Buscar con Google' button is displayed
	 * isSearchButtonDisplayed();
	 * 
	 * // Check that the 'Voy a tener suerte' button is displayed
	 * isLuckButtonDisplayed();
	 * 
	 * // Check that the search field is displayed isSearchFieldDisplayed();
	 * 
	 * // Do this search 'Hello world!' googleMainPage.doSearch("Hello world");
	 * 
	 * // Check that several results are displayed areSeveralResults();
	 * 
	 * } finally { // Steps to clear the stage (Post steps) }
	 * 
	 * log.info("[log-TestSet] " + this.getClass().getName() +
	 * " - End test method: " + method.getName()); }
	 */

	/**
	 * Description: Do a search in Google and access to a page
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to www.google.es - Do this search 'www.emergya.es' - Access to
	 * 'www.emergya.es' - Check that the logo is displayed - Access to the
	 * 'Contacto' page - Check that the address is displayed - Access to the
	 * 'Trabaja con nosotros' page - Check '¿QUÉ OFRECEMOS?' section is displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 */
	@Test(description = "googleDoSearchAndAccessToPage")
	public void googleDoSearchAndAccessToPage(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Check that the google logo is displayed
			assertTrue("Google Logo not displayed", googleMainPage.isLogoDisplayed());

			// Check that the 'Buscar con Google' button is displayed
			assertTrue("Search Button not displayed", googleMainPage.isSearchButtonDisplayed());

			// Check that the 'Voy a tener suerte' button is displayed
			assertTrue("Luck Button not displayed", googleMainPage.isLuckButtonDisplayed());

			// Check that the search field is displayed
			assertTrue("Search Field not displayed", googleMainPage.isSearchFieldDisplayed());

			// Do this search 'www.emergya.es'
			googleMainPage.doSearch("www.emergya.es");

			// Access to 'www.emergya.es'
			emergyaMainPage = googleMainPage.clickOnEmergyaPage();

			// Check that the logo is displayed
			assertTrue("Emergya logo not displayed", emergyaMainPage.isEmergyaLogoDisplayed());

			// Access to the 'Contacto' page
			emergyaContactPage = emergyaMainPage.clickOnNavbarContactButton();
			assertTrue("Contact Page not ready", emergyaContactPage.isReady());

			// Check that Sevilla address is displayed
			assertTrue("Sevilla Adress not displayed", emergyaContactPage.isSevillaAdressDisplayed());

			// Click on top right slide menu
			assertTrue("Top right slide menu couldnt be reached, check code Mr.Developper",
					emergyaContactPage.clickOnTopRightSlideMenu());

			// Access to 'Trabaja con nosotros' page
			emergyaTrabajaConNosotrosPage = emergyaContactPage.clickOnTrabajaConNosotrosPage();

			// Check 'Ofertas de trabajo' title and wait 0.5s
			assertTrue("'Ofertas de trabajo' title not displayed", emergyaTrabajaConNosotrosPage.isReady());
			Thread.sleep(500);

			// Refresh the page and go back twice to Main Page
			// Go back twice to Main page
			driver.navigate().refresh();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);

			// Accept cookies popup if are displayed (using css selector), wait 2 seconds,
			// and try to accept it again
			emergyaMainPage.acceptCookies();
			Thread.sleep(2000);

			emergyaMainPage.acceptCookies();
			Thread.sleep(2000);

			// Check and print on log.info if the url of the page is the english Url, the
			// spanish, or the chilen one

			emergyaMainPage.checkAndPrintLanguageByUrl();

			/**
			 * Scrolling with EmergyaWebDriver Methods + Javascript
			 */

			//
			emergyaMainPage.usingScrolling();

			/**
			 * USING MOUSE
			 */

			emergyaMainPage.usingMouse();

		} catch (Exception e) {
			log.error(e);
			Assert.fail();
		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "uploadAnImage")
	public void uploadAnImage(Method method) throws InterruptedException, AWTException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		driver.navigate().to("https://imgbb.com/upload");

		// Checking if is the Page is Ready
		isReady(imgbbMainPage = new ImgbbMainPage(driver));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on the Upload Button
		assertTrue("Error clicking on UploadLogoButton", imgbbMainPage.clickOnUploadLogoButton());
		Thread.sleep(1000);

		// Select the file through the robot
		imgbbMainPage.uploadTheFileByRobot("imageTest.png");
		Thread.sleep(1000);

		// Click on the Upload button wich appears if a correct file
		imgbbMainPage.clickOnUpload();
		Thread.sleep(5000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());

	}

	// ************************ Methods *************************
	/**
	 * Checks if the search return several results
	 * 
	 * @return true if there are several results and false in the opposite case
	 */
	public boolean checkSeveralResults() {
		String resultClassName = "r";
		List<WebElement> elements = null;
		boolean isSeveral = false;

		driver.wait(By.className(resultClassName), 20);

		if (driver.isElementDisplayed(By.className(resultClassName))) {
			elements = driver.findElements(By.className(resultClassName));

			if (elements.size() > 1) {
				isSeveral = true;
			}
		}

		return isSeveral;
	}

	// ************************ Assertions *************************
	/**
	 * This assertion check if the search return several results
	 */
	public void areSeveralResults() {
		assertTrue("There aren't several results, it should have several results", this.checkSeveralResults());
	}

	/**
	 * This assertion check if logo is displayed
	 */
	public void isLogoDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The logo isn't displayed, it should be displayed", googleMainPage.isLogoDisplayed());
	}

	/**
	 * This assertion check if search button is displayed
	 */
	public void isSearchButtonDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}

		/* Check by Name */
		assertTrue("The search button isn't displayed, it should be displayed",
				googleMainPage.isSearchButtonDisplayed());
	}

	/**
	 * This assertion check if luck button is displayed
	 */
	public void isLuckButtonDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The luck button isn't displayed, it should be displayed", googleMainPage.isLuckButtonDisplayed());
	}

	/**
	 * This assertion check if search field is displayed
	 */
	public void isSearchFieldDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The search field isn't displayed, it should be displayed", googleMainPage.isSearchFieldDisplayed());
	}

	/**
	 * This assertion check if emergya logo is displayed
	 */
	public void isEmergyaLogoDisplayed() {
		if (emergyaMainPage == null) {
			emergyaMainPage = new EmergyaMainPage(driver);
		}
		assertTrue("The logo isn't displayed, it should be displayed", emergyaMainPage.isEmergyaLogoDisplayed());
	}

}
