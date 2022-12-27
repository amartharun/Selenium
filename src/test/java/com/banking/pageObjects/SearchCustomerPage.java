package com.banking.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.banking.utilities.WaitHelper;

public class SearchCustomerPage{

	public WebDriver driver;
	public WaitHelper waitHelper;


	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
	}

	@FindBy(how = How.ID, using="SearchEmail")
	WebElement txtEmail;

	@FindBy(how = How.XPATH, using="//li[contains(text(),'Vendors')]")
	WebElement lstitemVendor;

	@FindBy(how=How.ID, using="search-customers")
	WebElement btnSearch;

	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;


	public void setEmail(String email) {
		waitHelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void clickSearch() {

	}

	public int getNoOfRows() {
		return tableRows.size();
	}

	public int getNoOfColumns() {
		return tableColumns.size();
	}

	public boolean searchCustomerByEmail(String email) {

		boolean flag = false;

		for(int i=1;i<=getNoOfRows();i++) {

			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals(email)) {
				flag=true;
			}
		}
		return flag;

	}

	public boolean searchCustomerByName(String Name) {

		boolean flag = false;

		for(int i=1;i<=getNoOfRows();i++) {

			String name=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();

			String names[]=name.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag=true;
			}
		}
			return flag;
	}

}
