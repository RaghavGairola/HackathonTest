package com.hack.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hack.qa.base.TestBase;

public class SearchResultPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "//h2[contains(text(),'Search results for ')]/span[contains(text(),'Bookshelves')]")
	WebElement searchedItemLabel;

	@FindBy(xpath = "//div[contains(text(),'Category')]")
	WebElement categoryTab;

	// @FindBy(id = "filters_primary_category_Bookshelves")
	// WebElement bookshelves;

	@FindBy(xpath = "//div[contains(text(),'Price')]")
	WebElement priceTab;

	@FindBy(xpath = "//div[contains(text(),'Storage Type')]")
	WebElement storageTypeTab;

	@FindBy(xpath = "//div[contains(text(),'Type')][2]")
	WebElement typeTab;

	// Initializing the Page Objects:
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String SearchResultPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectItem() {
		return searchedItemLabel.isDisplayed();
	}

	// name = Bookshelves
	public void selectCategoryByName(String name) {
		Actions action = new Actions(driver);
		action.moveToElement(categoryTab).build().perform();
		driver.findElement(
				By.xpath("//label[contains(text(),'" + name + "')]//preceding-sibling::input[@type='checkbox']"))
				.click();
	}
	
	public WebElement priceTabElement() {
		return priceTab;
	}
	
	public void selectPriceUpperLimit(int priceUL) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(priceTab));
		Actions action = new Actions(driver);
		action.moveToElement(priceTab).build().perform();
		
		WebElement dragAble = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-upper']"));

		int xOffset = -(41399 - priceUL)*100/12769;
		action.dragAndDropBy(dragAble, xOffset, 0).build().perform();
	}

}
