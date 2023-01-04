package pageObjetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	WebElement txtUname;
	
	@FindBy(id="Password")
	WebElement txtpwd;
	
	@FindBy(xpath="//*[text()='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement btnLogout;
	
	//Action Methods
	
	public void setUserName(String uname) {
		txtUname.clear();
		txtUname.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
