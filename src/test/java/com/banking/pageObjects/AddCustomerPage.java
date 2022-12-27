package com.banking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage{

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	By lnkCustomersMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomersMenuItem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By addNewBtn=By.xpath("//a[@class='btn btn-primary']");

	By email=By.xpath("//input[@id='Email']");

	By password=By.xpath("//input[@id='Password']");

	By firstName=By.xpath("//input[@id='FirstName']");

	By lastName=By.xpath("//input[@id='LastName']");

	By gender=By.id("Gender_Male");

	By customerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstItemAdministrator=By.xpath("//li[normalize-space()='Administrators']");
	By lstItemRegistered=By.xpath("//li[normalize-space()='Registered']");
	By lstItemGuests=By.xpath("//li[normalize-space()='Guests']");
	By lstItemVendors=By.xpath("//li[normalize-space()='Vendors']");

	By managerOfVendor=By.id("VendorId");

	By txtDOb=By.id("DateOfBirth");

	By txtCompanyName=By.id("Company");

	By adminContent=By.id("AdminComment");
	
	By save = By.name("save");

	//Action Methods

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOnCustomerMenu() {
		driver.findElement(lnkCustomersMenu).click();
	}
	public void clickOnCustomerMenuItem() {
		driver.findElement(lnkCustomersMenuItem).click();
	}

	public void addNewBtn() {
		driver.findElement(addNewBtn).click();
	}

	public void email(String uName) {
		driver.findElement(email).sendKeys(uName);
	}

	public void password(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void firstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void lastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}

	public void setDob(String date) {
		driver.findElement(txtDOb).sendKeys(date);
	}

	public void setCompanyName(String company) {
		driver.findElement(txtCompanyName).sendKeys(company);
	}
	
	public void setAdminContent(String content) {
		driver.findElement(adminContent).sendKeys(content);
	}

	public void setCustomerRoles(String role) {
		if(!role.equals("Vendors")) {
			driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		driver.findElement(customerRole).click();

		if(role.equals("Administrator")) {
			driver.findElement(lstItemAdministrator).click();
		}
		else if(role.equals("Guests")) {
			driver.findElement(lstItemGuests).click();
		}
		else if(role.equals("Registered")) {
			driver.findElement(lstItemRegistered).click();
		}
		else if(role.equals("Vendors")) {
			driver.findElement(lstItemVendors).click();
		}
		else {
			driver.findElement(lstItemGuests).click();
		}
	}

	public void setManagerVendor(String vendor) {
		Select drp = new Select(driver.findElement(managerOfVendor));
		drp.selectByVisibleText(vendor);
	}

	public void setGender() {
		driver.findElement(gender).click();
	}
	
	public void clickSave() {
		driver.findElement(save).click();
	}


}
