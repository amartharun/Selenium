package pageObjetcs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver driver;
	public WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		waitHelper = new WaitHelper(driver);
	}
	
	
	@FindBy(how = How.ID, using="SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id="search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRow;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumn;
	
	
	//Action Methods
	
	public void setEmail(String email) {
		waitHelper.waitForElement(txtEmail, 5); //explicit Wait
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void clickSearch() throws InterruptedException {
		btnSearch.click();
		Thread.sleep(3000);
	}
	
	public int getNoOfRows() {
		return tableRow.size();
	}
	
	public int getNoOfColumns() {
		return tableColumn.size();
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows();i++) {
			String emailId =driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}                              
	
	public boolean searchCustomerByName(String fname, String lname) {
		boolean flag = false;
		
		for(int i=1; i<=getNoOfRows();i++) {
			String name =driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name);
			//Victoria Terces
			String[] names = name.split(" ");
			
			if(names[0].equals(fname) && names[1].equals(lname)) {
				flag = true;
			}
		}
		return flag;
	}                   
}                                                                                                              
