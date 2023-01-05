package pageObjetcs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Handler;



public class LoginPage {
	
	public WebDriver driver;
	public Handler handler;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		handler = new Handler(driver);
	}

	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement btnLogout;
	
	
	public void setUserName(String uname) {
		handler.waitForElement(email, 10);
		email.clear();
		email.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
