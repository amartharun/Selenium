package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjetcs.AddCustomerPage;
import pageObjetcs.LoginPage;
import pageObjetcs.SearchCustomerPage;

public class Login extends BaseClass {


	@Before
	public void setUp() throws IOException {
		
		logger = Logger.getLogger("Automation Testing"); //Added logger
		PropertyConfigurator.configure("log4j.properties"); //path of log4j file
		
		
		properties = new Properties();
		FileInputStream fis = new FileInputStream("config-properties");
		properties.load(fis);

		
		String br = properties.getProperty("browser");
		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		logger.info("*****Launching Browser******");

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("user launch the Chrome browser")
	public void user_launch_the_chrome_browser() {
		lp = new LoginPage(driver);

	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		logger.info("Url has been opened");
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {

		lp.setUserName(uname);
		lp.setPassword(pwd);
		logger.info("usr entered the username  and password");
	}

	@When("click on login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.quit();
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("user clicks on loutout link")
	public void user_clicks_on_loutout_link() {
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	//Customer Feature Step Definitions


	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		acp = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getTitle());
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		acp.clickCustomerMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		acp.clickCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		acp.addNew();
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration",acp.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		String email = randomString()+"@gmail.com";
		acp.setEmail(email);
		acp.setPassword("test123");
		acp.setFirstName("Test");
		acp.setLastName("Automation");
		acp.setGender("male");
		acp.setDOB("12/12/2005");
		acp.setCompanyName("Automation");
		acp.customerRoles("Guests");
		acp.adminContent("testing");
		acp.setManageVendor("Vendor 1");
	}
	@When("click on Save button")
	public void click_on_save_button() {
		acp.clickSave();
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
	}

	//Search Customer by Email Id

	@When("Enter Customer EmailId")
	public void enter_customer_email_id() {
		scp = new SearchCustomerPage(driver);
		scp.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("I click on Search button")
	public void i_click_on_search_button() throws InterruptedException {
		scp.clickSearch();
	}
	@Then("User should found in the search table")
	public void user_should_found_in_the_search_table() {
		boolean status = scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(status,true);
	}




}
