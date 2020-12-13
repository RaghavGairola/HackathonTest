package com.hack.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hack.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR:
	@FindBy(id="search")
	WebElement searchBar;

	@FindBy(xpath = "//span[@class='search-icon icofont-search']")
	WebElement searchIcon;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String homePageTitle() {
		return driver.getTitle();
	}

	public SearchResultPage search(String keyword) {
		searchBar.sendKeys(keyword);
		searchIcon.click();

		return new SearchResultPage();
	}

}
