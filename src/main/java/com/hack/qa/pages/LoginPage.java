package com.hack.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hack.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//div[@id='password-credentials']//input[@id='spree_user_email']")
	WebElement username;
	
	////input[@placeholder='Password*' and @type='password']
	@FindBy(xpath="//div[@id='password-credentials']//input[@id='spree_user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign-up')]")
	WebElement signUpBtn;
	
	//closeBtn
	@FindBy(xpath="//a[contains(text(),'Close')]")
	WebElement closeBtn;
	
	//image
	@FindBy(xpath="//img[contains(@class,'prodimg')]")
	WebElement loginPageImage;
	
	@FindBy(xpath="//div[@class='login-message']")
	WebElement loginMsg;
	
	//Initializing the Page Objects:
	public LoginPage () {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageImage() {
		return loginPageImage.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public WebElement loginMsgElement() {
		return loginMsg;
	}

}
