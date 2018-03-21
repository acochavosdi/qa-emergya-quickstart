package com.emergya.utils;

import com.emergya.pageObjects.DemoAutomationTestingMainPage;
import com.emergya.pageObjects.DemoAutomationTestingRegisterPage;
import com.emergya.pageObjects.DemoAutomationTestingSignInPage;
import com.emergya.pageObjects.DemoAutomationTestingWebtablePage;
import com.emergya.pageObjects.EmergyaContactPage;
import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.EmergyaTrabajaConNosotrosPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.ImgbbMainPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {

	// GOOGLE
	protected GoogleMainPage googleMainPage;

	// EMERGYA
	protected EmergyaMainPage emergyaMainPage;
	protected EmergyaContactPage emergyaContactPage;
	protected EmergyaTrabajaConNosotrosPage emergyaTrabajaConNosotrosPage;

	// IMGBB
	protected ImgbbMainPage imgbbMainPage;

	// DEMO.AUTOMATIONTESTING.IN
	protected DemoAutomationTestingMainPage demoAutomationTestingMainPage;
	protected DemoAutomationTestingSignInPage demoAutomationTestingSignInPage;
	protected DemoAutomationTestingRegisterPage demoAutomationTestingRegisterPage;
	protected DemoAutomationTestingWebtablePage demoAutomationTestingWebtablePage;
}
