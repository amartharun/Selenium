package com.banking.stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;
import com.banking.pageObjects.SearchCustomerPage;

public class BaseClass {

	public LoginPage lp;
	public WebDriver driver;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	public Logger logger;
	
	public Properties configProp;
	
	public String randomString() {
		String string1=RandomStringUtils.randomAlphabetic(5);
		return string1;
	}
}
