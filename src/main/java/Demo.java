import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	
	
	driver.findElement(By.xpath("//*[text()='Log in']")).click();
	
	driver.findElement(By.xpath("//a[@href='#']//p[contains(text(),'Customers')]")).click();
	
	driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")).click();
	
	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	
	driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']/ul/li/span[2]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[text()='Customer roles']/../../following-sibling::div//div[@class='k-multiselect-wrap k-floatwrap']")).click();
	
	WebElement listItem = driver.findElement(By.xpath("//li[contains(text(),'Administrators')]"));
	
	listItem.click();
//	JavascriptExecutor js = (JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click();",listItem);

	
	}
}
