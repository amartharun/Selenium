package frameworks.waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	public WebDriver driver;
	
	public Waits(WebDriver driver) {
		this.driver= driver;		
	}
	
	public void waitForElement(WebElement element, long timeOutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
