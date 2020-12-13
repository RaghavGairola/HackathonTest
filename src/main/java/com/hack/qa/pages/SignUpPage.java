package com.hack.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hack.qa.base.TestBase;

public class SignUpPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath="//input[@placeholder='Email Address*']")
	WebElement username;

	@FindBy(xpath="//input[@placeholder='Password*' and @type='password']")
	WebElement password;

	@FindBy(xpath="//input[@value='Sign Up']")
	WebElement signUpBtn;

	// closeBtn
	@FindBy(xpath="//a[contains(text(),'Close')]")
	WebElement closeBtn;

	// image
	@FindBy(xpath="//img[contains(@class,'prodimg')]")
	WebElement signUpPageImage;

	@FindBy(xpath="//div[contains(text(),'SIGN UP FOR SALE UPDATES')]")
	WebElement signUpMsg;
	
	@FindBy(xpath="//a[contains(text(),'Log-in')]")
	WebElement loginLink;
	
	//li[contains(text(),'Email has already been taken')]

	// Initializing the Page Objects:
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String signUpPageTitle() {
		return driver.getTitle();
	}

	public boolean validateSignUpPageImage() {
		return signUpPageImage.isDisplayed();
	}

	public HomePage signUp(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signUpBtn.click();

		return new HomePage();
	}

	public WebElement signUpMsgElement() {
		return signUpMsg;
	}
	
	public LoginPage clickOnloginLink() {
		loginLink.click();
		return new LoginPage();
	}
	
	public HomePage clickOnCloseBtn() {
		closeBtn.click();
		return new HomePage();
	}
}
