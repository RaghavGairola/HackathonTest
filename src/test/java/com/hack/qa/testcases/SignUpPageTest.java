package com.hack.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hack.qa.base.TestBase;
import com.hack.qa.pages.HomePage;
import com.hack.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase {

	SignUpPage signUpPage;
	HomePage homePage;

	public SignUpPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.signUpMsgElement()));
	}
	
	@Test(priority=1)
	public void signUpPageTitleTest() {
		String title = signUpPage.signUpPageTitle();
		Assert.assertEquals(title, "Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder");
	}
	
	@Test(priority=2)
	public void signUpPageImageTest() {
		boolean flag = signUpPage.validateSignUpPageImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void signUpTest() {
		homePage = signUpPage.signUp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
