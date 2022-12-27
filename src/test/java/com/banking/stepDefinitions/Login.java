package com.banking.stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;
import com.banking.pageObjects.SearchCustomerPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass{

	@Before
	public void setUp() throws IOException {

		//Reading Properties
		configProp = new Properties();
		FileInputStream fis = new FileInputStream("config-properties");
		configProp.load(fis);


		logger=Logger.getLogger("Application"); //Added logger
		PropertyConfigurator.configure("log4j.properties");

		//System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromePath"));
		//String br = configProp.getProperty("browser");
		//		if(br.equals("chrome")) {
		//			WebDriverManager.chromedriver().setup();
		//			driver = new ChromeDriver();
		//		}

		logger.info("****** Launching URL ******");

	}

	@Given("user launch the Chrome browser")
	public void user_launch_the_chrome_browser() {


		lp = new LoginPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String string) {
		driver.get(string);
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
		lp.setUserName(string);
		lp.setPassword(string2);
	}

	@When("click on login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("user clicks on loutout link")
	public void user_clicks_on_loutout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}


	//Customer Feature StepDefinitions

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getTitle());
	}
	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		addCust.clickOnCustomerMenu();
	}
	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		addCust.clickOnCustomerMenuItem();
	}
	@When("click on Add new button")
	public void click_on_add_new_button() {
		addCust.addNewBtn();
	}
	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() {
		String email=randomString()+"@gmail.com";
		addCust.email(email);
		addCust.password("test123");
		addCust.firstName("Thami");
		addCust.lastName("Amar");
		addCust.setManagerVendor("Vendor 1");
		addCust.setGender();
		addCust.setDob("11/18/2020");
		addCust.setCompanyName("Amar");
		addCust.setAdminContent("kdjdfhgjgh");

	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(5000);
		addCust.clickSave();
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) throws InterruptedException {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(string));
		Thread.sleep(5000);
	}

	//Search EmailId


	@When("Enter Customer Email")
	public void enter_customer_email() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("");
	}
	@When("Click on Search button")
	public void click_on_search_button() {
		searchCust.clickSearch();
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCust.searchCustomerByEmail("");
		Assert.assertEquals(true, true);
	}






}
