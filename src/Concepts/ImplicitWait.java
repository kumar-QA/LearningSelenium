package Concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://jqueryui.com/droppable/");//enter url
		
		driver.manage().window().maximize();//maxmize window
		driver.manage().deleteAllCookies();//delete all cookies
		
		//Static wait--complusory we need to wait
	
//		Thread.sleep(3000);//3seconds
		
		//dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

}
