package Selenium.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
//    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https:www.google.com");
    	
    	int a[]= {9,8,7,6,2,4,1};
    	
    	for (int i=0;i<=a.length;i++) {
    		//System.out.println(a[i]);
    		if(a[i]%2==0) {
    			System.out.println(a[i]);
    		}
    		
    	}
    	
		
    }
}
