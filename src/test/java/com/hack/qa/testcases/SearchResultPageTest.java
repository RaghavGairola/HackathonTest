package com.hack.qa.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hack.qa.base.TestBase;
import com.hack.qa.pages.HomePage;
import com.hack.qa.pages.SearchResultPage;
import com.hack.qa.pages.SignUpPage;
import com.hack.qa.util.TestUtil;

public class SearchResultPageTest extends TestBase {
	
	SignUpPage signUpPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	String sheetName = "filters";
	
	public SearchResultPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.elementToBeClickable(signUpPage.signUpMsgElement()));
		homePage = signUpPage.clickOnCloseBtn();
		searchResultPage = homePage.search("Bookshelves");
	}
	
	@Test(priority=1)
	public void SearchResultPageTitleTest() {
		String title = searchResultPage.SearchResultPageTitle();
		Assert.assertEquals(title, "Furniture Online: Buy Home Wooden Furniture "
				+ "Online In India At Best Price - Urban Ladder - Urban Ladder","HomePage Title not matched");
	}
	
	@Test(priority=2)
	public void verifyItemTest() {
		Assert.assertTrue(searchResultPage.verifyCorrectItem());
	}
	
//	@Test(priority=3)
	public void selectBookshelvesCategoryTest() {
		searchResultPage.selectCategoryByName("Bookshelves");
	}
	
//	@Test(priority=4)
	public void selectfilters() {
		searchResultPage.selectCategoryByName("Bookshelves");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.priceTabElement()));
		searchResultPage.selectPriceUpperLimit(5000);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getHackTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=5, dataProvider="getHackTestData")
	public void selectfiltersTest(String category, String price) {
		searchResultPage.selectCategoryByName(category);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.priceTabElement()));
		System.out.println("price: " + (int) Double.parseDouble(price));
		searchResultPage.selectPriceUpperLimit((int) Double.parseDouble(price));
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
