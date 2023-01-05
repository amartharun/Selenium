package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Handler {

	public WebDriver driver;
	WebDriverWait wait;

	public Handler(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElement(WebElement element, long timeOutInSeconds) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void launchApplicationURL(String url) {
		driver.get(url);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitForElementTextTobePresentTextbox(WebElement element, long timeOutInSeconds) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
