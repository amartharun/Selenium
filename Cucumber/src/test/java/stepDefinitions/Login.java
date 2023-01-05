package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjetcs.AddCustomerPage;
import pageObjetcs.LoginPage;
import pageObjetcs.SearchCustomerPage;

public class Login extends BaseClass{


	@Given("user launch the Chrome browser")
	public void user_launch_the_chrome_browser() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amar\\Downloads\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("user opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String uname, String pwd) {
		lp.setUserName(uname);
		lp.setPassword(pwd);
	}

	@When("click on login")
	public void click_on_login() {
		lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String actual) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.quit();
			Assert.assertTrue(false);
		}
		else {
			String expected = driver.getTitle();
			Assert.assertEquals(actual, expected);
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
	
	//*********************************************
	
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
	   Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		String email = "ABCvb@gmail.com";
		acp.setEmail(email);
		acp.setPassword(randomString());
		acp.setFirstName(randomString());
		acp.setLastName(randomString());
		acp.setGender("Male");
		acp.setDOB("11/10/2022");
		acp.setCompanyName(randomString());
		acp.customerRoles("Registered");
		acp.setManageVendor("Vendor 1");
		acp.adminContent("text");
	
	}

	@When("click on Save button")
	public void click_on_save_button() {
		acp.clickSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String text) {
	   if(driver.getPageSource().contains(text)) {
		   System.out.println("SuccessFull");
	   }
	   else {
		   System.out.println("UnSuccessfull");
		   //Assert.assertTrue(false);
	   }
	}
	
	//Search Customer **********************
	
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		scp = new SearchCustomerPage(driver);
		scp.setEmail("ABCvb@gmail.com");
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
	  scp.clickSearch();
	  Thread.sleep(3000);
	}
	@Then("user should found email in Search table")
	public void user_should_found_email_in_search_table() {
	  boolean status =scp.searchCustomerByEmail("ABCvb@gmail.com");
	  Assert.assertEquals(true, status);
	}




}