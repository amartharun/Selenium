package pageObjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomersMenu;

	//By lnkCustomersMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");

	By lnkCustomersMenuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By addNewBtn=By.xpath("//a[@class='btn btn-primary']");

	By email=By.xpath("//input[@id='Email']");

	By password=By.xpath("//input[@id='Password']");

	By firstName=By.xpath("//input[@id='FirstName']");

	By lastName=By.xpath("//input[@id='LastName']");

	By genderMale=By.id("Gender_Male");
	By genderFemale=By.id("Gender_Female");

	By txtDOb=By.id("DateOfBirth");

	By txtCompanyName=By.id("Company");

	By customerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

	By lstItemAdministrator=By.xpath("//li[contains(text(),'Administrators')]");
	By lstItemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstItemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstItemVendors=By.xpath("//li[contains(text(),'Vendors')]");

	By managerOfVendor=By.id("VendorId");

	By adminContent=By.id("AdminComment");

	By save = By.name("save");

	//Action Methods

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickCustomerMenu() {
		lnkCustomersMenu.click();
	}

	public void clickCustomerMenuItem() {
		driver.findElement(lnkCustomersMenuItem).click();
	}

	public void addNew() {
		driver.findElement(addNewBtn).click();
	}

	public void setEmail(String uname) {
		driver.findElement(email).sendKeys(uname);
	}

	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void setFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void setLastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}

	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			driver.findElement(genderMale).click();
		}
		else {
			driver.findElement(genderFemale).click();
		}
	}

	public void setDOB(String date) {
		driver.findElement(txtDOb).sendKeys(date);
	}

	public void setCompanyName(String company) {
		driver.findElement(txtCompanyName).sendKeys(company);		
	}

	public void customerRoles(String role) {

		driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']/ul/li/span[2]")).click();
		 
		WebElement listItem;
		
		if(role.equalsIgnoreCase("Administrators")) {
			listItem = driver.findElement(lstItemAdministrator);
		}
		else if(role.equalsIgnoreCase("Registered")) {
			listItem = driver.findElement(lstItemRegistered);
		}
		else {
			listItem = driver.findElement(lstItemGuests);
		}
		
		//listItem.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", listItem);

	}

	public void setManageVendor(String vendor) {
		Select select = new Select(driver.findElement(managerOfVendor));
		select.selectByVisibleText(vendor);
	}

	public void adminContent(String text) {
		driver.findElement(adminContent).sendKeys(text);
	}

	public void clickSave() {
		driver.findElement(save).click();
	}
}

