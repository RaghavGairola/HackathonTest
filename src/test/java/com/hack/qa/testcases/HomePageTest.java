package com.hack.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hack.qa.base.TestBase;
import com.hack.qa.pages.HomePage;
import com.hack.qa.pages.SearchResultPage;
import com.hack.qa.pages.SignUpPage;

public class HomePageTest extends TestBase {
	
	SignUpPage signUpPage;
	HomePage homePage;
	SearchResultPage searchResultPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.signUpMsgElement()));
		signUpPage.clickOnCloseBtn();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.homePageTitle();
		Assert.assertEquals(title, "Furniture Online: Buy Home Wooden Furniture "
				+ "Online In India At Best Price - Urban Ladder - Urban Ladder","HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void searchTest() {
		searchResultPage = homePage.search("Bookshelves");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
