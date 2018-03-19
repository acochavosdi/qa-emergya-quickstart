package com.emergya.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ImgbbMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(GoogleMainPage.class);

	/**
	 * Items keys selectors.
	 */
	public static final String LOGO_MAIN_PAGE = "logomainpage";
	public static final String UPLOAD_BUTTON = "uploadButton";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public ImgbbMainPage(EmergyaWebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isReady() {

		boolean status;
		status = this.isElementVisibleById(LOGO_MAIN_PAGE);
		return status;
	}

	public boolean clickOnUploadLogoButton() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnUploadLogoButton method");

		boolean status = false;

		if (this.isElementVisibleById(LOGO_MAIN_PAGE)) {
			this.getElementById(LOGO_MAIN_PAGE).click();
			status = true;
		}
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnUploadLogoButton method");

		return status;
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	public static void setClipboardData(String string) {

		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}

	public void uploadTheFileByRobot(String imageFile) throws AWTException {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start uploadTheFileByRobot method");

		File auxfile = new File("src/main/resources/files/" + imageFile);
		String fileName = auxfile.getAbsolutePath();

		try {
			// Setting clipboard with file location
			setClipboardData(fileName);
			// native key strokes for CTRL, V and ENTER keys
			// Some sleep time to detect the window popup
			Thread.sleep(500);

			Robot robot = new Robot();

			// Delete the default string
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_END);
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);

			// Copy the path to the window popup
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);

			// Press enter to execute a file search
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(500);

			Thread.sleep(5000);

		} catch (Exception e) {
			log.error("Exception when using robot on uploadTheFileByRobot method");
		}

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnUploadLogoButton method");

	}

	public boolean clickOnUpload() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnUpload method");

		boolean status = false;

		if (this.isElementVisibleByXPath(UPLOAD_BUTTON)) {
			this.getElementByXPath(UPLOAD_BUTTON).click();
			status = true;
		}
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnUpload method");

		return status;
	}

}
