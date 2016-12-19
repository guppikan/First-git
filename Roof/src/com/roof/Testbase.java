package com.roof;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Testbase {
	static WebDriver driver;
	static String url = "https://staging.roofstock.com";

	protected void startWebDriver() {
		// setWebDriver(browser);
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// driver = new FirefoxDriver(capabilities);
		// driver.get(url);
		// driver =new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	// TODO: will we need verify methods as well/instead of Assert?

	public static void assertEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void assertNotEquals(Object actual, Object expected) {
		Assert.assertNotEquals(actual, expected);
	}

	public static void assertTrue(boolean expected) {
		Assert.assertTrue(expected);
	}

	public static void assertFalse(boolean expected) {
		Assert.assertFalse(expected);

	}

	public static int RandomValueForQty(int rn) {

		int rn1 = new Random().nextInt(rn);

		return rn1 + 1;
	}

	CharSequence softwareqty1 = Integer.toString(RandomValueForQty(99));

	// Suspect this is actually a verify and not a hard assert?
	public static void assertElementExists(WebElement element) {
		try {
			driver.findElement((By) element);

		} catch (Exception e) {
			// This outputs the dynamic/genereated Webelement id. Would be more
			// useful if the locator could be printed.
			// System.out.print("The element could not be found." + element);

		}
		// Assert.assertNotNull(element);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static String myvalue ="password";
	public static String keys="1625";
	static String uname="abc@amma.com";
	@FindBy(xpath = ".//*[@id='AccessCode']")
	public static WebElement ACCESSCODE;
	@FindBy(xpath = "//*[@name='j_username']")
	public static WebElement USER_ID;
	@FindBy(xpath = "//*[@name='j_password']")
	public static WebElement USER_NAME;
	@FindBy(xpath = ".//input[@value='Submit']")
	public static WebElement SUBMIT_BUTTON;
	@FindBy(xpath = ".//ul/li[5]/a[contains (@href, '/login')]")
	public static WebElement LOGIN_BUTTON;
    @FindBy(xpath = ".//input[contains (@placeholder, 'Your Email')]")
	public static WebElement USERNAME;
	@FindBy(xpath = ".//input[contains (@placeholder, 'Password')]")
	public static WebElement PASSWORD;
	@FindBy(xpath = ".//button[contains(., 'Log In')]")
	public static WebElement LOGIN;
	
	
	public static void LoginToRoof() throws Throwable {

		System.setProperty("webdriver.gecko.driver",
				"D:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capabilities);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		PageFactory.initElements(driver, LoginRoof.class);
		PageFactory.initElements(driver, RoofRepo.class);

		ACCESSCODE.sendKeys(keys);
		SUBMIT_BUTTON.click();
		// USER_NAME.sendKeys(TestBase.MyValue);
		LOGIN_BUTTON.click();
		Thread.sleep(3000);
		try{
			USERNAME.sendKeys(uname);
			PASSWORD.sendKeys(myvalue);
			LOGIN.click();	
		}catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
