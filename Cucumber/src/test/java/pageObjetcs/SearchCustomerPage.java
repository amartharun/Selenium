package pageObjetcs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Handler;

public class SearchCustomerPage {

	public WebDriver driver;
	public Handler handler;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		handler = new Handler(driver);
	}

	@FindBy(how = How.ID , using="SearchEmail")
	WebElement txtEmail;

	@FindBy(how = How.ID , using="search-customers")
	WebElement btnSearch;

	@FindBy(how = How.XPATH , using="//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH , using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH , using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		handler.waitForElement(txtEmail, 20);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}

	public int getRows() {
		return tableRows.size();
	}

	public int getColumns() {
		return tableColumns.size();
	}

	public boolean searchCustomerByEmail(String email) {

		boolean flag = false;
		for(int i=1;i<=getRows();i++) {
			String emailId = table.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;

	}


}
