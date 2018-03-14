package com.emergya.utils;

import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.VeechCollectionPage;
import com.emergya.pageObjects.VeechLoginPage;
import com.emergya.pageObjects.VeechMainPage;
import com.emergya.selenium.testSet.DefaultTestSet;

/**
 * PageObjects variable references
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 */
public abstract class BasicTestSet extends DefaultTestSet {
    protected GoogleMainPage googleMainPage;
    protected EmergyaMainPage emergyaMainPage;
    protected VeechMainPage veechMainPage;
    protected VeechLoginPage veechLoginPage;
    protected VeechCollectionPage veechCollectionPage;
}
