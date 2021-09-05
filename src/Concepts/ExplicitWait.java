package Concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		//dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);//to load page
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//to load all elements in the page
		
		//Explicit Wait--waiting for specific element in the page to load 
		clickOn(driver,driver.findElement(By.name("login")),20);
		

	}
	public static void clickOn(WebDriver driver,WebElement locator,int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
