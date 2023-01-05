package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjetcs.AddCustomerPage;
import pageObjetcs.LoginPage;
import pageObjetcs.SearchCustomerPage;

public class BaseClass {

	public LoginPage lp;
	public WebDriver driver;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;


	public String randomString() {
		String text = RandomStringUtils.randomAlphabetic(5);
		return text;
	}

}
