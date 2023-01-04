package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjetcs.AddCustomerPage;
import pageObjetcs.LoginPage;
import pageObjetcs.SearchCustomerPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	
	public Properties properties;
	
	public Logger logger;
	
	public String randomString() {
		String text = RandomStringUtils.randomAlphabetic(5);
		return text;
	}
}
