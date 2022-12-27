package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="Email")
	WebElement txtUserName;
	
	@FindBy(name="Password")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[text()='Log in']")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	
	public void setUserName(String uName) {
		txtUserName.clear();
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
