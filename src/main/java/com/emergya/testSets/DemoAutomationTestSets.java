package com.emergya.testSets;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.DemoAutomationTestingAlertsPage;
import com.emergya.pageObjects.DemoAutomationTestingMainPage;
import com.emergya.pageObjects.DemoAutomationTestingRegisterPage;
import com.emergya.utils.BasicTestSet;
import com.emergya.utils.UserBean;
import com.google.gson.Gson;

public class DemoAutomationTestSets extends BasicTestSet {

	/**
	 * Logger
	 */

	static Logger log = Logger.getLogger(DemoAutomationTestSets.class);

	/**
	 * CONSTANTS
	 */

	private static final String URL_INDEX = "http://demo.automationtesting.in/Index.html";
	private static final String URL_REGISTER = "http://demo.automationtesting.in/Register.html";
	private static final String URL_WEBTABLE = "http://demo.automationtesting.in/WebTable.html";
	private static final String URL_ALERTS = "http://demo.automationtesting.in/Alerts.html";

	// REGISTER TEST
	private static final String JSON_USER_PATH = "src/main/resources/files/json/register.json";
	private static final String IMAGE_TO_UPLOAD = "imageTest.png";

	// ALERTS TEST
	private static final String MESSAGE_TO_ALERT_WITH_TEXT_BOX = "Hi Mr.Alert TxtBox";

	/*
	 * CONSTRUCTOR
	 */
	public DemoAutomationTestSets() {
		super();
	}

	/**
	 * Pre-Steps for every test in the class
	 */
	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	/**
	 * Post-Steps for every test in the class
	 */
	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	/**
	 * TEST THE INDEX PAGE
	 * 
	 * - Check is displayed - Check the "Sign-in" button link - Check the "Skip Sign
	 * in" link button - Check the "Register with a mail" form
	 * 
	 * @param method
	 * @throws InterruptedException
	 */

	@Test(description = "checkingIndexPage")
	public void checkingIndexPage(Method method) throws InterruptedException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start checkingIndexPage test method: "
				+ method.getName());

		// SoftAssert softAssertion = new SoftAssert();

		// Go to the page
		driver.navigate().to(URL_INDEX);

		// Check if the page is ready
		isReady(demoAutomationTestingMainPage = new DemoAutomationTestingMainPage(driver));

		// Check the "Sign-in" button link
		demoAutomationTestingSignInPage = demoAutomationTestingMainPage.clickSignInButton();
		assertTrue(demoAutomationTestingSignInPage.isReady(),
				"Couldnt Reach Sign In Page when clicked on 'Sign in button'");
		Thread.sleep(1500);
		driver.navigate().back();

		// Check the "Skip Sign in" link button
		demoAutomationTestingRegisterPage = demoAutomationTestingMainPage.clickSkipSignInButton();
		assertTrue(demoAutomationTestingRegisterPage.isReady(),
				"Couldnt Reach Register Page when clicked on 'Skip Sign in button'");
		Thread.sleep(1500);
		driver.navigate().back();

		// Check the "Register with a mail" form, it should send u to the register page
		// with the field "email" filled with the string we passed

		String email = "me@me.com";
		demoAutomationTestingRegisterPage = demoAutomationTestingMainPage.fillFormAndSubmit(email);
		assertTrue(demoAutomationTestingRegisterPage.isReady(),
				"Couldnt Reach Register Page when fill the form and submit'");
		demoAutomationTestingRegisterPage.checkIfEmailPassedIsOnTheForm(email);
		Thread.sleep(1500);
		driver.navigate().back();

		log.info("[log-TestSet] " + this.getClass().getName() + " - End checkingIndexPage test method: "
				+ method.getName());

	}

	// *********************** TESTS ************************* //
	// ---------------- DemoAutomationTesting --------------- //
	// ------ US00001 - Check Register Page of the app ------ //
	/**
	 * Description: Test the Register Page and form of the app, using Json as an
	 * entry format with the data of a fictional user, in order to test all the
	 * possibilities when registring.
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to the RegisterPage - Check that the form is displayed - Read the
	 * json file and fill an object with the data - Test every field of the form
	 * sending as argument the fields of the object filled with the json - Check
	 * that several results are displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @author acosanchez <acosanchez@emergya.com>
	 * @param method
	 * @throws InterruptedException
	 * @throws FileNotFoundException
	 * @throws AWTException
	 * 
	 */

	@Test(description = "checkingRegisterPageWithJson")
	public void checkingRegisterPageWithJson(Method method)
			throws InterruptedException, FileNotFoundException, AWTException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start checkingRegisterPage test method: "
				+ method.getName());

		// Go to the page
		driver.navigate().to(URL_REGISTER);

		// Check if the page is ready
		isReady(demoAutomationTestingRegisterPage = new DemoAutomationTestingRegisterPage(driver));

		// Get info from the Json

		BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_USER_PATH));
		Gson gson = new Gson();
		UserBean user = gson.fromJson(bufferedReader, UserBean.class);

		// TESTING REFRESH BUTTON
		assertTrue(demoAutomationTestingRegisterPage.putNameOnForm(user.getName()), "Error inserting name");
		assertTrue(demoAutomationTestingRegisterPage.pulseRefreshButton(), "Error pressing Refresh Button");
		assertTrue(demoAutomationTestingRegisterPage.checkIfNameIsEmpty(),
				"Refresh button didn't worked, name still not empty");

		// TESTING UPLOAD IMAGE
		assertTrue(demoAutomationTestingRegisterPage.uploadImage(IMAGE_TO_UPLOAD), "Error uploading the image");

		// TESTING THE FORM
		assertTrue(demoAutomationTestingRegisterPage.putNameOnForm(user.getName()), "Error inserting name");
		assertTrue(demoAutomationTestingRegisterPage.putLastNameOnForm(user.getLastName()),
				"Error inserting lastname ");
		assertTrue(demoAutomationTestingRegisterPage.putAdressOnForm(user.getAdress()), "Error inserting lastname");
		assertTrue(demoAutomationTestingRegisterPage.putEmailOnForm(user.getEmail()), "Error inserting email");
		assertTrue(demoAutomationTestingRegisterPage.putPhoneOnForm(user.getPhone()), "Error insterting phone");
		assertTrue(demoAutomationTestingRegisterPage.putGender(user.getGender()), "Error inserting gender");
		assertTrue(demoAutomationTestingRegisterPage.putHobbies(user.getHobbies()), "Error inserting hobbies");
		assertTrue(demoAutomationTestingRegisterPage.putLanguages(user.getLanguages()), "Error selecting languages");
		assertTrue(demoAutomationTestingRegisterPage.putSkills(user.getSkills()), "Error selecting skills");
		assertTrue(demoAutomationTestingRegisterPage.PutCountry(user.getCountry()), "Error selecting country");

		assertTrue(demoAutomationTestingRegisterPage.PutSecondCountry(user.getSecondCountryTextEntry(),
				user.getSecondCountryChoose()), "Error selectin secondCountry");

		Thread.sleep(2000); // Espera para que no haya conflicto en el visionado del select de BirthYear
							// (siguiente metodo)

		assertTrue(demoAutomationTestingRegisterPage.PutBirthYear(user.getBirthYear()), "Error selecting year");
		assertTrue(demoAutomationTestingRegisterPage.PutBirthMonth(user.getBirthMonth()), "Error selecting month");
		assertTrue(demoAutomationTestingRegisterPage.PutBirthDay(user.getBirthDay()), "Error selecting day");
		assertTrue(demoAutomationTestingRegisterPage.putPassword(user.getPassword()), "error inserting password");
		assertTrue(demoAutomationTestingRegisterPage.putVerifiedPassword(user.getPasswordVerified()),
				"error inserting password");

		// Submit and test if register was OK

		demoAutomationTestingWebtablePage = demoAutomationTestingRegisterPage.submitRegisterForm();

		if (driver.getCurrentUrl() != URL_WEBTABLE) {
			demoAutomationTestingRegisterPage.checkErrorLabels();
			assertTrue(false,
					"Couldnt Reach the WebTable Page, so something is wrong on the form when fill the form and submit'");
		} else {
			assertTrue(demoAutomationTestingWebtablePage.isReady(), "WebTable Page Reached, but not ready");
			driver.navigate().back();
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End checkingRegisterPage test method: "
				+ method.getName());

		/*
		 * TODO - Que siempre funcione el putLanguages TODO - Que siempre funciones el
		 * putSecondCountry TODO - Metodo del refresh TODO - Upload image TODO -
		 * Eliminar system.err que queden en el codigo TODO - Conseguir que el assert
		 * envíe directamente la informacion del pop-up que sale al, por ejemplo,
		 * registrarte con un numero de telefono que ya esta usado. TODO - TESTING
		 * SUBMITWITHOUT NAME TO GET THE POPUP
		 */
	}

	@Test(description = "checkingSwitchToPage")
	public void checkingSwitchToPage(Method method) throws InterruptedException {

		log.info("[log-TestSet] " + this.getClass().getName() + " - Start checkingRegisterPage test method: "
				+ method.getName());

		// GO TO THE PAGE WE WANT TO TEST

		driver.navigate().to(URL_ALERTS);

		// CHECK IF THE PAGE IS READY

		isReady(demoAutomationTestingAlertsPage = new DemoAutomationTestingAlertsPage(driver));

		// TESTING ALERT WITH TEXT

		demoAutomationTestingAlertsPage.clickOnAlertWithTextBox();
		demoAutomationTestingAlertsPage.clickOnAlertWithTextBoxButtonToDisplay(MESSAGE_TO_ALERT_WITH_TEXT_BOX);

		// TESTING ALERT WITH OK

		demoAutomationTestingAlertsPage.clickOnAlertWithOk();
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay();

		// TESTING ALERT WITH OK AND CANCEL

		demoAutomationTestingAlertsPage.clickOnAlertWithOkAndCancel();
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay("cancel");
		Thread.sleep(3000);
		demoAutomationTestingAlertsPage.clickOnAlertWithOkButtonToDisplay("ok");

		Thread.sleep(3000);

		log.info("[log-TestSet] " + this.getClass().getName() + " - End checkingRegisterPage test method: "
				+ method.getName());

	}

}
